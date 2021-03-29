package tz.go.moh.him.thscp.mediator.elmis.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class PharmaceuticalAndLaboratoryPersonnelRequest {
    /**
     * The unique identifier
     */
    @JsonProperty("uuid")
    @SerializedName("uuid")
    private String uuid;

    /**
     * The facility id
     */
    @JsonProperty("facilityId")
    @SerializedName("facilityId")
    private String facilityId;

    /**
     * The period date
     */
    @JsonProperty("period")
    @SerializedName("period")
    private String period;

    /**
     * The post Id
     */
    @JsonProperty("postId")
    @SerializedName("postId")
    private String postId;

    /**
     * The post Name
     */
    @JsonProperty("postName")
    @SerializedName("postName")
    private String postName;

    /**
     * The total number of posts
     */
    @JsonProperty("totalPost")
    @SerializedName("totalPost")
    private int totalPost;

    /**
     * The number of vacant post
     */
    @JsonProperty("vacantPost")
    @SerializedName("vacantPost")
    private int vacantPost;

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

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public int getTotalPost() {
        return totalPost;
    }

    public void setTotalPost(int totalPost) {
        this.totalPost = totalPost;
    }

    public int getVacantPost() {
        return vacantPost;
    }

    public void setVacantPost(int vacantPost) {
        this.vacantPost = vacantPost;
    }
}
