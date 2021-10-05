package tz.go.moh.him.thscp.mediator.elmis.orchestrator;

import org.codehaus.plexus.util.StringUtils;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import tz.go.moh.him.mediator.core.domain.ResultDetail;
import tz.go.moh.him.thscp.mediator.elmis.domain.ReportingTimelinessRequest;
import tz.go.moh.him.thscp.mediator.elmis.utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReportingTimelinessOrchestrator extends BaseOrchestrator {
    /**
     * Initializes a new instance of the {@link ForecastAccuracyPerProgramOrchestrator} class.
     *
     * @param config The configuration.
     */
    public ReportingTimelinessOrchestrator(MediatorConfig config) {
        super(config);
    }

    @Override
    protected void onReceiveRequestInternal(MediatorHTTPRequest request) throws Exception {
        List<ReportingTimelinessRequest> reportingTimelinessRequests = Arrays.asList(serializer.deserialize(request.getBody(), ReportingTimelinessRequest[].class));

        sendDataToThscp(reportingTimelinessRequests, validateMessage(reportingTimelinessRequests), Constants.REPORTING_TIMELINESS_REQUEST);
    }

    /**
     * Validates a Reporting Timeliness request.
     *
     * @param requests The requests.
     * @return Returns a list of result details.
     */
    private List<ResultDetail> validateMessage(List<ReportingTimelinessRequest> requests) {
        ArrayList<ResultDetail> results = new ArrayList<>();

        for (ReportingTimelinessRequest request : requests) {
            if (StringUtils.isEmpty(request.getUuid())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "uuid"), null));
            }

            if (StringUtils.isEmpty(request.getDistrictCode())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "districtCode"), null));
            }

            if (StringUtils.isEmpty(request.getPeriod())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "period"), null));
            }

            if (StringUtils.isEmpty(request.getProgram())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "program"), null));
            }
        }

        return results;
    }

}
