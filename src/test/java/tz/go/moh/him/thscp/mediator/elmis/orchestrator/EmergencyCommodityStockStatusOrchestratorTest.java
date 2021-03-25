package tz.go.moh.him.thscp.mediator.elmis.orchestrator;


import akka.actor.ActorRef;
import akka.actor.Props;
import akka.testkit.JavaTestKit;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openhim.mediator.engine.messages.FinishRequest;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;

import java.io.InputStream;
import java.util.Collections;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Contains tests for the {@link EmergencyCommodityStockStatusOrchestrator} class.
 */
public class EmergencyCommodityStockStatusOrchestratorTest extends BaseOrchestratorTest {
    /**
     * Represents the orchestrator.
     */
    private final ActorRef orchestrator = system.actorOf(Props.create(EmergencyCommodityStockStatusOrchestrator.class, configuration));

    /**
     * Runs initialization before each test execution.
     */
    @Before
    public void before() {
        setupDestinationMock("EmergencyCommodityStockStatusRequest");
    }

    @Test
    public void testMediatorHTTPRequest() throws Exception {
        InputStream stream = EmergencyCommodityStockStatusOrchestratorTest.class.getClassLoader().getResourceAsStream("emergency_commodity_stock_statu_request.json");
        assertNotNull(stream);
        new JavaTestKit(system) {{
            Assert.assertNotNull(stream);

            MediatorHTTPRequest POST_Request = new MediatorHTTPRequest(
                    getRef(),
                    getRef(),
                    "unit-test",
                    "POST",
                    "http",
                    null,
                    null,
                    "/thscp",
                    IOUtils.toString(stream),
                    Collections.singletonMap("Content-Type", "text/plain"),
                    Collections.emptyList()
            );

            orchestrator.tell(POST_Request, getRef());

            final Object[] out =
                    new ReceiveWhile<Object>(Object.class, duration("1 second")) {
                        @Override
                        protected Object match(Object msg) throws Exception {
                            if (msg instanceof FinishRequest) {
                                return msg;
                            }
                            throw noMatch();
                        }
                    }.get();

            boolean foundResponse = false;

            for (Object o : out) {
                if (o instanceof FinishRequest) {
                    foundResponse = true;
                }
            }

            assertTrue("Must send FinishRequest", foundResponse);
        }};
    }
}
