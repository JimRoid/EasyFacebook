package com.easyapp.facebook.module;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * 為了更大更好的facebook v4
 * <p/>
 * 建立的這個tool
 * Created by easyapp_jim on 15/5/14.
 */
public class FacebookTool {
    private boolean isDebug = true;
    private Activity activity;


    public FacebookTool() {
    }

    public FacebookTool(Activity activity) {
        this.activity = activity;
    }


    public void getMe(Bundle bundle, Callback callback) {

        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(), DefaultGraphJSONObjectCallback(callback)
        );
        request.setParameters(bundle);
        request.executeAsync();

    }

    /**
     * 取得讚
     *
     * @param object_id
     * @param callback
     */
    public void getLike(String object_id, Callback callback) {
        GraphRequest graphRequest = new GraphRequest(AccessToken.getCurrentAccessToken(),
                "/" + object_id + "/likes",
                null,
                HttpMethod.GET,
                DefaultCallback(callback));
        graphRequest.executeAsync();
    }

    /**
     * 發送讚
     *
     * @param object_id
     * @param callback
     */
    public void postLike(String object_id, Callback callback) {
        GraphRequest graphRequest = new GraphRequest(AccessToken.getCurrentAccessToken(),
                "/" + object_id + "/likes",
                null,
                HttpMethod.POST,
                DefaultCallback(callback));
        graphRequest.executeAsync();
    }

    /**
     * @param post_id
     * @param bundle
     * @param callback
     */
    public void getComments(String post_id, Bundle bundle, Callback callback) {
        if (bundle == null) {
            bundle = new Bundle();
        }

        GraphRequest graphRequest = new GraphRequest(AccessToken.getCurrentAccessToken(),
                "/" + post_id + "/comments",
                bundle,
                HttpMethod.GET,
                DefaultCallback(callback));
        graphRequest.executeAsync();
    }

    /**
     * @param post_id
     * @param message
     * @param callback
     */
    public void postComments(String post_id, String message, Callback callback) {
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        GraphRequest graphRequest = new GraphRequest(AccessToken.getCurrentAccessToken(),
                "/" + post_id + "/comments",
                bundle,
                HttpMethod.POST,
                DefaultCallback(callback));
        graphRequest.executeAsync();
    }

    public void getFeed(String id, Bundle bundle, Callback callback) {
        GraphRequest graphRequest = new GraphRequest(AccessToken.getCurrentAccessToken(),
                "/" + id + "/feed",
                bundle,
                HttpMethod.GET,
                DefaultCallback(callback));
        graphRequest.executeAsync();
    }

    public void getFeed(String id, Callback callback) {
        Bundle bundle = new Bundle();
        GraphRequest graphRequest = new GraphRequest(AccessToken.getCurrentAccessToken(),
                "/" + id + "/feed",
                bundle,
                HttpMethod.GET,
                DefaultCallback(callback));
        graphRequest.executeAsync();
    }

    public void getPost(String id,Bundle bundle, Callback callback) {
        GraphRequest graphRequest = new GraphRequest(AccessToken.getCurrentAccessToken(),
                "/" + id,
                bundle,
                HttpMethod.GET,
                DefaultCallback(callback));
        graphRequest.executeAsync();
    }

    public void getNext(GraphResponse graphResponse, Callback callback) {
        if (graphResponse.getRequestForPagedResults(GraphResponse.PagingDirection.NEXT) == null) {
            return;
        }

        GraphRequest graphRequest = graphResponse.getRequestForPagedResults(GraphResponse.PagingDirection.NEXT);
        graphRequest.setCallback(DefaultCallback(callback));
        graphRequest.executeAsync();
    }


    public void getRequestPermission(Permission[] permissions) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            arrayList.add(permissions[i].getValue());
        }
        LoginManager.getInstance().logInWithPublishPermissions(
                activity,
                arrayList);
    }

    private GraphRequest.GraphJSONObjectCallback DefaultGraphJSONObjectCallback(final Callback callback) {
        return new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject jsonObject, GraphResponse graphResponse) {
                if (graphResponse.getError() != null) {
                    callback.fail();
                    if (isDebug) {

                    }
                } else {
                    if (isDebug) {

                    }
                    callback.complete(graphResponse, graphResponse.getJSONObject());
                }
            }
        };
    }

    /**
     * @param callback
     * @return
     */
    private GraphRequest.Callback DefaultCallback(final Callback callback) {
        GraphRequest.Callback GraphRequestcallback = new GraphRequest.Callback() {
            @Override
            public void onCompleted(GraphResponse graphResponse) {
                if (graphResponse.getError() != null) {
                    callback.fail();
                    if (isDebug) {

                    }
                } else {
                    if (isDebug) {

                    }
                    callback.complete(graphResponse, graphResponse.getJSONObject());
                }
            }
        };
        return GraphRequestcallback;
    }

    public interface Callback {
        void complete(GraphResponse graphResponse, JSONObject jsonObject);

        void fail();
    }


}
