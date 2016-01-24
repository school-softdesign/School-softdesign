package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;

public class ProfileFragment extends Fragment implements View.OnClickListener{
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mainView = inflater.inflate(R.layout.fragment_profile, container, false);

        getActivity().setTitle(getResources().getString(R.string.fragment_profile_title));
        
        return mainView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*Button addActivity = (Button) getActivity().findViewById(R.id.new_activity);
        addActivity.setOnClickListener(this);*/
    }

    @Override
    public void onClick(View view) {
        /*if (view.getId()==R.id.new_activity){
            Intent intent=new Intent(getActivity(), ProfileActivity.class);
            startActivity(intent);
        }*/
    }
}
