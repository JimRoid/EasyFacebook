package com.easyapp.facebook.module.entities;

import org.json.JSONObject;

/**
 * Created by easyapp_jim on 15/5/14.
 */
public class Actions {
    private JSONObject jsonObject;

    public Actions(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public String getLink() {
        return jsonObject.optString("link");
    }

    public String getName() {
        return jsonObject.optString("name");
    }


}
