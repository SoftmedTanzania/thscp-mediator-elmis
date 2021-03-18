package tz.go.moh.him.thscp.mediator.elmis.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class StockOnHandStatusRequest {
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
     * The damaged stock percentage
     */
    @JsonProperty("damagedPercentage")
    @SerializedName("damagedPercentage")
    private float damagedPercentage;

    /**
     * The expired stock percentage
     */
    @JsonProperty("expiredPercentage")
    @SerializedName("expiredPercentage")
    private float expiredPercentage;

    /**
     * The facility HFR Id
     */
    @JsonProperty("facilityId")
    @SerializedName("facilityId")
    private String facilityId;

    /**
     * The lost stock percentage
     */
    @JsonProperty("lostPercentage")
    @SerializedName("lostPercentage")
    private float lostPercentage;

    /**
     * The facilityLevel
     */
    @JsonProperty("facilityLevel")
    @SerializedName("facilityLevel")
    private int facilityLevel;

    /**
     * The months of stock
     */
    @JsonProperty("monthsOfStock")
    @SerializedName("monthsOfStock")
    private int monthsOfStock;

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

    /**
     * The quantity
     */
    @JsonProperty("quantity")
    @SerializedName("quantity")
    private int quantity;

    /**
     * The stock Id
     */
    @JsonProperty("stockId")
    @SerializedName("stockId")
    private String stockId;

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

    public float getDamagedPercentage() {
        return damagedPercentage;
    }

    public void setDamagedPercentage(float damagedPercentage) {
        this.damagedPercentage = damagedPercentage;
    }

    public float getExpiredPercentage() {
        return expiredPercentage;
    }

    public void setExpiredPercentage(float expiredPercentage) {
        this.expiredPercentage = expiredPercentage;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public float getLostPercentage() {
        return lostPercentage;
    }

    public void setLostPercentage(float lostPercentage) {
        this.lostPercentage = lostPercentage;
    }

    public int getFacilityLevel() {
        return facilityLevel;
    }

    public void setFacilityLevel(int facilityLevel) {
        this.facilityLevel = facilityLevel;
    }

    public int getMonthsOfStock() {
        return monthsOfStock;
    }

    public void setMonthsOfStock(int monthsOfStock) {
        this.monthsOfStock = monthsOfStock;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }
}
