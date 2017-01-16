package com.easyapp.fansbeabuty;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLogin extends BaseFragment {


    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.bt_logout)
    Button btLogout;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.bt_login, R.id.bt_logout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
                break;
            case R.id.bt_logout:
                LoginManager.getInstance().logOut();
                break;
        }
    }

    @Override
    protected void onFaceBookLoginSuccess(LoginResult loginResult) {
        super.onFaceBookLoginSuccess(loginResult);
        AddFragment(new FragmentFans());
    }
}
