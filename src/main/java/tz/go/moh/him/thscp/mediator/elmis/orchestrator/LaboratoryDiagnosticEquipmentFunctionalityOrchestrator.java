package tz.go.moh.him.thscp.mediator.elmis.orchestrator;

import org.codehaus.plexus.util.StringUtils;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import tz.go.moh.him.mediator.core.domain.ResultDetail;
import tz.go.moh.him.thscp.mediator.elmis.domain.LaboratoryDiagnosticEquipmentFunctionalityRequest;
import tz.go.moh.him.thscp.mediator.elmis.utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LaboratoryDiagnosticEquipmentFunctionalityOrchestrator extends BaseOrchestrator {
    /**
     * Initializes a new instance of the {@link LaboratoryDiagnosticEquipmentFunctionalityOrchestrator} class.
     *
     * @param config The configuration.
     */
    public LaboratoryDiagnosticEquipmentFunctionalityOrchestrator(MediatorConfig config) {
        super(config);
    }

    @Override
    protected void onReceiveRequestInternal(MediatorHTTPRequest request) throws Exception {
        List<LaboratoryDiagnosticEquipmentFunctionalityRequest> laboratoryDiagnosticEquipmentFunctionalityRequests = Arrays.asList(serializer.deserialize(request.getBody(), LaboratoryDiagnosticEquipmentFunctionalityRequest[].class));

        sendDataToThscp(laboratoryDiagnosticEquipmentFunctionalityRequests, validateMessage(laboratoryDiagnosticEquipmentFunctionalityRequests), Constants.LABORATORY_DIAGNOSTIC_EQUIPMENT_FUNCTIONALITY_REQUEST);
    }

    /**
     * Validates a Laboratory Diagnostic Equipments Functionality request.
     *
     * @param requests The requests.
     * @return Returns a list of result details.
     */
    private List<ResultDetail> validateMessage(List<LaboratoryDiagnosticEquipmentFunctionalityRequest> requests) {
        ArrayList<ResultDetail> results = new ArrayList<>();

        for (LaboratoryDiagnosticEquipmentFunctionalityRequest request : requests) {
            if (StringUtils.isEmpty(request.getUuid())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "uuid"), null));
            }

            if (StringUtils.isEmpty(request.getEquipmentName())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "equipmentName"), null));
            }

            if (StringUtils.isEmpty(request.getFacilityId())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "facilityId"), null));
            }

            if (StringUtils.isEmpty(request.getInstalledDate())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "installedDate"), null));
            }

            if (StringUtils.isEmpty(request.getStatus())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "status"), null));
            }
        }

        return results;
    }

}
