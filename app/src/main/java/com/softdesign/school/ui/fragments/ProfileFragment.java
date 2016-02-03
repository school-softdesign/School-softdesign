package com.softdesign.school.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.preferenses.UserPreferenses;
import com.softdesign.school.ui.activities.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProfileFragment extends Fragment {

    private static final String FUNCTIONALITY_PROFILE_VIEW = "profile_view";
    private static final String FUNCTIONALITY_PROFILE_EDIT = "profile_edit";
    private static String sCurrentFunctionality = FUNCTIONALITY_PROFILE_VIEW;
    UserPreferenses userFields;
    List<String> data;
    View mainView = null;

    @Bind({R.id.txt_phone_value, R.id.txt_email_value, R.id.txt_vk_value, R.id.txt_git_value, R.id.txt_bio_value})
    List<TextView> txtViewsValues;
    @Bind({R.id.txt_phone_label, R.id.txt_email_label, R.id.txt_vk_label, R.id.txt_git_label, R.id.txt_bio_label})
    List<TextView> txtViewsLabels;
    @Bind({R.id.et_phone_wrapper, R.id.et_email_wrapper, R.id.et_vk_wrapper, R.id.et_git_wrapper, R.id.et_bio_wrapper})
    List<TextInputLayout> etViewsWrappers;
    @Bind({R.id.et_phone_value, R.id.et_email_value, R.id.et_vk_value, R.id.et_git_value, R.id.et_bio_value})
    List<EditText> etViewsValue;

    public ProfileFragment() {
        this.setRetainInstance(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        userFields = new UserPreferenses();
        data = userFields.loadUserProfileData();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (mainView == null) {
            // Если представления нет, создаем его*/
            mainView = inflater.inflate(R.layout.fragment_profile, container, false);
            ButterKnife.bind(this, mainView);
            setupFuncionality(sCurrentFunctionality);
        }


        getActivity().setTitle(getResources().getString(R.string.fragment_profile_title));
        ((MainActivity) getActivity()).collapseAppBar(false);

        setFieldsData(txtViewsValues, data);
        setFieldsData(etViewsValue, data);
        return mainView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        params.setAnchorId(R.id.appbar_layout);
        params.anchorGravity = Gravity.BOTTOM | Gravity.RIGHT;
        fab.setLayoutParams(params);
        fab.setImageResource(R.drawable.ic_call_white_24dp);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sCurrentFunctionality.equals(FUNCTIONALITY_PROFILE_VIEW)) {
                    setupFuncionality(FUNCTIONALITY_PROFILE_EDIT);
                } else {
                    setupFuncionality(FUNCTIONALITY_PROFILE_VIEW);
                }
            }
        });
    }

    private void setupFuncionality(String Funcionality) {
        switch (Funcionality) {
            case FUNCTIONALITY_PROFILE_VIEW:
                sCurrentFunctionality = FUNCTIONALITY_PROFILE_VIEW;
                List<String> data = getFieldsData(etViewsValue);
                userFields.saveUserProfileData(data);
                setFieldsData(txtViewsValues,data);
                ButterKnife.apply(etViewsWrappers, INVISIBLE);
                ButterKnife.apply(txtViewsValues, VISIBLE);
                ButterKnife.apply(txtViewsLabels, VISIBLE);
                setFieldsData(txtViewsValues, userFields.loadUserProfileData());
                break;
            case FUNCTIONALITY_PROFILE_EDIT:
                sCurrentFunctionality = FUNCTIONALITY_PROFILE_EDIT;
                ButterKnife.apply(etViewsWrappers, VISIBLE);
                ButterKnife.apply(txtViewsValues, INVISIBLE);
                ButterKnife.apply(txtViewsLabels, INVISIBLE);
                break;
            default:
                sCurrentFunctionality = FUNCTIONALITY_PROFILE_VIEW;
                ButterKnife.apply(etViewsWrappers, INVISIBLE);
                ButterKnife.apply(txtViewsValues, VISIBLE);
                ButterKnife.apply(txtViewsLabels, VISIBLE);
                break;
        }
    }

    /**
     * переданные View установить как невидимые
     */
    static final ButterKnife.Action<View> INVISIBLE = new ButterKnife.Action<View>() {
        @Override
        public void apply(View view, int index) {
            view.setVisibility(View.GONE);
        }
    };

    /**
     * переданные View установить как видимые
     */
    static final ButterKnife.Action<View> VISIBLE = new ButterKnife.Action<View>() {
        @Override
        public void apply(View view, int index) {
            view.setVisibility(View.VISIBLE);
        }
    };

    /**
     * вставка массива значений в поля форм
     */
    private  void setFieldsData(List<? extends TextView> viewList, List<String> userFields){
        int i=0;
        for (TextView viewField : viewList) {
            viewField.setText(userFields.get(i));
            i++;
        }
    }

    /**
     * Получение массива значений из полей форм
     */
    private List<String> getFieldsData(List<? extends TextView> viewList){
        List<String> userFields = new ArrayList<String>();
        for (TextView viewField : viewList) {
            userFields.add(viewField.getText().toString());
        }
        return userFields ;
    }

}
