package tz.go.moh.him.thscp.mediator.elmis.orchestrator;

import org.codehaus.plexus.util.StringUtils;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import tz.go.moh.him.mediator.core.domain.ResultDetail;
import tz.go.moh.him.thscp.mediator.elmis.domain.ForecastAccuracyPerProgramRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForecastAccuracyPerProgramOrchestrator extends BaseOrchestrator {
    /**
     * Initializes a new instance of the {@link ForecastAccuracyPerProgramOrchestrator} class.
     *
     * @param config The configuration.
     */
    public ForecastAccuracyPerProgramOrchestrator(MediatorConfig config) {
        super(config);
    }

    @Override
    protected void onReceiveRequestInternal(MediatorHTTPRequest request) throws Exception {
        List<ForecastAccuracyPerProgramRequest> forecastAccuracyPerProgramRequests = Arrays.asList(serializer.deserialize(request.getBody(), ForecastAccuracyPerProgramRequest[].class));

        sendDataToThscp(forecastAccuracyPerProgramRequests, validateMessage(forecastAccuracyPerProgramRequests));
    }

    /**
     * Validates a Forecast Accuracy Per Program request.
     *
     * @param requests The requests.
     * @return Returns a list of result details.
     */
    private List<ResultDetail> validateMessage(List<ForecastAccuracyPerProgramRequest> requests) {
        ArrayList<ResultDetail> results = new ArrayList<>();

        for (ForecastAccuracyPerProgramRequest request : requests) {
            if (StringUtils.isEmpty(request.getUuid())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "uuid"), null));
            }

            if (StringUtils.isEmpty(request.getFacilityId())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "facilityId"), null));
            }

            if (StringUtils.isEmpty(request.getForecastQuantity())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "forecastQuantity"), null));
            }

            if (StringUtils.isEmpty(request.getPeriod())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "period"), null));
            }

            if (StringUtils.isEmpty(request.getProductCode())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "productCode"), null));
            }

            if (StringUtils.isEmpty(request.getProgramCode())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "programCode"), null));
            }
        }

        return results;
    }

}
