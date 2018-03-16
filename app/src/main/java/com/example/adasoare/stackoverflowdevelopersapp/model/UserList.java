package com.example.adasoare.stackoverflowdevelopersapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    @SerializedName("items")
    @Expose
    List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int size() {
        return users.size();
    }

    public User get(int i) {
        return users.get(i);
    }

    public User getUserById(Integer id) {
        for (User user : users) {
            if (user.getUserID() == id)
                return user;
        }
        return new User();
    }
}
