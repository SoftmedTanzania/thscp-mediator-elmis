package tz.go.moh.him.thscp.mediator.elmis.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class EmergencyCommodityStockStatusRequest {
    /**
     * The unique identifier
     */
    @JsonProperty("uuid")
    @SerializedName("uuid")
    private String uuid;

    /**
     * The available quantity
     */
    @JsonProperty("availableQuantity")
    @SerializedName("availableQuantity")
    private int availableQuantity;

    /**
     * The facility HFR id
     */
    @JsonProperty("facility_id")
    @SerializedName("facility_id")
    private String facilityId;

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

    /**
     * The number of months of stock
     */
    @JsonProperty("stockOfMonth")
    @SerializedName("stockOfMonth")
    private int stockOfMonth;

    /**
     * Stock quantity
     */
    @JsonProperty("stockQuantity")
    @SerializedName("stockQuantity")
    private int stockQuantity;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
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

    public int getStockOfMonth() {
        return stockOfMonth;
    }

    public void setStockOfMonth(int stockOfMonth) {
        this.stockOfMonth = stockOfMonth;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
