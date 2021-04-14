package tz.go.moh.him.thscp.mediator.elmis.orchestrator;

import org.codehaus.plexus.util.StringUtils;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import tz.go.moh.him.mediator.core.domain.ResultDetail;
import tz.go.moh.him.thscp.mediator.elmis.domain.TurnAroundTimeRequest;
import tz.go.moh.him.thscp.mediator.elmis.utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TurnAroundTimeOrchestrator extends BaseOrchestrator {
    /**
     * Initializes a new instance of the {@link TurnAroundTimeOrchestrator} class.
     *
     * @param config The configuration.
     */
    public TurnAroundTimeOrchestrator(MediatorConfig config) {
        super(config);
    }

    @Override
    protected void onReceiveRequestInternal(MediatorHTTPRequest request) throws Exception {
        List<TurnAroundTimeRequest> turnAroundTimeRequests = Arrays.asList(serializer.deserialize(request.getBody(), TurnAroundTimeRequest[].class));

        sendDataToThscp(turnAroundTimeRequests, validateMessage(turnAroundTimeRequests), Constants.TURN_AROUND_TIME_REQUEST);
    }

    /**
     * Validates a Turn Around Time request.
     *
     * @param requests The requests.
     * @return Returns a list of result details.
     */
    private List<ResultDetail> validateMessage(List<TurnAroundTimeRequest> requests) {
        ArrayList<ResultDetail> results = new ArrayList<>();

        for (TurnAroundTimeRequest request : requests) {
            if (StringUtils.isEmpty(request.getUuid())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "uuid"), null));
            }

            if (StringUtils.isEmpty(request.getDeliveryDate())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "deliveryDate"), null));
            }

            if (StringUtils.isEmpty(request.getDeliveryFromFacilityId())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "deliveryFromFacilityId"), null));
            }

            if (StringUtils.isEmpty(request.getDeliveryPromiseDate())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "deliveryPromiseDate"), null));
            }

            if (StringUtils.isEmpty(request.getOrderDate())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "orderDate"), null));
            }

            if (StringUtils.isEmpty(request.getOrderFromFacilityId())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "orderFromFacilityId"), null));
            }

            if (StringUtils.isEmpty(request.getOrderId())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "orderId"), null));
            }

            if (StringUtils.isEmpty(request.getOrderStatus())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "orderStatus"), null));
            }

            if (StringUtils.isEmpty(request.getOrderType())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "orderType"), null));
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
