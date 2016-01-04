package com.easyapp.facebook.module;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.easyapp.facebook.module.callback.Facebook_ShareDialog;
import com.easyapp.facebook.module.callback.Facebook_callback_manager;
import com.facebook.FacebookCallback;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;
import java.util.List;

/**
 * 基本的 fb 登入 fragment
 */
public abstract class BaseLoginFragment extends Fragment {
    protected Facebook_callback_manager facebook_callback_manager;
    protected Facebook_ShareDialog facebook_shareDialog;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            facebook_callback_manager = (Facebook_callback_manager) activity;
            facebook_shareDialog = (Facebook_ShareDialog) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    protected void Set_FB_Callback(FacebookCallback<LoginResult> facebookCallback) {
        LoginManager.getInstance().registerCallback(facebook_callback_manager.getCallbackManager(),
                facebookCallback);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        facebook_callback_manager.getCallbackManager().onActivityResult(requestCode, resultCode, data);
    }

    /**
     * fb登入
     */
    protected void FB_Login() {
        List<String> permissionNeeds = Arrays.asList("email", "public_profile");
        LoginManager.getInstance().logInWithReadPermissions(this, permissionNeeds);
    }

    /**
     * 登出fb
     */
    protected void FB_Logout() {
        LoginManager.getInstance().logOut();
    }


}
