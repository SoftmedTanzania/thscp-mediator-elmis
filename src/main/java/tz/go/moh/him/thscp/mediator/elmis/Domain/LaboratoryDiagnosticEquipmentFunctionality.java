package tz.go.moh.him.thscp.mediator.elmis.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class LaboratoryDiagnosticEquipmentFunctionality {
    /**
     * The unique identifier
     */
    @JsonProperty("uuid")
    @SerializedName("uuid")
    private String uuid;

    /**
     * The equipment name
     */
    @JsonProperty("equipmentName")
    @SerializedName("equipmentName")
    private String equipmentName;

    /**
     * The facility Id
     */
    @JsonProperty("facilityId")
    @SerializedName("facilityId")
    private String facilityId;

    /**
     * The installed Date
     */
    @JsonProperty("installedDate")
    @SerializedName("installedDate")
    private String installedDate;

    /**
     * The quantity
     */
    @JsonProperty("quantity")
    @SerializedName("quantity")
    private int quantity;

    /**
     * The status
     */
    @JsonProperty("status")
    @SerializedName("status")
    private String status;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getInstalledDate() {
        return installedDate;
    }

    public void setInstalledDate(String installedDate) {
        this.installedDate = installedDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
