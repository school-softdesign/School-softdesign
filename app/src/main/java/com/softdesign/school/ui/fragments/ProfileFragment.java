package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.ui.activities.MainActivity;

public class ProfileFragment extends Fragment {
    private Toolbar mToolbar;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mainView = inflater.inflate(R.layout.fragment_profile, null, false);

        getActivity().setTitle(getResources().getString(R.string.fragment_profile_title));
        ((MainActivity) getActivity()).lockAppBar(false);
        return mainView;
    }
}
