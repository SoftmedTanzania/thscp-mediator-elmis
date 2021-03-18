package tz.go.moh.him.thscp.mediator.elmis.Orchestration;

import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.google.gson.Gson;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import tz.go.moh.him.thscp.mediator.elmis.Domain.WorkforceRequest;

public class WorkforceOrchestrator extends BaseOrchestrator {
    private final MediatorConfig config;
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);


    public WorkforceOrchestrator(MediatorConfig config) {
        super(config);
        this.config = config;
    }

    @Override
    protected void onReceiveRequestInternal(MediatorHTTPRequest request) throws Exception {
        WorkforceRequest workforceRequest = new Gson().fromJson(request.getBody(), WorkforceRequest.class);
    }
}
