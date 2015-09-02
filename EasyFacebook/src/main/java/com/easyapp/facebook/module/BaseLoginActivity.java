package com.easyapp.facebook.module;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.easyapp.facebook.module.callback.Facebook_callback_manager;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;

/**
 * 基本的登入 fb 的 activity
 */
public abstract class BaseLoginActivity extends AppCompatActivity implements Facebook_callback_manager {
    protected CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public CallbackManager getCallbackManager() {
        return callbackManager;
    }
}
