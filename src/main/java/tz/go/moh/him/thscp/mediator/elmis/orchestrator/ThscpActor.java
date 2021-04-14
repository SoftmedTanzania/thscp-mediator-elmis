package tz.go.moh.him.thscp.mediator.elmis.orchestrator;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import org.openhim.mediator.engine.messages.MediatorHTTPResponse;
import org.openhim.mediator.engine.messages.SimpleMediatorRequest;
import tz.go.moh.him.thscp.mediator.elmis.utils.Constants;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThscpActor extends UntypedActor {
    /**
     * The mediator configuration.
     */
    private final MediatorConfig config;
    /**
     * The logger instance.
     */
    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    /**
     * The message type.
     */
    private final String messageType;
    /**
     * The request handler that handles requests and responses.
     */
    private ActorRef requestHandler;


    /**
     * Initializes a new instance of the {@link ThscpActor} class.
     *
     * @param config The mediator configuration.
     */
    public ThscpActor(MediatorConfig config, String messageType) {
        this.config = config;
        this.messageType = messageType;
    }

    /**
     * Forwards the message to the Tanzania Supply Chain Portal
     *
     * @param message to be sent to the Thscp
     */
    private void forwardToThscp(String message) {

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        String scheme;
        String host;
        String path;
        String username;
        String password;
        int portNumber;
        if (config.getDynamicConfig().isEmpty()) {
            log.debug("Dynamic config is empty, using config from mediator.properties");
            if (config.getProperty("destination.scheme").equals("https")) {
                scheme = "https";
            } else {
                scheme = "http";
            }

            host = config.getProperty("destination.host");
            portNumber = Integer.parseInt(config.getProperty("destination.api.port"));
            switch (messageType) {
                case Constants.EMERGENCY_COMMODITY_STOCK_STATUS_REQUEST:
                    path = config.getProperty("destination.api.path.emergency_stock_status");
                    break;
                case Constants.FORECAST_ACCURACY_PER_PROGRAM_REQUEST:
                    path = config.getProperty("destination.api.path.forecast_accuracy_per_program");
                    break;
                case Constants.LABORATORY_DIAGNOSTIC_EQUIPMENT_FUNCTIONALITY_REQUEST:
                    path = config.getProperty("destination.api.path.laboratory_diagnostic_equipment_functionality");
                    break;
                case Constants.PERCENTAGE_OF_REPORTS_AND_REQUISITION_REQUEST:
                    path = config.getProperty("destination.api.path.percentage_of_reports_and_requisition");
                    break;
                case Constants.REPORTING_TIMELINESS_REQUEST:
                    path = config.getProperty("destination.api.path.reporting_timeliness");
                    break;
                case Constants.STOCK_AVAILABILITY_REQUEST:
                    path = config.getProperty("destination.api.path.stock_availability");
                    break;
                case Constants.STOCK_ON_HAND_STATUS_REQUEST:
                    path = config.getProperty("destination.api.path.stock_on_hand");
                    break;
                case Constants.TURN_AROUND_TIME_REQUEST:
                    path = config.getProperty("destination.api.path.turn_around_time");
                    break;
                case Constants.PHARMACEUTICAL_AND_LABORATORY_REQUEST:
                    path = config.getProperty("destination.api.path.pharmaceutical_and_laboratory");
                    break;
                case Constants.PRODUCT_LIST_REQUEST:
                    path = config.getProperty("destination.api.path.product_list");
                    break;
                default:
                    path = null;
                    break;
            }

        } else {
            log.debug("Using dynamic config");

            JSONObject connectionProperties = new JSONObject(config.getDynamicConfig()).getJSONObject("destinationConnectionProperties");

            host = connectionProperties.getString("destinationHost");
            portNumber = connectionProperties.getInt("destinationPort");
            scheme = connectionProperties.getString("destinationScheme");

            if (connectionProperties.has("destinationUsername") && connectionProperties.has("destinationPassword")) {
                username = connectionProperties.getString("destinationUsername");
                password = connectionProperties.getString("destinationPassword");

                // if we have a username and a password
                // we want to add the username and password as the Basic Auth header in the HTTP request
                if (username != null && !"".equals(username) && password != null && !"".equals(password)) {
                    String auth = username + ":" + password;
                    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
                    String authHeader = "Basic " + new String(encodedAuth);
                    headers.put(HttpHeaders.AUTHORIZATION, authHeader);
                }
            }

            switch (messageType) {
                case Constants.EMERGENCY_COMMODITY_STOCK_STATUS_REQUEST:
                    path = connectionProperties.getString("destinationPathEmergencyStockStatus");
                    break;
                case Constants.FORECAST_ACCURACY_PER_PROGRAM_REQUEST:
                    path = connectionProperties.getString("destinationPathAccuracyPerProgram");
                    break;
                case Constants.LABORATORY_DIAGNOSTIC_EQUIPMENT_FUNCTIONALITY_REQUEST:
                    path = connectionProperties.getString("destinationPathLaboratoryDiagnosticEquipmentFunctionality");
                    break;
                case Constants.PERCENTAGE_OF_REPORTS_AND_REQUISITION_REQUEST:
                    path = connectionProperties.getString("destinationPathPercentageOfReportsAndRequisitionsRejected");
                    break;
                case Constants.REPORTING_TIMELINESS_REQUEST:
                    path = connectionProperties.getString("destinationPathReportingTimeliness");
                    break;
                case Constants.STOCK_AVAILABILITY_REQUEST:
                    path = connectionProperties.getString("destinationPathStockAvailability");
                    break;
                case Constants.STOCK_ON_HAND_STATUS_REQUEST:
                    path = connectionProperties.getString("destinationPathStockOnHand");
                    break;
                case Constants.TURN_AROUND_TIME_REQUEST:
                    path = connectionProperties.getString("destinationPathTurnAroundTime");
                    break;
                case Constants.PHARMACEUTICAL_AND_LABORATORY_REQUEST:
                    path = connectionProperties.getString("destinationPathPharmaceuticalAndLaboratoryPersonnel");
                    break;
                case Constants.PRODUCT_LIST_REQUEST:
                    path = connectionProperties.getString("destinationPathProductList");
                    break;
                default:
                    path = null;
                    break;
            }
        }

        List<Pair<String, String>> params = new ArrayList<>();

        host = scheme + "://" + host + ":" + portNumber + path;

        MediatorHTTPRequest forwardToThscpRequest = new MediatorHTTPRequest(
                requestHandler, getSelf(), "Sending Data to the THSCP Server", "POST",
                host, message, headers, params
        );

        ActorSelection httpConnector = getContext().actorSelection(config.userPathFor("http-connector"));
        httpConnector.tell(forwardToThscpRequest, getSelf());
    }

    /**
     * Handles the received message.
     *
     * @param msg The received message.
     */
    @Override
    public void onReceive(Object msg) throws Exception {
        if (SimpleMediatorRequest.isInstanceOf(String.class, msg)) { //process message
            log.info("Sending data Thscp ...");
            requestHandler = ((SimpleMediatorRequest) msg).getRequestHandler();
            forwardToThscp(((SimpleMediatorRequest) msg).getRequestObject().toString());

        } else if (msg instanceof MediatorHTTPResponse) { //respond
            log.info("Received response from THSCP");
            requestHandler.tell(((MediatorHTTPResponse) msg).toFinishRequest(), getSelf());
        } else {
            unhandled(msg);
        }
    }
}
