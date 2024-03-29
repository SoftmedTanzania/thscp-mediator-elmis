package tz.go.moh.him.thscp.mediator.elmis.mock;

import org.apache.commons.io.IOUtils;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import org.openhim.mediator.engine.testing.MockHTTPConnector;
import tz.go.moh.him.mediator.core.serialization.JsonSerializer;
import tz.go.moh.him.thscp.mediator.elmis.domain.*;
import tz.go.moh.him.thscp.mediator.elmis.orchestrator.EmergencyCommodityStockStatusOrchestratorTest;
import tz.go.moh.him.thscp.mediator.elmis.utils.Constants;

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
    private final String expectedMessageType;

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
        switch (expectedMessageType) {
            case Constants.EMERGENCY_COMMODITY_STOCK_STATUS_REQUEST:
                List<EmergencyCommodityStockStatusRequest> emergencyCommodityStockStatusRequestList = Arrays.asList(serializer.deserialize(msg.getBody(), EmergencyCommodityStockStatusRequest[].class));
                assertEquals("9bd21ec8-6388-464f-96d7-265fef0fa46a", emergencyCommodityStockStatusRequestList.get(0).getUuid());
                assertEquals(500, emergencyCommodityStockStatusRequestList.get(0).getAvailableQuantity());
                assertEquals("12345", emergencyCommodityStockStatusRequestList.get(0).getFacilityId());
                assertEquals("2020-11-13", emergencyCommodityStockStatusRequestList.get(0).getPeriod());
                assertEquals("PR-1", emergencyCommodityStockStatusRequestList.get(0).getProductCode());
                assertEquals("PG-1", emergencyCommodityStockStatusRequestList.get(0).getProgramCode());
                assertEquals(40, emergencyCommodityStockStatusRequestList.get(0).getStockOfMonth());
                assertEquals(50, emergencyCommodityStockStatusRequestList.get(0).getStockQuantity());
                break;
            case Constants.FORECAST_ACCURACY_PER_PROGRAM_REQUEST:
                List<ForecastAccuracyPerProgramRequest> forecastAccuracyPerProgramRequests = Arrays.asList(serializer.deserialize(msg.getBody(), ForecastAccuracyPerProgramRequest[].class));
                assertEquals("8491c5af-24b9-498c-b8a9-5dc711d2d452", forecastAccuracyPerProgramRequests.get(0).getUuid());
                assertEquals(20, forecastAccuracyPerProgramRequests.get(0).getConsumedQuantity());
                assertEquals("106091-2", forecastAccuracyPerProgramRequests.get(0).getFacilityId());
                assertEquals(10, forecastAccuracyPerProgramRequests.get(0).getForecastQuantity());
                assertEquals("2020-11-25", forecastAccuracyPerProgramRequests.get(0).getPeriod());
                assertEquals("PR-01", forecastAccuracyPerProgramRequests.get(0).getProductCode());
                assertEquals("PC-01", forecastAccuracyPerProgramRequests.get(0).getProgramCode());
                break;
            case Constants.LABORATORY_DIAGNOSTIC_EQUIPMENT_FUNCTIONALITY_REQUEST:
                List<LaboratoryDiagnosticEquipmentFunctionalityRequest> laboratoryDiagnosticEquipmentFunctionalityRequests = Arrays.asList(serializer.deserialize(msg.getBody(), LaboratoryDiagnosticEquipmentFunctionalityRequest[].class));
                assertEquals("ca0ed2a6-3e6e-419e-809a-5ddecf58f63d", laboratoryDiagnosticEquipmentFunctionalityRequests.get(0).getUuid());
                assertEquals("flask", laboratoryDiagnosticEquipmentFunctionalityRequests.get(0).getEquipmentName());
                assertEquals("112702-6", laboratoryDiagnosticEquipmentFunctionalityRequests.get(0).getFacilityId());
                assertEquals("2020-11-29", laboratoryDiagnosticEquipmentFunctionalityRequests.get(0).getInstalledDate());
                assertEquals(100, laboratoryDiagnosticEquipmentFunctionalityRequests.get(0).getQuantity());
                assertEquals("GOOD", laboratoryDiagnosticEquipmentFunctionalityRequests.get(0).getStatus());
                break;
            case Constants.PERCENTAGE_OF_REPORTS_AND_REQUISITION_REQUEST:
                List<PercentageOfReportsAndRequisitionsRejectedRequest> percentageOfReportsAndRequisitionsRejectedRequests = Arrays.asList(serializer.deserialize(msg.getBody(), PercentageOfReportsAndRequisitionsRejectedRequest[].class));
                assertEquals("4d4e4fd4-561a-4879-bd7c-2783d9d0edf4", percentageOfReportsAndRequisitionsRejectedRequests.get(0).getUuid());
                assertEquals("123456", percentageOfReportsAndRequisitionsRejectedRequests.get(0).getFacilityId());
                assertEquals("2020-11-13", percentageOfReportsAndRequisitionsRejectedRequests.get(0).getPeriod());
                assertEquals("program name", percentageOfReportsAndRequisitionsRejectedRequests.get(0).getProgram());
                assertEquals(10, percentageOfReportsAndRequisitionsRejectedRequests.get(0).getRejectedForms());
                assertEquals("2020-11-13", percentageOfReportsAndRequisitionsRejectedRequests.get(0).getSubmittedAt());
                assertEquals(15, percentageOfReportsAndRequisitionsRejectedRequests.get(0).getSubmittedForms());
                break;
            case Constants.REPORTING_TIMELINESS_REQUEST:
                List<ReportingTimelinessRequest> reportingTimelinessRequests = Arrays.asList(serializer.deserialize(msg.getBody(), ReportingTimelinessRequest[].class));
                assertEquals("61ee3f67-992c-432b-8536-2b89aa3165a8", reportingTimelinessRequests.get(0).getUuid());
                assertEquals("TZ.LK.KR.KY", reportingTimelinessRequests.get(0).getDistrictCode());
                assertEquals(15, reportingTimelinessRequests.get(0).getExpected());
                assertEquals(3, reportingTimelinessRequests.get(0).getReported());
                assertEquals(5, reportingTimelinessRequests.get(0).getNonReported());
                assertEquals(5, reportingTimelinessRequests.get(0).getUnscheduled());
                assertEquals(2, reportingTimelinessRequests.get(0).getReportedLate());
                assertEquals("2020-11-13", reportingTimelinessRequests.get(0).getPeriod());
                assertEquals("COVID", reportingTimelinessRequests.get(0).getProgram());
                break;
            case Constants.STOCK_AVAILABILITY_REQUEST:
                List<StockAvailabilityRequest> stockAvailabilityRequests = Arrays.asList(serializer.deserialize(msg.getBody(), StockAvailabilityRequest[].class));
                assertEquals("5821daab-b583-4abf-a8b0-f0a6c414d7a5", stockAvailabilityRequests.get(0).getUuid());
                assertEquals("106091-2", stockAvailabilityRequests.get(0).getFacilityId());
                assertEquals("incident", stockAvailabilityRequests.get(0).getIncident());
                assertEquals("2021-01-21T05:30:12.481Z", stockAvailabilityRequests.get(0).getPeriod());
                assertEquals("PR-01", stockAvailabilityRequests.get(0).getProductCode());
                assertEquals("PC-02", stockAvailabilityRequests.get(0).getProgramCode());
                break;
            case Constants.STOCK_ON_HAND_STATUS_REQUEST:
                List<StockOnHandStatusRequest> stockOnHandStatusRequests = Arrays.asList(serializer.deserialize(msg.getBody(), StockOnHandStatusRequest[].class));
                assertEquals("5821daab-b583-4abf-a8b0-f0a6c414d7a5", stockOnHandStatusRequests.get(0).getUuid());
                assertEquals(10, stockOnHandStatusRequests.get(0).getConsumedQuantity());
                assertEquals("106091-2", stockOnHandStatusRequests.get(0).getFacilityId());
                assertEquals(0, stockOnHandStatusRequests.get(0).getFacilityLevel());
                assertEquals(10, stockOnHandStatusRequests.get(0).getMonthsOfStock());
                assertEquals("2020-12-07", stockOnHandStatusRequests.get(0).getPeriod());
                assertEquals("PR-01", stockOnHandStatusRequests.get(0).getProductCode());
                assertEquals("PC-01", stockOnHandStatusRequests.get(0).getProgramCode());
                assertEquals(100, stockOnHandStatusRequests.get(0).getQuantity());
                assertEquals("001", stockOnHandStatusRequests.get(0).getStockId());
                break;
            case Constants.PERCENTAGE_OF_WASTAGE:
                List<PercentageOfWastageRequest> percentageOfWastageRequests = Arrays.asList(serializer.deserialize(msg.getBody(), PercentageOfWastageRequest[].class));
                assertEquals("5821daab-b583-4abf-a8b0-f0a6c414d7a5", percentageOfWastageRequests.get(0).getUuid());
                assertEquals(0, percentageOfWastageRequests.get(0).getDamagedPercentage(), 0.001);
                assertEquals(0, percentageOfWastageRequests.get(0).getExpiredPercentage(), 0.001);
                assertEquals("106091-2", percentageOfWastageRequests.get(0).getFacilityId());
                assertEquals(0, percentageOfWastageRequests.get(0).getLostPercentage(), 0.001);
                assertEquals(0, percentageOfWastageRequests.get(0).getFacilityLevel());
                assertEquals("2020-12-07", percentageOfWastageRequests.get(0).getPeriod());
                assertEquals("PR-01", percentageOfWastageRequests.get(0).getProductCode());
                assertEquals("PC-01", percentageOfWastageRequests.get(0).getProgramCode());
                assertEquals(100, percentageOfWastageRequests.get(0).getQuantity());
                break;
            case Constants.TURN_AROUND_TIME_REQUEST:
                List<TurnAroundTimeRequest> turnAroundTimeRequests = Arrays.asList(serializer.deserialize(msg.getBody(), TurnAroundTimeRequest[].class));
                assertEquals("7da14260-b2c3-4ac6-895b-0fd901d54679", turnAroundTimeRequests.get(0).getUuid());
                assertEquals(10, turnAroundTimeRequests.get(0).getDeliveredQuantity());
                assertEquals("2020-11-19", turnAroundTimeRequests.get(0).getDeliveryDate());
                assertEquals("123456", turnAroundTimeRequests.get(0).getDeliveryFromFacilityId());
                assertEquals("2020-11-19", turnAroundTimeRequests.get(0).getDeliveryPromiseDate());
                assertEquals("2020-11-19", turnAroundTimeRequests.get(0).getOrderDate());
                assertEquals("123456", turnAroundTimeRequests.get(0).getOrderFromFacilityId());
                assertEquals("OD-123", turnAroundTimeRequests.get(0).getOrderId());
                assertEquals("received", turnAroundTimeRequests.get(0).getOrderStatus());
                assertEquals("emergency", turnAroundTimeRequests.get(0).getOrderType());
                assertEquals(10, turnAroundTimeRequests.get(0).getOrderedQuantity());
                assertEquals("PR-1", turnAroundTimeRequests.get(0).getProductCode());
                assertEquals("PG-1", turnAroundTimeRequests.get(0).getProgramCode());
                assertEquals(10, turnAroundTimeRequests.get(0).getTargetDays());
                break;
            case Constants.PHARMACEUTICAL_AND_LABORATORY_REQUEST:
                List<PharmaceuticalAndLaboratoryPersonnelRequest> pharmaceuticalAndLaboratoryPersonnelRequests = Arrays.asList(serializer.deserialize(msg.getBody(), PharmaceuticalAndLaboratoryPersonnelRequest[].class));
                assertEquals("53af81dd-d3ae-44ab-86fd-8ed07f0389eb", pharmaceuticalAndLaboratoryPersonnelRequests.get(0).getUuid());
                assertEquals("112702-6", pharmaceuticalAndLaboratoryPersonnelRequests.get(0).getFacilityId());
                assertEquals("2020-11-29", pharmaceuticalAndLaboratoryPersonnelRequests.get(0).getPeriod());
                assertEquals("001", pharmaceuticalAndLaboratoryPersonnelRequests.get(0).getPostId());
                assertEquals("engineer", pharmaceuticalAndLaboratoryPersonnelRequests.get(0).getPostName());
                assertEquals(10, pharmaceuticalAndLaboratoryPersonnelRequests.get(0).getTotalPost());
                assertEquals(3, pharmaceuticalAndLaboratoryPersonnelRequests.get(0).getVacantPost());
                break;
            case Constants.PRODUCT_LIST_REQUEST:
                List<ProductListRequest> productListRequests = Arrays.asList(serializer.deserialize(msg.getBody(), ProductListRequest[].class));
                assertEquals("6b220f75-5d86-42ac-94ab-77298e5c1115", productListRequests.get(0).getUuid());
                assertEquals("PHARMACEUTICALS", productListRequests.get(0).getCategory());
                assertEquals("Ringers Lactate 500Ml", productListRequests.get(0).getDescription());
                assertEquals("Ringers Lactate 500Ml", productListRequests.get(0).getName());
                assertEquals("10020035MD", productListRequests.get(0).getProductCode());
                assertEquals("B/12", productListRequests.get(0).getProductUnit());
                break;
            default:
                break;
        }
    }
}