package tz.go.moh.him.thscp.mediator.elmis.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class ProductListRequest {
    /**
     * The unique identifier
     */
    @JsonProperty("uuid")
    @SerializedName("uuid")
    private String uuid;

    /**
     * The product category
     */
    @JsonProperty("category")
    @SerializedName("category")
    private String category;

    /**
     * The description
     */
    @JsonProperty("description")
    @SerializedName("description")
    private String description;

    /**
     * The name
     */
    @JsonProperty("name")
    @SerializedName("name")
    private String name;

    /**
     * The product code
     */
    @JsonProperty("productCode")
    @SerializedName("productCode")
    private String productCode;

    /**
     * The Product Unit
     */
    @JsonProperty("productUnit")
    @SerializedName("productUnit")
    private String productUnit;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }
}
