package tz.go.moh.him.thscp.mediator.elmis.mock;

import org.apache.commons.io.IOUtils;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import org.openhim.mediator.engine.testing.MockHTTPConnector;
import tz.go.moh.him.mediator.core.serialization.JsonSerializer;
import tz.go.moh.him.thscp.mediator.elmis.domain.EmergencyCommodityStockStatusRequest;
import tz.go.moh.him.thscp.mediator.elmis.domain.ForecastAccuracyPerProgramRequest;
import tz.go.moh.him.thscp.mediator.elmis.domain.LaboratoryDiagnosticEquipmentFunctionalityRequest;
import tz.go.moh.him.thscp.mediator.elmis.domain.PercentageOfReportsAndRequisitionRequest;
import tz.go.moh.him.thscp.mediator.elmis.domain.ReportingTimelinessRequest;
import tz.go.moh.him.thscp.mediator.elmis.domain.StockAvailabilityRequest;
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
        } else if (expectedMessageType.equals("ForecastAccuracyPerProgramRequest")) {
            List<ForecastAccuracyPerProgramRequest> forecastAccuracyPerProgramRequests = Arrays.asList(serializer.deserialize(msg.getBody(), ForecastAccuracyPerProgramRequest[].class));
            assertEquals("8491c5af-24b9-498c-b8a9-5dc711d2d452", forecastAccuracyPerProgramRequests.get(0).getUuid());
            assertEquals(20, forecastAccuracyPerProgramRequests.get(0).getConsumedQuantity());
            assertEquals("106091-2", forecastAccuracyPerProgramRequests.get(0).getFacilityId());
            assertEquals(10, forecastAccuracyPerProgramRequests.get(0).getForecastQuantity());
            assertEquals("2020-11-25", forecastAccuracyPerProgramRequests.get(0).getPeriod());
            assertEquals("PR-1", forecastAccuracyPerProgramRequests.get(0).getProductCode());
            assertEquals("PG-1", forecastAccuracyPerProgramRequests.get(0).getProgramCode());
        } else if (expectedMessageType.equals("LaboratoryDiagnosticEquipmentFunctionalityRequest")) {
            List<LaboratoryDiagnosticEquipmentFunctionalityRequest> laboratoryDiagnosticEquipmentFunctionalityRequests = Arrays.asList(serializer.deserialize(msg.getBody(), LaboratoryDiagnosticEquipmentFunctionalityRequest[].class));
            assertEquals("ca0ed2a6-3e6e-419e-809a-5ddecf58f63d", laboratoryDiagnosticEquipmentFunctionalityRequests.get(0).getUuid());
            assertEquals("flask", laboratoryDiagnosticEquipmentFunctionalityRequests.get(0).getEquipmentName());
            assertEquals("112702-6", laboratoryDiagnosticEquipmentFunctionalityRequests.get(0).getFacilityId());
            assertEquals("2020-11-29", laboratoryDiagnosticEquipmentFunctionalityRequests.get(0).getInstalledDate());
            assertEquals(100, laboratoryDiagnosticEquipmentFunctionalityRequests.get(0).getQuantity());
            assertEquals("GOOD", laboratoryDiagnosticEquipmentFunctionalityRequests.get(0).getStatus());
        } else if (expectedMessageType.equals("PercentageOfReportsAndRequisitionRequest")) {
            List<PercentageOfReportsAndRequisitionRequest> percentageOfReportsAndRequisitionRequests = Arrays.asList(serializer.deserialize(msg.getBody(), PercentageOfReportsAndRequisitionRequest[].class));
            assertEquals("4d4e4fd4-561a-4879-bd7c-2783d9d0edf4", percentageOfReportsAndRequisitionRequests.get(0).getUuid());
            assertEquals("123456", percentageOfReportsAndRequisitionRequests.get(0).getFacilityId());
            assertEquals("2020-11-13", percentageOfReportsAndRequisitionRequests.get(0).getPeriod());
            assertEquals("program name", percentageOfReportsAndRequisitionRequests.get(0).getProgram());
            assertEquals(10, percentageOfReportsAndRequisitionRequests.get(0).getRejectedForms());
            assertEquals("2020-11-13", percentageOfReportsAndRequisitionRequests.get(0).getSubmittedAt());
            assertEquals(15, percentageOfReportsAndRequisitionRequests.get(0).getSubmittedForms());
        } else if (expectedMessageType.equals("ReportingTimelinessOrchestratorRequest")) {
            List<ReportingTimelinessRequest> reportingTimelinessRequests = Arrays.asList(serializer.deserialize(msg.getBody(), ReportingTimelinessRequest[].class));
            assertEquals("61ee3f67-992c-432b-8536-2b89aa3165a8", reportingTimelinessRequests.get(0).getUuid());
            assertEquals("Kigoma", reportingTimelinessRequests.get(0).getDistrict());
            assertEquals(5, reportingTimelinessRequests.get(0).getExpected());
            assertEquals("2020-11-13", reportingTimelinessRequests.get(0).getPeriod());
            assertEquals("COVID", reportingTimelinessRequests.get(0).getProgram());
        } else if (expectedMessageType.equals("StockAvailabilityOrchestratorRequest")) {
            List<StockAvailabilityRequest> stockAvailabilityRequests = Arrays.asList(serializer.deserialize(msg.getBody(), StockAvailabilityRequest[].class));
            assertEquals("5821daab-b583-4abf-a8b0-f0a6c414d7a5", stockAvailabilityRequests.get(0).getUuid());
            assertEquals("106091-2", stockAvailabilityRequests.get(0).getFacilityId());
            assertEquals("incident", stockAvailabilityRequests.get(0).getIncident());
            assertEquals("2021-01-21T05:30:12.481Z", stockAvailabilityRequests.get(0).getPeriod());
            assertEquals("PR-01", stockAvailabilityRequests.get(0).getProductCode());
            assertEquals("PC-02", stockAvailabilityRequests.get(0).getProgramCode());
        }
    }
}