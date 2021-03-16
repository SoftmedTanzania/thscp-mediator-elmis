package tz.go.moh.him.thscp.mediator.elmis.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class ForecastAccuracyPerProgram {
    /**
     * The unique identifier
     */
    @JsonProperty("uuid")
    @SerializedName("uuid")
    private String uuid;

    /**
     * The consumed quantity
     */
    @JsonProperty("consumedQuantity")
    @SerializedName("consumedQuantity")
    private int consumedQuantity;

    /**
     * The facility ID
     */
    @JsonProperty("facilityId")
    @SerializedName("facilityId")
    private String facilityId;

    /**
     * The forecast quantity
     */
    @JsonProperty("forecastQuantity")
    @SerializedName("forecastQuantity")
    private String forecastQuantity;

    /**
     * The date period
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

    public int getConsumedQuantity() {
        return consumedQuantity;
    }

    public void setConsumedQuantity(int consumedQuantity) {
        this.consumedQuantity = consumedQuantity;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getForecastQuantity() {
        return forecastQuantity;
    }

    public void setForecastQuantity(String forecastQuantity) {
        this.forecastQuantity = forecastQuantity;
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
