package com.easyapp.fansbeabuty;

import android.content.Intent;

import com.easyapp.baseproject.lib.baseActivity.BaseDrawerMainActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;

public class MainActivity extends BaseDrawerMainActivity {

    CallbackManager callbackManager;

    @Override
    protected void initial() {
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        ReplaceFragment(new FragmentLogin());
    }

    private void installLeft(){

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
