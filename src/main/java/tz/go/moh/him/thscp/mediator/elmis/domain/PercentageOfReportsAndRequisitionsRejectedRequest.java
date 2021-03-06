package tz.go.moh.him.thscp.mediator.elmis.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class PercentageOfReportsAndRequisitionsRejectedRequest {
    /**
     * The unique identifier
     */
    @JsonProperty("uuid")
    @SerializedName("uuid")
    private String uuid;

    /**
     * The facility ID
     */
    @JsonProperty("facilityId")
    @SerializedName("facilityId")
    private String facilityId;

    /**
     * The date period
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

    /**
     * The number of rejected forms
     */
    @JsonProperty("rejectedForms")
    @SerializedName("rejectedForms")
    private int rejectedForms;

    /**
     * The submitted date
     */
    @JsonProperty("submittedAt")
    @SerializedName("submittedAt")
    private String submittedAt;

    /**
     * The number of submitted forms
     */
    @JsonProperty("submittedForms")
    @SerializedName("submittedForms")
    private int submittedForms;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
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

    public int getRejectedForms() {
        return rejectedForms;
    }

    public void setRejectedForms(int rejectedForms) {
        this.rejectedForms = rejectedForms;
    }

    public String getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(String submittedAt) {
        this.submittedAt = submittedAt;
    }

    public int getSubmittedForms() {
        return submittedForms;
    }

    public void setSubmittedForms(int submittedForms) {
        this.submittedForms = submittedForms;
    }
}
