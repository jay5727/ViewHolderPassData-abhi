package com.jay.viewholderpassdata.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jay on 13-09-2018.
 */
public class CustomModel implements Serializable {

    @SerializedName("Name")
    @Expose
    private String Name;

/*
    private List<CustomModel> lst ;

    public  List<CustomModel>  getList() {
        return lst;
    }

    public void setList(List<CustomModel> lst) {
        this.lst = lst;
    }

    public CustomModel(CustomModel obj)
    {
        //this.lst= lst;
    }*/

    public CustomModel(String name, boolean isSelected) {
        this.Name = name;
        this.isSelected = isSelected;
    }

    @SerializedName("isSelected")

    @Expose
    private boolean isSelected;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
