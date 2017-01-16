package com.easyapp.facebook.module.callback;

import com.facebook.CallbackManager;
import com.facebook.share.widget.ShareDialog;

/**
 * Created by easyapp_jim on 15/9/2.
 */
public interface Facebook_callback_manager {
    CallbackManager getCallbackManager();

    ShareDialog getShareDialog();
}
