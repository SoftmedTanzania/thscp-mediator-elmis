package tz.go.moh.him.thscp.mediator.elmis.orchestrator;

import org.codehaus.plexus.util.StringUtils;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import tz.go.moh.him.mediator.core.domain.ResultDetail;
import tz.go.moh.him.thscp.mediator.elmis.domain.ProductListRequest;
import tz.go.moh.him.thscp.mediator.elmis.utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductListOrchestrator extends BaseOrchestrator {
    /**
     * Initializes a new instance of the {@link ProductListOrchestrator} class.
     *
     * @param config The configuration.
     */
    public ProductListOrchestrator(MediatorConfig config) {
        super(config);
    }

    @Override
    protected void onReceiveRequestInternal(MediatorHTTPRequest request) throws Exception {
        List<ProductListRequest> productListRequests = Arrays.asList(serializer.deserialize(request.getBody(), ProductListRequest[].class));

        sendDataToThscp(productListRequests, validateMessage(productListRequests), Constants.PRODUCT_LIST_REQUEST);
    }

    /**
     * Validates a Stock on Hand Status request.
     *
     * @param requests The requests.
     * @return Returns a list of result details.
     */
    private List<ResultDetail> validateMessage(List<ProductListRequest> requests) {
        ArrayList<ResultDetail> results = new ArrayList<>();

        for (ProductListRequest request : requests) {
            if (StringUtils.isEmpty(request.getUuid())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "uuid"), null));
            }

            if (StringUtils.isEmpty(request.getCategory())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "category"), null));
            }

            if (StringUtils.isEmpty(request.getDescription())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "description"), null));
            }

            if (StringUtils.isEmpty(request.getProductCode())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "name"), null));
            }

            if (StringUtils.isEmpty(request.getProductCode())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "productCode"), null));
            }

            if (StringUtils.isEmpty(request.getProductUnit())) {
                results.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("NN_ERR01"), "productUnit"), null));
            }
        }

        return results;
    }

}
