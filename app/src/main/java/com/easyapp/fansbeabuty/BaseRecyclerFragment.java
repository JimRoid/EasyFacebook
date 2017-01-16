package com.easyapp.fansbeabuty;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.easyapp.baseproject.lib.baseFragment.list.BaseRecyclerViewFragment;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.orhanobut.logger.Logger;

/**
 * Created by easyapp_jim on 2016/6/4.
 */
public abstract class BaseRecyclerFragment extends BaseRecyclerViewFragment {
    CallbackManager callbackManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Logger.d("onSuccess");
                onFaceBookLoginSuccess(loginResult);
            }

            @Override
            public void onCancel() {
                Logger.d("onCancel");
                onFaceBookLoginCancel();
            }

            @Override
            public void onError(FacebookException error) {
                Logger.d("onError");
                onFaceBookLoginError(error);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    protected void onFaceBookLoginSuccess(LoginResult loginResult) {

    }

    protected void onFaceBookLoginCancel() {

    }

    protected void onFaceBookLoginError(FacebookException error) {

    }
    @Override
    protected void setOnRecycleAdapter() {

    }
}
