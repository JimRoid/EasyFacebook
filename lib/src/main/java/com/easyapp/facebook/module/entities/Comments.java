package com.easyapp.facebook.module.entities;


import org.json.JSONObject;

/**
 * Created by easyapp_jim on 15/4/24.
 */
public class Comments {
    private JSONObject jsonObject;

    public Comments(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public String getId() {
        return jsonObject.optString("id");
    }

    public String getMessage() {
        return jsonObject.optString("message");
    }

    public String getCreatedTime() {
        return jsonObject.optString("created_time");
    }

    public User getFrom() {
        return new User(jsonObject.optJSONObject("from"));
    }

    public String getComment_count() {
        return jsonObject.optString("comment_count");
    }

}
