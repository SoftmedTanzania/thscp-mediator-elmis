package tz.go.moh.him.thscp.mediator.elmis.orchestrator;

import org.codehaus.plexus.util.StringUtils;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import tz.go.moh.him.mediator.core.domain.ResultDetail;
import tz.go.moh.him.thscp.mediator.elmis.domain.PercentageOfReportsAndRequisitionRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PercentageOfReportsAndRequisitionOrchestrator extends BaseOrchestrator {
    /**
     * Initializes a new instance of the {@link PercentageOfReportsAndRequisitionOrchestrator} class.
     *
     * @param config The configuration.
     */
    public PercentageOfReportsAndRequisitionOrchestrator(MediatorConfig config) {
        super(config);
    }

    @Override
    protected void onReceiveRequestInternal(MediatorHTTPRequest request) throws Exception {
        List<PercentageOfReportsAndRequisitionRequest> percentageOfReportsAndRequisitionRequests = Arrays.asList(serializer.deserialize(request.getBody(), PercentageOfReportsAndRequisitionRequest[].class));

        sendDataToThscp(percentageOfReportsAndRequisitionRequests, validateMessage(percentageOfReportsAndRequisitionRequests));
    }

    /**
     * Validates a Percentage of Reports and Requisition request.
     *
     * @param requests The requests.
     * @return Returns a list of result details.
     */
    private List<ResultDetail> validateMessage(List<PercentageOfReportsAndRequisitionRequest> requests) {
        ArrayList<ResultDetail> results = new ArrayList<>();

        for (PercentageOfReportsAndRequisitionRequest request : requests) {
            if (StringUtils.isEmpty(request.getUuid())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "uuid"), null));
            }

            if (StringUtils.isEmpty(request.getFacilityId())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "facilityId"), null));
            }

            if (StringUtils.isEmpty(request.getPeriod())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "period"), null));
            }

            if (StringUtils.isEmpty(request.getProgram())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "program"), null));
            }

            if (StringUtils.isEmpty(request.getSubmittedAt())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "submittedAt"), null));
            }
        }

        return results;
    }

}
