package com.softdesign.school.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.ui.activities.MainActivity;

public class SimpleToolbarFragment extends Fragment {
    Toolbar mToolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View toolbar = inflater.inflate(R.layout.toolbar_simple, container, false);

        mToolbar = (Toolbar) toolbar.findViewById(R.id.toolbar);
        setupToolbar();

        return toolbar;
    }

    private  void setupToolbar(){
        ((MainActivity) getActivity()).setSupportActionBar(mToolbar);
        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}



