package com.easyapp.facebook.module.entities;

import org.json.JSONObject;

import java.sql.Timestamp;

/**
 * Created by easyapp_jim on 15/5/14.
 */
public class User {
    private JSONObject jsonObject;

    public User(JSONObject jsonObject) {
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        this.jsonObject = jsonObject;
    }

    public String getId() {
        return jsonObject.optString("id");
    }

    public String getEmail() {
        return jsonObject.optString("email");
    }

    public String getName() {
        return jsonObject.optString("name");
    }

    public String getIcon() {
        return "https://graph.facebook.com/" + getId() + "/picture?type=large&?timestamp=" + getTimeStamp();
    }

    private String getTimeStamp() {
        java.util.Date date = new java.util.Date();
        System.out.println(new Timestamp(date.getTime()));
        return new Timestamp(date.getTime()) + "";
    }
}
