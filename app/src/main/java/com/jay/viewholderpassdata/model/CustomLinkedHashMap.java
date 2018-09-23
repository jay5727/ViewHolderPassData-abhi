package com.jay.viewholderpassdata.model;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Jay on 22-09-2018.
 */

public class CustomLinkedHashMap {

    private LinkedHashMap<String, List<CustomModel>> lst;

    public LinkedHashMap<String, List<CustomModel>> getLst() {
        return lst;
    }

    public void setLst(LinkedHashMap<String, List<CustomModel>> name) {
        this.lst = name;
    }
}
