package com.easyapp.facebook.module.entities;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by easyapp_jim on 15/6/1.
 */
public class Like {
    private JSONObject jsonObject;

    public Like(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public String getCount() {
        JSONArray jsonArray = jsonObject.optJSONArray("data");
        if (jsonArray != null) {
            return jsonArray.length() + "";
        } else {
            return "0";
        }
    }

    public User getUser(int position) {
        JSONArray jsonArray = jsonObject.optJSONArray("data");
        return new User(jsonArray.optJSONObject(position));
    }
}
