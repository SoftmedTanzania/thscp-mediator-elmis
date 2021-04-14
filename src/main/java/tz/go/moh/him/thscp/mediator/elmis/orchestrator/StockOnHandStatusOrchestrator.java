package tz.go.moh.him.thscp.mediator.elmis.orchestrator;

import org.codehaus.plexus.util.StringUtils;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import tz.go.moh.him.mediator.core.domain.ResultDetail;
import tz.go.moh.him.thscp.mediator.elmis.domain.StockOnHandStatusRequest;
import tz.go.moh.him.thscp.mediator.elmis.utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockOnHandStatusOrchestrator extends BaseOrchestrator {
    /**
     * Initializes a new instance of the {@link StockOnHandStatusOrchestrator} class.
     *
     * @param config The configuration.
     */
    public StockOnHandStatusOrchestrator(MediatorConfig config) {
        super(config);
    }

    @Override
    protected void onReceiveRequestInternal(MediatorHTTPRequest request) throws Exception {
        List<StockOnHandStatusRequest> stockOnHandStatusRequests = Arrays.asList(serializer.deserialize(request.getBody(), StockOnHandStatusRequest[].class));

        sendDataToThscp(stockOnHandStatusRequests, validateMessage(stockOnHandStatusRequests), Constants.STOCK_ON_HAND_STATUS_REQUEST);
    }

    /**
     * Validates a Stock on Hand Status request.
     *
     * @param requests The requests.
     * @return Returns a list of result details.
     */
    private List<ResultDetail> validateMessage(List<StockOnHandStatusRequest> requests) {
        ArrayList<ResultDetail> results = new ArrayList<>();

        for (StockOnHandStatusRequest request : requests) {
            if (StringUtils.isEmpty(request.getUuid())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "uuid"), null));
            }

            if (StringUtils.isEmpty(request.getFacilityId())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "facilityId"), null));
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

            if (StringUtils.isEmpty(request.getStockId())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "stockId"), null));
            }
        }

        return results;
    }

}
