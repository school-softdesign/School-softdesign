package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.ui.activities.MainActivity;

public class ProfileFragment extends Fragment {
    private static final String FUNCTIONALITY_PROFILE_VIEW = "profile_view";
    private static final String FUNCTIONALITY_PROFILE_EDIT = "profile_edit";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mainView = inflater.inflate(R.layout.fragment_profile, null, false);

        getActivity().setTitle(getResources().getString(R.string.fragment_profile_title));
        ((MainActivity) getActivity()).collapseAppBar(false);
        return mainView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        params.setAnchorId(R.id.appbar_layout);
        params.anchorGravity= Gravity.BOTTOM|Gravity.RIGHT;
        fab.setLayoutParams(params);
        fab.setImageResource(R.drawable.ic_call_white_24dp);;
    }
}
