package tz.go.moh.him.thscp.mediator.elmis.Orchestration;

import org.codehaus.plexus.util.StringUtils;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import tz.go.moh.him.mediator.core.domain.ResultDetail;
import tz.go.moh.him.thscp.mediator.elmis.Domain.EmergencyCommodityStockStatusRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmergencyCommodityStockStatusOrchestrator extends BaseOrchestrator {
    /**
     * Initializes a new instance of the {@link EmergencyCommodityStockStatusOrchestrator} class.
     *
     * @param config The configuration.
     */
    public EmergencyCommodityStockStatusOrchestrator(MediatorConfig config) {
        super(config);
    }

    @Override
    protected void onReceiveRequestInternal(MediatorHTTPRequest request) throws Exception {
        List<EmergencyCommodityStockStatusRequest> stockOnHandStatusRequests = Arrays.asList(serializer.deserialize(request.getBody(), EmergencyCommodityStockStatusRequest[].class));

        sendDataToThscp(stockOnHandStatusRequests, validateMessage(stockOnHandStatusRequests));
    }

    /**
     * Validates a Emergency Commodity Stock Status request.
     *
     * @param requests The requests.
     * @return Returns a list of result details.
     */
    private List<ResultDetail> validateMessage(List<EmergencyCommodityStockStatusRequest> requests) {
        ArrayList<ResultDetail> results = new ArrayList<>();

        for (EmergencyCommodityStockStatusRequest request : requests) {
            if (StringUtils.isEmpty(request.getUuid())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "uuid"), null));
            }

            if (StringUtils.isEmpty(request.getFacilityId())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "facility_id"), null));
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