package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.softdesign.school.R;
import com.softdesign.school.ui.activities.MainActivity;

public class ContactsFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mainView = inflater.inflate(R.layout.fragment_contacts, container, false);
        ((MainActivity) getActivity()).lockAppBar(true);
        getActivity().setTitle(getResources().getString(R.string.fragment_contacts_title));
        return mainView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageView mToolbar = (ImageView) getActivity().findViewById(R.id.toolbar_image);
        mToolbar.setImageResource(R.drawable.my_bg);
    }
}
