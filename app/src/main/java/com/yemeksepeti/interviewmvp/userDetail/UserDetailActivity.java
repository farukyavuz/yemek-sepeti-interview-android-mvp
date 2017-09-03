package com.yemeksepeti.interviewmvp.userDetail;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.yemeksepeti.interviewmvp.R;
import com.yemeksepeti.interviewmvp.login.LoginActivity;
import com.yemeksepeti.interviewmvp.model.common.User;
import com.yemeksepeti.interviewmvp.util.Fonty;
import com.yemeksepeti.interviewmvp.util.YSHelpers;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class UserDetailActivity extends AppCompatActivity implements UserDetailView {

    @BindView(R.id.user_detail_root_view)
    ScrollView rootView;
    @BindView(R.id.user_detail_profile_image)
    CircleImageView profileImage;
    @BindView(R.id.user_detail_tv_first_name)
    TextView firstName;
    @BindView(R.id.user_detail_tv_last_name)
    TextView lastName;
    @BindView(R.id.user_detail_tv_birthday)
    TextView birthDay;
    @BindView(R.id.user_detail_et_phone)
    EditText phone;
    @BindView(R.id.user_detail_et_email)
    EditText email;
    @BindView(R.id.user_detail_et_address)
    EditText address;
    @BindView(R.id.user_detail_btn_save)
    Button btnSave;

    private ProgressDialog progressDialog;
    private String id;
    private UserDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);
        Fonty.setFontAllView(rootView);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        if (getIntent() != null) {
            id = getIntent().getExtras().getString("id", "empty");
        }

        presenter = new UserDetailPresenterImpl(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getResources().getString(R.string.loading));
        progressDialog.setCancelable(false);

        presenter.getUserDetail(id);

        btnSave.setOnClickListener(view -> presenter.updateUserDetail(id, email.getText().toString(), phone.getText().toString(), address.getText().toString()));
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
    public void setEmailError() {
        Toast.makeText(this, getString(R.string.email_invalid), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPhoneNumberError() {
        Toast.makeText(this, getString(R.string.phone_invalid), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setInternetConnectionError() {
        Toast.makeText(this, R.string.internet_connection_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setTokenError() {
        Toast.makeText(this, R.string.invalid_token, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

    @Override
    public void userUpdated() {
        showSuccessDialog();
    }

    @Override
    public void getUser(User user) {

        if (user.getUserImage() != null) {
            Picasso.with(getApplicationContext()).load(user.getUserImage().getUrl()).into(profileImage);
        }

        firstName.setText(user.getName().getFirst());
        lastName.setText(user.getName().getLast());

        if (user.getBirthday() != null) {
            birthDay.setText(YSHelpers.ConvertDateToString("dd/MM/yyyy", user.getBirthday()));
        }
        phone.setText(user.getPhone());
        email.setText(user.getEmail());
        address.setText(user.getAddress());
        phone.setSelection(phone.getText().length());
        email.setSelection(email.getText().length());
        address.setSelection(address.getText().length());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.completed));
        builder.setMessage(getString(R.string.user_updated));
        builder.setPositiveButton(getString(R.string.ok), (dialogInterface, i) -> onBackPressed());
        builder.setCancelable(false);
        builder.show();
    }
}
