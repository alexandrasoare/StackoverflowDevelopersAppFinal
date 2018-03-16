package com.example.adasoare.stackoverflowdevelopersapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BadgeCounts {
    @SerializedName("bronze")
    @Expose
    int bronze;

    @SerializedName("silver")
    @Expose
    int silver;

    @SerializedName("gold")
    @Expose
    int gold;

    public BadgeCounts() {}

    public BadgeCounts(int bronze, int silver, int gold) {
        this.bronze = bronze;
        this.silver = silver;
        this.gold = gold;
    }

    public int getBronze() {
        return bronze;
    }

    public void setBronze(int bronze) {
        this.bronze = bronze;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
