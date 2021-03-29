package tz.go.moh.him.thscp.mediator.elmis.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class TurnAroundTimeRequest {
    /**
     * The unique identifier
     */
    @JsonProperty("uuid")
    @SerializedName("uuid")
    private String uuid;

    /**
     * The delivered quantity
     */
    @JsonProperty("deliveredQuantity")
    @SerializedName("deliveredQuantity")
    private int deliveredQuantity;

    /**
     * The delivery date
     */
    @JsonProperty("deliveryDate")
    @SerializedName("deliveryDate")
    private String deliveryDate;

    /**
     * The delivery facility id
     */
    @JsonProperty("deliveryFromFacilityId")
    @SerializedName("deliveryFromFacilityId")
    private String deliveryFromFacilityId;

    /**
     * The delivery promise date
     */
    @JsonProperty("deliveryPromiseDate")
    @SerializedName("deliveryPromiseDate")
    private String deliveryPromiseDate;

    /**
     * The order date
     */
    @JsonProperty("orderDate")
    @SerializedName("orderDate")
    private String orderDate;

    /**
     * The order From Facility Id
     */
    @JsonProperty("orderFromFacilityId")
    @SerializedName("orderFromFacilityId")
    private String orderFromFacilityId;


    /**
     * The order Id
     */
    @JsonProperty("orderId")
    @SerializedName("orderId")
    private String orderId;


    /**
     * The order Status
     */
    @JsonProperty("orderStatus")
    @SerializedName("orderStatus")
    private String orderStatus;

    /**
     * The order type
     */
    @JsonProperty("orderType")
    @SerializedName("orderType")
    private String orderType;


    /**
     * The ordered quantity
     */
    @JsonProperty("orderedQuantity")
    @SerializedName("orderedQuantity")
    private int orderedQuantity;


    /**
     * The product Code
     */
    @JsonProperty("productCode")
    @SerializedName("productCode")
    private String productCode;


    /**
     * The program Code
     */
    @JsonProperty("programCode")
    @SerializedName("programCode")
    private String programCode;

    /**
     * The target Days
     */
    @JsonProperty("targetDays")
    @SerializedName("targetDays")
    private int targetDays;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getDeliveredQuantity() {
        return deliveredQuantity;
    }

    public void setDeliveredQuantity(int deliveredQuantity) {
        this.deliveredQuantity = deliveredQuantity;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryFromFacilityId() {
        return deliveryFromFacilityId;
    }

    public void setDeliveryFromFacilityId(String deliveryFromFacilityId) {
        this.deliveryFromFacilityId = deliveryFromFacilityId;
    }

    public String getDeliveryPromiseDate() {
        return deliveryPromiseDate;
    }

    public void setDeliveryPromiseDate(String deliveryPromiseDate) {
        this.deliveryPromiseDate = deliveryPromiseDate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderFromFacilityId() {
        return orderFromFacilityId;
    }

    public void setOrderFromFacilityId(String orderFromFacilityId) {
        this.orderFromFacilityId = orderFromFacilityId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(int orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
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

    public int getTargetDays() {
        return targetDays;
    }

    public void setTargetDays(int targetDays) {
        this.targetDays = targetDays;
    }
}
