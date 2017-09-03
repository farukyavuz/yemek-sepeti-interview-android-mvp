package com.yemeksepeti.interviewmvp.userList;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.yemeksepeti.interviewmvp.R;
import com.yemeksepeti.interviewmvp.login.LoginActivity;
import com.yemeksepeti.interviewmvp.model.adapter.UserListItem;
import com.yemeksepeti.interviewmvp.model.common.User;
import com.yemeksepeti.interviewmvp.userDetail.UserDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserListActivity extends AppCompatActivity implements UserListView, UserListAdapter.OnItemClickListener {

    @BindView(R.id.user_list_recyclerview)
    RecyclerView usersRecyclerView;

    private UserListAdapter mUserListAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<UserListItem> userListItems;

    private UserListPresenter presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        ButterKnife.bind(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setLogo(R.drawable.user_list_actionbar_logo);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
        }

        usersRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        usersRecyclerView.setLayoutManager(mLayoutManager);
        userListItems = new ArrayList<>();
        mUserListAdapter = new UserListAdapter(this, userListItems);
        usersRecyclerView.setAdapter(mUserListAdapter);
        mUserListAdapter.setOnItemClickListener(this);
        presenter = new UserListPresenterImpl(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getResources().getString(R.string.loading));
        progressDialog.setCancelable(false);

        presenter.getUsetList();
    }

    @Override
    public void onItemClick(View view, User user) {
        String id = user.get_id();
        startActivity(new Intent(getApplicationContext(), UserDetailActivity.class).putExtra("id", id));
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
    public void updateList(List<User> userList) {
        progressDialog.dismiss();

        userListItems.clear();
        for (User user : userList) {
            if (!user.getEmail().equals(getResources().getString(R.string.autofill_email)))
                userListItems.add(new UserListItem(user));
        }
        mUserListAdapter.notifyDataSetChanged();
    }
}
