package tz.go.moh.him.thscp.mediator.elmis.Orchestration;

import akka.event.Logging;
import akka.event.LoggingAdapter;
import org.codehaus.plexus.util.StringUtils;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import tz.go.moh.him.mediator.core.domain.ResultDetail;
import tz.go.moh.him.thscp.mediator.elmis.Domain.StockOnHandStatusRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockOnHandStatusOrchestrator extends BaseOrchestrator {
    private final MediatorConfig config;
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);


    public StockOnHandStatusOrchestrator(MediatorConfig config) {
        super(config);
        this.config = config;
    }

    @Override
    protected void onReceiveRequestInternal(MediatorHTTPRequest request) throws Exception {
        List<StockOnHandStatusRequest> stockOnHandStatusRequests = Arrays.asList(serializer.deserialize(request.getBody(), StockOnHandStatusRequest[].class));

        sendDataToThscp(stockOnHandStatusRequests, validateMessage(stockOnHandStatusRequests));
    }

    /**
     * Validates a Stock Availability request.
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
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "partnerIdentification"), null));
            }

            if (StringUtils.isEmpty(request.getPeriod())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "scope"), null));
            }

            if (StringUtils.isEmpty(request.getStockId())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "latitude"), null));
            }

            if (StringUtils.isEmpty(request.getProductCode())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "longitude"), null));
            }
        }

        return results;
    }

}
