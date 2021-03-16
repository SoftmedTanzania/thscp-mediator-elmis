package tz.go.moh.him.thscp.mediator.elmis.Orchestration;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import tz.go.moh.him.mediator.core.domain.ErrorMessage;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseOrchestrator extends UntypedActor {
    /**
     * Possible date formats used by the source systems
     */
    private static List<String> formatStrings = Arrays.asList("yyyy-MM-dd HH:mm:ss:ms", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyyMMdd");

    /**
     * The mediator configuration.
     */
    protected final MediatorConfig config;

    /**
     * The logger instance.
     */
    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    /**
     * Represents a list of error messages, if any,that have been caught during payload data validation to be returned to the source system as response.
     */
    protected List<ErrorMessage> errorMessages = new ArrayList<>();

    /**
     * Handles the received message.
     */
    protected MediatorHTTPRequest originalRequest;

    /**
     * Represents an Error Messages Definition Resource Object defined in <a href="file:../resources/error-messages.json">/resources/error-messages.json</a>.
     */
    protected JSONObject errorMessageResource;

    /**
     * Initializes a new instance of the {@link BaseOrchestrator} class.
     *
     * @param config The mediator configuration.
     */
    public BaseOrchestrator(MediatorConfig config) {
        this.config = config;
        InputStream stream = getClass().getClassLoader().getResourceAsStream("error-messages.json");
        try {
            if (stream != null) {
                errorMessageResource = new JSONObject(IOUtils.toString(stream));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles checking for the correct date string format from a varierity of formats
     *
     * @param dateString of the date
     * @return the matching date string format
     */
    public static String checkDateFormatStrings(String dateString) {
        for (String formatString : formatStrings) {
            try {
                new SimpleDateFormat(formatString).parse(dateString);
                return formatString;
            } catch (ParseException e) {
                //Invalid Date String
            }
        }

        return "";
    }

    /**
     * Handles the received message.
     *
     * @param message The received message.
     */
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof MediatorHTTPRequest) {
            this.onReceiveRequestInternal((MediatorHTTPRequest) message);
        } else {
            unhandled(message);
        }
    }

    /**
     * Handles the received message.
     *
     * @param request The request.
     * @throws Exception if an exception occurs.
     */
    protected abstract void onReceiveRequestInternal(MediatorHTTPRequest request) throws Exception;
}
