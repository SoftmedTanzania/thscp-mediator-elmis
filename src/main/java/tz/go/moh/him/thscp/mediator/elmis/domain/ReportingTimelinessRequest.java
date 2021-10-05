package tz.go.moh.him.thscp.mediator.elmis.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class ReportingTimelinessRequest {
    /**
     * The unique identifier
     */
    @JsonProperty("uuid")
    @SerializedName("uuid")
    private String uuid;

    /**
     * The districtCode
     */
    @JsonProperty("districtCode")
    @SerializedName("districtCode")
    private String districtCode;

    /**
     * The expected reports
     */
    @JsonProperty("expected")
    @SerializedName("expected")
    private int expected;

    /**
     * The reported reports
     */
    @JsonProperty("reported")
    @SerializedName("reported")
    private int reported;

    /**
     * The nonReported reports
     */
    @JsonProperty("nonReported")
    @SerializedName("nonReported")
    private int nonReported;

    /**
     * The unscheduled reports
     */
    @JsonProperty("unscheduled")
    @SerializedName("unscheduled")
    private int unscheduled;

    /**
     * The reportedLate reports
     */
    @JsonProperty("reportedLate")
    @SerializedName("reportedLate")
    private int reportedLate;

    /**
     * The period date
     */
    @JsonProperty("period")
    @SerializedName("period")
    private String period;

    /**
     * The program code
     */
    @JsonProperty("program")
    @SerializedName("program")
    private String program;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public int getExpected() {
        return expected;
    }

    public void setExpected(int expected) {
        this.expected = expected;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getReported() {
        return reported;
    }

    public void setReported(int reported) {
        this.reported = reported;
    }

    public int getNonReported() {
        return nonReported;
    }

    public void setNonReported(int nonReported) {
        this.nonReported = nonReported;
    }

    public int getUnscheduled() {
        return unscheduled;
    }

    public void setUnscheduled(int unscheduled) {
        this.unscheduled = unscheduled;
    }

    public int getReportedLate() {
        return reportedLate;
    }

    public void setReportedLate(int reportedLate) {
        this.reportedLate = reportedLate;
    }
}
