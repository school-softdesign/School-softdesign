package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;

public class ContactsFragment extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mainView = inflater.inflate(R.layout.fragment_contacts, container, false);

        getActivity().setTitle(getResources().getString(R.string.fragment_contacts_title));
        setRetainInstance(true); //don`t remove fragment after rotate screen
        return mainView;
    }

    //////12123124124
}
