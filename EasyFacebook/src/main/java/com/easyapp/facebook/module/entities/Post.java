package com.easyapp.facebook.module.entities;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by easyapp_jim on 15/5/14.
 */
public class Post {

    private JSONObject jsonObject;

    public Post(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public boolean isTag() {
        if (getMessage().indexOf("#") >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public String getId(){
        return jsonObject.optString("id");
    }

    public String getMessage() {
        return jsonObject.optString("message");
    }

    public String getFull_Picture() {
        return jsonObject.optString("full_picture");
    }

    public String getPicture() {
        return jsonObject.optString("picture");
    }

    public String getUpdatedTime() {
        return jsonObject.optString("updated_time");
    }

    public Like getLikes() {
        JSONObject like = jsonObject.optJSONObject("likes");
        if (like == null) {
            like = new JSONObject();
        }
        return new Like(like);
    }

    public User getFrom() {
        return new User(jsonObject.optJSONObject("from"));
    }

    public ArrayList<Actions> getActions() {
        JSONArray jsonArray = jsonObject.optJSONArray("actions");
        ArrayList<Actions> arrayList = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                arrayList.add(new Actions(jsonArray.optJSONObject(i)));
            }
        }
        return arrayList;
    }

    public ArrayList<Comments> getComments() {
        JSONObject comments = jsonObject.optJSONObject("comments");
        ArrayList<Comments> arrayList = new ArrayList<>();
        if (comments != null) {
            JSONArray jsonArray = comments.optJSONArray("data");
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    arrayList.add(new Comments(jsonArray.optJSONObject(i)));
                }
            }
        }
        return arrayList;
    }
}
