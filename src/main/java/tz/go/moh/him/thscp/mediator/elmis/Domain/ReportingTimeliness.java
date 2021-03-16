package tz.go.moh.him.thscp.mediator.elmis.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class ReportingTimeliness {
    /**
     * The unique identifier
     */
    @JsonProperty("uuid")
    @SerializedName("uuid")
    private String uuid;

    /**
     * The district
     */
    @JsonProperty("district")
    @SerializedName("district")
    private String district;

    /**
     * The expected reports
     */
    @JsonProperty("expected")
    @SerializedName("expected")
    private int expected;

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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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
}
