package com.softdesign.school.data.storage.preferenses;

import android.content.SharedPreferences;

import com.softdesign.school.utils.SchoolApplication;

import java.util.ArrayList;
import java.util.List;

public class UserPreferenses {
    private static final String USER_PROFILE_PHONE="phone";
    private static final String USER_PROFILE_EMAIL="email";
    private static final String USER_PROFILE_VK="vk";
    private static final String USER_PROFILE_GIT="git";
    private static final String USER_PROFILE_BIO="bio";
    private static final  String[] USER_FIELDS = {USER_PROFILE_PHONE, USER_PROFILE_EMAIL, USER_PROFILE_VK, USER_PROFILE_GIT, USER_PROFILE_BIO };
    private SharedPreferences mPreferenses;

    public UserPreferenses() {
    }

    public void saveUserProfileData (List<String> userFields){
        mPreferenses=SchoolApplication.getPreferences();
        SharedPreferences.Editor editor = mPreferenses.edit();
        int i=0;
        for (String field : userFields) {
            editor.putString(USER_FIELDS[i],field);
        }
        editor.apply();
    }

    public List<String> loadUserProfileData(){
        mPreferenses=SchoolApplication.getPreferences();
        List<String> userFields = new ArrayList<>();
        userFields.add(mPreferenses.getString(USER_PROFILE_PHONE, ""));
        userFields.add(mPreferenses.getString(USER_PROFILE_EMAIL, ""));
        userFields.add(mPreferenses.getString(USER_PROFILE_VK, ""));
        userFields.add(mPreferenses.getString(USER_PROFILE_GIT, ""));
        userFields.add(mPreferenses.getString(USER_PROFILE_BIO,""));
        return userFields;
    }

}
