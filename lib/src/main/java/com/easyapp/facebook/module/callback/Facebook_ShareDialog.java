package com.easyapp.facebook.module.callback;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhotoContent;

/**
 * Created by easyapp_jim on 15/9/2.
 */
public interface Facebook_ShareDialog {
    void SharePhoto(SharePhotoContent sharePhotoContent);

    void ShareLink(ShareLinkContent shareLinkContent);
}
