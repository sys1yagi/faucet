package com.sys1yagi.android.todomin.android.faucet_develop.faucet_develop.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private int id;

    private String name;

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
    }

    private User(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
    }

    public static Creator<User> CREATOR = new Creator<User>() {
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
