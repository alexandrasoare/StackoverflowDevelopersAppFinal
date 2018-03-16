package com.example.adasoare.stackoverflowdevelopersapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("user_id")
    @Expose
    int userID;

    @SerializedName("profile_image")
    @Expose
    String profileImage;

    @SerializedName("location")
    @Expose
    String location;

    @SerializedName("display_name")
    @Expose
    String displayName;

    @SerializedName("badge_counts")
    @Expose
    BadgeCounts badgeCounts;

    public User() {}

    public User(String displayName, String profileImage) {
        this.displayName = displayName;
        this.profileImage = profileImage;
    }

    public User(int userID, String profileImage, String location, BadgeCounts badgeCounts) {
        this.userID = userID;
        this.profileImage = profileImage;
        this.location = location;
        this.badgeCounts = badgeCounts;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BadgeCounts getBadgeCounts() {
        return badgeCounts;
    }

    public void setBadgeCounts(BadgeCounts badgeCounts) {
        this.badgeCounts = badgeCounts;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
