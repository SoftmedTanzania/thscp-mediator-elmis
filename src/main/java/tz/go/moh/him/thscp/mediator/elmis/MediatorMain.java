package tz.go.moh.him.thscp.mediator.elmis;

import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.MediatorServer;
import org.openhim.mediator.engine.RegistrationConfig;
import org.openhim.mediator.engine.RoutingTable;
import org.openhim.mediator.engine.StartupActorsConfig;
import tz.go.moh.him.thscp.mediator.elmis.orchestrator.EmergencyCommodityStockStatusOrchestrator;
import tz.go.moh.him.thscp.mediator.elmis.orchestrator.ForecastAccuracyPerProgramOrchestrator;
import tz.go.moh.him.thscp.mediator.elmis.orchestrator.LaboratoryDiagnosticEquipmentFunctionalityOrchestrator;
import tz.go.moh.him.thscp.mediator.elmis.orchestrator.PercentageOfReportsAndRequisitionOrchestrator;
import tz.go.moh.him.thscp.mediator.elmis.orchestrator.ReportingTimelinessOrchestrator;
import tz.go.moh.him.thscp.mediator.elmis.orchestrator.StockAvailabilityOrchestrator;
import tz.go.moh.him.thscp.mediator.elmis.orchestrator.StockOnHandStatusOrchestrator;
import tz.go.moh.him.thscp.mediator.elmis.orchestrator.TurnAroundTimeOrchestrator;
import tz.go.moh.him.thscp.mediator.elmis.orchestrator.WorkforceOrchestrator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Represents the main application.
 */
public class MediatorMain {
    /**
     * Represents the mediator registration info.
     */
    private static final String MEDIATOR_REGISTRATION_INFO = "mediator-registration-info.json";

    /**
     * Builds the routing table.
     *
     * @return Returns the routing table.
     * @throws RoutingTable.RouteAlreadyMappedException if the route is already mapped
     */
    private static RoutingTable buildRoutingTable() throws RoutingTable.RouteAlreadyMappedException {
        RoutingTable routingTable = new RoutingTable();
        routingTable.addRoute("/thscp-emergency-commodity-stock-status", EmergencyCommodityStockStatusOrchestrator.class);
        routingTable.addRoute("/thscp-forecast-accuracy-per-program", ForecastAccuracyPerProgramOrchestrator.class);
        routingTable.addRoute("/thscp-laboratory-diagnostic-equipment-functionality", LaboratoryDiagnosticEquipmentFunctionalityOrchestrator.class);
        routingTable.addRoute("/thscp-percentage-of-reports-and-requisition", PercentageOfReportsAndRequisitionOrchestrator.class);
        routingTable.addRoute("/thscp-reporting-timeliness", ReportingTimelinessOrchestrator.class);
        routingTable.addRoute("/thscp-stock-availability", StockAvailabilityOrchestrator.class);
        routingTable.addRoute("/thscp-stock-on-hand", StockOnHandStatusOrchestrator.class);
        routingTable.addRoute("/thscp-turn-around-time-orchestrator", TurnAroundTimeOrchestrator.class);
        routingTable.addRoute("/thscp-workforce", WorkforceOrchestrator.class);

        return routingTable;
    }

    /**
     * Builds the startup actors configuration.
     *
     * @return Returns the startup actors configuration.
     */
    private static StartupActorsConfig buildStartupActorsConfig() {
        StartupActorsConfig startupActors = new StartupActorsConfig();
        return startupActors;
    }

    /**
     * Loads the configuration.
     *
     * @param configPath The path of the configuration.
     * @return Returns the configuration instance.
     * @throws IOException                              if an IO exception occurs
     * @throws RoutingTable.RouteAlreadyMappedException if the route is already mapped
     */
    private static MediatorConfig loadConfig(String configPath) throws IOException, RoutingTable.RouteAlreadyMappedException {
        MediatorConfig config = new MediatorConfig();

        if (configPath != null) {
            Properties props = new Properties();
            File conf = new File(configPath);
            InputStream in = FileUtils.openInputStream(conf);
            props.load(in);
            IOUtils.closeQuietly(in);

            config.setProperties(props);
        } else {
            config.setProperties("mediator.properties");
        }

        config.setName(config.getProperty("mediator.name"));
        config.setServerHost(config.getProperty("mediator.host"));
        config.setServerPort(Integer.parseInt(config.getProperty("mediator.port")));
        config.setRootTimeout(Integer.parseInt(config.getProperty("mediator.timeout")));

        config.setCoreHost(config.getProperty("core.host"));
        config.setCoreAPIUsername(config.getProperty("core.api.user"));
        config.setCoreAPIPassword(config.getProperty("core.api.password"));
        if (config.getProperty("core.api.port") != null) {
            config.setCoreAPIPort(Integer.parseInt(config.getProperty("core.api.port")));
        }

        config.setRoutingTable(buildRoutingTable());
        config.setStartupActors(buildStartupActorsConfig());

        InputStream regInfo = MediatorMain.class.getClassLoader().getResourceAsStream(MEDIATOR_REGISTRATION_INFO);
        RegistrationConfig regConfig = new RegistrationConfig(regInfo);
        config.setRegistrationConfig(regConfig);

        if (config.getProperty("mediator.heartbeats") != null && "true".equalsIgnoreCase(config.getProperty("mediator.heartbeats"))) {
            config.setHeartbeatsEnabled(true);
        }

        return config;
    }

    /**
     * The main entry point of the application.
     *
     * @param args The arguments.
     * @throws Exception if an exception occurs
     */
    public static void main(String... args) throws Exception {
        //setup actor system
        final ActorSystem system = ActorSystem.create("mediator");
        //setup logger for main
        final LoggingAdapter log = Logging.getLogger(system, "main");

        //setup actors
        log.info("Initializing mediator actors...");

        String configPath = null;
        if (args.length == 2 && args[0].equals("--conf")) {
            configPath = args[1];
            log.info("Loading mediator configuration from '" + configPath + "'...");
        } else {
            log.info("No configuration specified. Using default properties...");
        }

        MediatorConfig config = loadConfig(configPath);
        final MediatorServer server = new MediatorServer(system, config);

        //setup shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                log.info("Shutting down mediator");
                server.stop();
                system.shutdown();
            }
        });

        log.info("Starting mediator server...");
        server.start();

        log.info(String.format("%s listening on %s:%s", config.getName(), config.getServerHost(), config.getServerPort()));
        Thread.currentThread().join();
    }
}
