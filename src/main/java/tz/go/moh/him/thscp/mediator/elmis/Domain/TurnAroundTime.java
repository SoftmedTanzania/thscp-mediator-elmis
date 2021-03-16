package tz.go.moh.him.thscp.mediator.elmis.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class TurnAroundTime {
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
}
