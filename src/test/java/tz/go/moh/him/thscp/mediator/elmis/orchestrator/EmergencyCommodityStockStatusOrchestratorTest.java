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
import org.openhim.mediator.engine.testing.MockHTTPConnector;
import org.openhim.mediator.engine.testing.MockLauncher;
import org.openhim.mediator.engine.testing.TestingUtils;
import tz.go.moh.him.mediator.core.serialization.JsonSerializer;
import tz.go.moh.him.thscp.mediator.elmis.domain.EmergencyCommodityStockStatusRequest;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
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
        List<MockLauncher.ActorToLaunch> actorsToLaunch = new LinkedList<>();

        actorsToLaunch.add(new MockLauncher.ActorToLaunch("http-connector", MockDestination.class));

        TestingUtils.launchActors(system, configuration.getName(), actorsToLaunch);
    }

    @Test
    public void testMediatorHTTPRequest() throws Exception {
        new JavaTestKit(system) {{
            InputStream stream = EmergencyCommodityStockStatusOrchestratorTest.class.getClassLoader().getResourceAsStream("emergency_commodity_stock_statu_request.json");

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

    /**
     * Represents a mock destination.
     */
    private static class MockDestination extends MockHTTPConnector {
        /**
         * The serializer.
         */
        protected static final JsonSerializer serializer = new JsonSerializer();

        /**
         * Gets the response.
         *
         * @return Returns the response.
         */
        @Override
        public String getResponse() {
            try {
                return IOUtils.toString(EmergencyCommodityStockStatusOrchestratorTest.class.getClassLoader().getResourceAsStream("success_response.json"));
            } catch (Exception e) {
                return null;
            }
        }

        /**
         * Gets the status code.
         *
         * @return Returns the status code.
         */
        @Override
        public Integer getStatus() {
            return 200;
        }

        /**
         * Gets the HTTP headers.
         *
         * @return Returns the HTTP headers.
         */
        @Override
        public Map<String, String> getHeaders() {
            return Collections.emptyMap();
        }

        /**
         * Handles the message.
         *
         * @param msg The message.
         */
        @Override
        public void executeOnReceive(MediatorHTTPRequest msg) {
            List<EmergencyCommodityStockStatusRequest> emergencyCommodityStockStatusRequestList = Arrays.asList(serializer.deserialize(msg.getBody(), EmergencyCommodityStockStatusRequest[].class));
            assertEquals("9bd21ec8-6388-464f-96d7-265fef0fa46a", emergencyCommodityStockStatusRequestList.get(0).getUuid());
            assertEquals(500, emergencyCommodityStockStatusRequestList.get(0).getAvailableQuantity());
            assertEquals("12345", emergencyCommodityStockStatusRequestList.get(0).getFacilityId());
            assertEquals("2020-11-13", emergencyCommodityStockStatusRequestList.get(0).getPeriod());
            assertEquals("PR-1", emergencyCommodityStockStatusRequestList.get(0).getProductCode());
            assertEquals("PG-1", emergencyCommodityStockStatusRequestList.get(0).getProgramCode());
            assertEquals(40, emergencyCommodityStockStatusRequestList.get(0).getStockOfMonth());
            assertEquals(50, emergencyCommodityStockStatusRequestList.get(0).getStockQuantity());
        }
    }
}
