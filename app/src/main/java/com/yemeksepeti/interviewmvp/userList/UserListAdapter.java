package com.yemeksepeti.interviewmvp.userList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yemeksepeti.interviewmvp.R;
import com.yemeksepeti.interviewmvp.model.adapter.UserListItem;
import com.yemeksepeti.interviewmvp.model.common.User;
import com.yemeksepeti.interviewmvp.util.Fonty;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by farukyavuz on 27/08/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private Context context;
    private List<UserListItem> userListItems;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;

    public UserListAdapter(Context context, List<UserListItem> userListItems) {
        this.context = context;
        this.userListItems = userListItems;
        this.inflater = LayoutInflater.from(context);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (UserListItem.UserListItemType.get(viewType)) {
            case USER:
                view = inflater.inflate(R.layout.item_user, parent, false);
                view.setOnClickListener(this);
                Fonty.setFontAllView((ViewGroup) view);
                return new UserViewHolder(view);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        UserListItem userListItem = userListItems.get(position);

        switch (userListItem.getType()) {
            case USER:
                UserViewHolder userViewHolder = (UserViewHolder) holder;
                final User user = (User) userListItem.getData();

                if (user.getUserImage() != null) {
                    Picasso.with(context).load(user.getUserImage().getUrl()).into(userViewHolder.profileImage);
                }
                userViewHolder.firstName.setText(user.getName().getFirst());
                userViewHolder.lastName.setText(user.getName().getLast());
                userViewHolder.phone.setText(user.getPhone());
                holder.itemView.setTag(user);
                break;
            default:
                break;
        }
    }


    @Override
    public int getItemCount() {
        return (null != userListItems ? userListItems.size() : 0);
    }


    private static class UserViewHolder extends RecyclerView.ViewHolder {
        CircleImageView profileImage;
        TextView firstName;
        TextView lastName;
        TextView phone;

        UserViewHolder(View itemView) {
            super(itemView);
            this.profileImage = itemView.findViewById(R.id.item_user_profile_image);
            this.firstName = itemView.findViewById(R.id.item_user_firstname);
            this.lastName = itemView.findViewById(R.id.item_user_last_name);
            this.phone = itemView.findViewById(R.id.item_user_phone);
        }
    }

    @Override
    public void onClick(View view) {
        onItemClickListener.onItemClick(view, (User) view.getTag());
    }

    public interface OnItemClickListener {
        void onItemClick(View view, User user);
    }

}
