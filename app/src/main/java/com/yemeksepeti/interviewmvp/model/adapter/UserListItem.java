package com.yemeksepeti.interviewmvp.model.adapter;

import android.util.SparseArray;

import com.yemeksepeti.interviewmvp.model.common.User;

/**
 * Created by farukyavuz on 27/08/2017.
 * Copyright (c) 2017
 * All rights reserved.
 */

public class UserListItem {
    private UserListItemType type;
    private Object data;

    public UserListItem(Object data) {
        this.data = data;
        if (data instanceof User)
            this.type = UserListItemType.USER;
    }

    public UserListItemType getType() {
        return type;
    }

    public void setType(UserListItemType type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public enum UserListItemType {
        USER(0);

        private static final SparseArray<UserListItemType> lookup = new SparseArray<>();

        static {
            for (UserListItemType userListItemType : UserListItemType.values()) {
                lookup.put(userListItemType.getId(), userListItemType);
            }
        }

        private final int id;

        UserListItemType(int id) {
            this.id = id;
        }

        public static UserListItemType get(int id) {
            return lookup.get(id);
        }

        public int getId() {
            return id;
        }

    }
}
