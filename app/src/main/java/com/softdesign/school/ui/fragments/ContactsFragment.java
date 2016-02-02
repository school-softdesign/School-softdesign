package com.softdesign.school.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.model.User;
import com.softdesign.school.ui.activities.MainActivity;
import com.softdesign.school.ui.adapters.ContactAdapter;

import java.util.ArrayList;

public class ContactsFragment extends Fragment implements View.OnClickListener{

    ArrayList<User> mUsers = new ArrayList<User>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerView listContacts;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        generateData();
        mAdapter = new ContactAdapter(mUsers);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mainView = inflater.inflate(R.layout.fragment_contacts, container, false);
        ((MainActivity) getActivity()).collapseAppBar(true);
        getActivity().setTitle(getResources().getString(R.string.fragment_contacts_title));

        listContacts=(RecyclerView) mainView.findViewById(R.id.list_view);

        mLayoutManager = new LinearLayoutManager(getActivity());
        listContacts.setLayoutManager(mLayoutManager);


        return mainView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listContacts.setAdapter(mAdapter);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        params.setAnchorId(R.id.coordinator_container);
        params.anchorGravity= Gravity.BOTTOM|Gravity.RIGHT;
        fab.setLayoutParams(params);
        fab.setImageResource(R.drawable.ic_add_24dp);
        fab.show();
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       // AppBarLayout.LayoutParams params2 = ((MainActivity) getActivity()).params ;
    }



    /**
     * Генерируем данные пользователей
     */
    private void generateData(){
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Иван", "Иванов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Петр", "Петров"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Семен", "Семенов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Василий", "Козлов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Изя", "Васерман"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Руслан", "Урмеев"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Константин", "Пожидаев"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Инга", "Инжир"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Анна", "Пожидаева"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Иван", "Иванов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Петр", "Петров"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Семен", "Семенов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Василий", "Козлов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Изя", "Васерман"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Руслан", "Урмеев"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Константин", "Пожидаев"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Инга", "Инжир"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Анна", "Пожидаева"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Иван", "Иванов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Петр", "Петров"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Семен", "Семенов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Василий", "Козлов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Изя", "Васерман"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Руслан", "Урмеев"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Константин", "Пожидаев"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Инга", "Инжир"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Анна", "Пожидаева"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Иван", "Иванов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Петр", "Петров"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Семен", "Семенов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Василий", "Козлов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Изя", "Васерман"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Руслан", "Урмеев"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Константин", "Пожидаев"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Инга", "Инжир"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Анна", "Пожидаева"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Иван", "Иванов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Петр", "Петров"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Семен", "Семенов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Василий", "Козлов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Изя", "Васерман"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Руслан", "Урмеев"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Константин", "Пожидаев"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Инга", "Инжир"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Анна", "Пожидаева"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Иван", "Иванов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Петр", "Петров"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Семен", "Семенов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Василий", "Козлов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Изя", "Васерман"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Руслан", "Урмеев"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Константин", "Пожидаев"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Инга", "Инжир"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp),"Анна", "Пожидаева"));
    }
}
