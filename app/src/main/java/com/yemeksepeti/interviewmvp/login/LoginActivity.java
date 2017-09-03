package com.yemeksepeti.interviewmvp.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import com.yemeksepeti.interviewmvp.R;
import com.yemeksepeti.interviewmvp.YSApplication;
import com.yemeksepeti.interviewmvp.userList.UserListActivity;
import com.yemeksepeti.interviewmvp.util.Fonty;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.login_root_view)
    ScrollView rootView;
    @BindView(R.id.activity_login_email)
    EditText email;
    @BindView(R.id.activity_login_password)
    EditText password;
    @BindView(R.id.activity_login_login_button)
    Button loginButton;
    @BindView(R.id.activity_login_autofill_button)
    Button autoFillButton;

    private ProgressDialog progressDialog;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Fonty.setFontAllView(rootView);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getResources().getString(R.string.loading));
        progressDialog.setCancelable(false);

        presenter = new LoginPresenterImpl(this);


        loginButton.setOnClickListener(view -> presenter.validateCredentials(email.getText().toString(), password.getText().toString()));

        autoFillButton.setOnClickListener(view -> {
            email.setText(getString(R.string.autofill_email));
            password.setText(getString(R.string.autofill_password));
            email.setSelection(email.getText().length());
            password.setSelection(password.getText().length());
        });


    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void setUsernameError() {
        Toast.makeText(YSApplication.getAppContext(), getString(R.string.email_invalid), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError() {
        Toast.makeText(YSApplication.getAppContext(), getString(R.string.login_password_invalid), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setInternetConnectionError() {
        Toast.makeText(YSApplication.getAppContext(), getString(R.string.internet_connection_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setLoginError() {
        Toast.makeText(YSApplication.getAppContext(), getString(R.string.wrong_email_or_password), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        startActivity(new Intent(this, UserListActivity.class));
        finish();
    }
}
