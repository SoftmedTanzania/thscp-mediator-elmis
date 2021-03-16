package tz.go.moh.him.thscp.mediator.elmis.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class StockAvailability {
    /**
     * The unique identifier
     */
    @JsonProperty("uuid")
    @SerializedName("uuid")
    private String uuid;

    /**
     * The facility HFR Id
     */
    @JsonProperty("facilityId")
    @SerializedName("facilityId")
    private String facilityId;

    /**
     * The incident
     */
    @JsonProperty("incident")
    @SerializedName("incident")
    private String incident;

    /**
     * The period date
     */
    @JsonProperty("period")
    @SerializedName("period")
    private String period;

    /**
     * The product code
     */
    @JsonProperty("productCode")
    @SerializedName("productCode")
    private String productCode;

    /**
     * The program code
     */
    @JsonProperty("programCode")
    @SerializedName("programCode")
    private String programCode;

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

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }
}
