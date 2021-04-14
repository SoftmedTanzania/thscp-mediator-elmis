package tz.go.moh.him.thscp.mediator.elmis.orchestrator;

import org.codehaus.plexus.util.StringUtils;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import tz.go.moh.him.mediator.core.domain.ResultDetail;
import tz.go.moh.him.thscp.mediator.elmis.domain.PharmaceuticalAndLaboratoryPersonnelRequest;
import tz.go.moh.him.thscp.mediator.elmis.utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PharmaceuticalAndLaboratoryPersonnelOrchestrator extends BaseOrchestrator {
    /**
     * Initializes a new instance of the {@link TurnAroundTimeOrchestrator} class.
     *
     * @param config The configuration.
     */
    public PharmaceuticalAndLaboratoryPersonnelOrchestrator(MediatorConfig config) {
        super(config);
    }

    @Override
    protected void onReceiveRequestInternal(MediatorHTTPRequest request) throws Exception {
        List<PharmaceuticalAndLaboratoryPersonnelRequest> pharmaceuticalAndLaboratoryPersonnelRequests = Arrays.asList(serializer.deserialize(request.getBody(), PharmaceuticalAndLaboratoryPersonnelRequest[].class));

        sendDataToThscp(pharmaceuticalAndLaboratoryPersonnelRequests, validateMessage(pharmaceuticalAndLaboratoryPersonnelRequests), Constants.PHARMACEUTICAL_AND_LABORATORY_REQUEST);
    }

    /**
     * Validates a Work force, Pharmaceutical and Laboratory personnel, request.
     *
     * @param requests The requests.
     * @return Returns a list of result details.
     */
    private List<ResultDetail> validateMessage(List<PharmaceuticalAndLaboratoryPersonnelRequest> requests) {
        ArrayList<ResultDetail> results = new ArrayList<>();

        for (PharmaceuticalAndLaboratoryPersonnelRequest request : requests) {
            if (StringUtils.isEmpty(request.getUuid())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "uuid"), null));
            }

            if (StringUtils.isEmpty(request.getFacilityId())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "facilityId"), null));
            }

            if (StringUtils.isEmpty(request.getPeriod())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "period"), null));
            }

            if (StringUtils.isEmpty(request.getPostId())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "postId"), null));
            }

            if (StringUtils.isEmpty(request.getPostName())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "postName"), null));
            }
        }

        return results;
    }

}
