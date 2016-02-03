package com.softdesign.school.data.storage.model;

import android.graphics.drawable.Drawable;

/**
 * Created by пк on 29.01.2016.
 */
public class User {

    private String mFirstName;
    private String mLastName;
    private int mRait;
    private Drawable mImage;
    private String mVkLink;
    private String mGitLink;

    public User(){}

    public User(Drawable avatar, String firstName, String lastName){
        this.mImage = avatar;
        this.mFirstName = firstName;
        this.mLastName = lastName;
    }

    public User(String mFirstName, String mLastName, Drawable mImage, String mVkLink, String mGitLink, int mRait) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mRait = mRait;
        this.mImage = mImage;
        this.mVkLink = mVkLink;
        this.mGitLink = mGitLink;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public int getmRait() {
        return mRait;
    }


    public Drawable getmImage() {
        return mImage;
    }

    public String getmVkLink() {
        return mVkLink;
    }

    public String getmGitLink() {
        return mGitLink;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public void setmRait(int mRait) {
        this.mRait = mRait;
    }


    public void setmImage(Drawable mImage) {
        this.mImage = mImage;
    }

    public void setmVkLink(String mVkLink) {
        this.mVkLink = mVkLink;
    }

    public void setmGitLink(String mGitLink) {
        this.mGitLink = mGitLink;
    }

    public void saveUserData(String phone, String email, String vk, String git, String bio){

    }
}
