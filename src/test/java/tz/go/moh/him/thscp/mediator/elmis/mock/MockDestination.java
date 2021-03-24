package tz.go.moh.him.thscp.mediator.elmis.mock;

import org.apache.commons.io.IOUtils;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import org.openhim.mediator.engine.testing.MockHTTPConnector;
import tz.go.moh.him.mediator.core.serialization.JsonSerializer;
import tz.go.moh.him.thscp.mediator.elmis.domain.EmergencyCommodityStockStatusRequest;
import tz.go.moh.him.thscp.mediator.elmis.orchestrator.EmergencyCommodityStockStatusOrchestratorTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Represents a mock destination.
 */
public class MockDestination extends MockHTTPConnector {
    /**
     * The serializer.
     */
    protected static final JsonSerializer serializer = new JsonSerializer();

    /**
     * The expected message type
     */
    private String expectedMessageType;

    public MockDestination(String expectedMessageType) {
        this.expectedMessageType = expectedMessageType;
    }

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
        if (expectedMessageType.equals("EmergencyCommodityStockStatusRequest")) {
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