package com.jay.viewholderpassdata.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jay on 22-09-2018.
 */

public class ResponseModel {

    @SerializedName("Skills")
    @Expose
    private List<CustomModel> skills = null;
    @SerializedName("Location")
    @Expose
    private List<Location> location = null;
    @SerializedName("RecentlyAdded")
    @Expose
    private List<CustomModel> recentlyAdded = null;
    @SerializedName("Gender")
    @Expose
    private List<CustomModel> gender = null;

}
