package tz.go.moh.him.thscp.mediator.elmis.orchestrator;

import org.codehaus.plexus.util.StringUtils;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import tz.go.moh.him.mediator.core.domain.ResultDetail;
import tz.go.moh.him.thscp.mediator.elmis.domain.PercentageOfReportsAndRequisitionsRejectedRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PercentageOfReportsAndRequisitionsRejectedOrchestrator extends BaseOrchestrator {
    /**
     * Initializes a new instance of the {@link PercentageOfReportsAndRequisitionsRejectedOrchestrator} class.
     *
     * @param config The configuration.
     */
    public PercentageOfReportsAndRequisitionsRejectedOrchestrator(MediatorConfig config) {
        super(config);
    }

    @Override
    protected void onReceiveRequestInternal(MediatorHTTPRequest request) throws Exception {
        List<PercentageOfReportsAndRequisitionsRejectedRequest> percentageOfReportsAndRequisitionsRejectedRequests = Arrays.asList(serializer.deserialize(request.getBody(), PercentageOfReportsAndRequisitionsRejectedRequest[].class));

        sendDataToThscp(percentageOfReportsAndRequisitionsRejectedRequests, validateMessage(percentageOfReportsAndRequisitionsRejectedRequests));
    }

    /**
     * Validates a Percentage of Reports and Requisition request.
     *
     * @param requests The requests.
     * @return Returns a list of result details.
     */
    private List<ResultDetail> validateMessage(List<PercentageOfReportsAndRequisitionsRejectedRequest> requests) {
        ArrayList<ResultDetail> results = new ArrayList<>();

        for (PercentageOfReportsAndRequisitionsRejectedRequest request : requests) {
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
