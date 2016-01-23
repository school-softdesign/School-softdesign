package com.softdesign.school.ui.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.softdesign.school.R;
import com.softdesign.school.ui.fragments.ContactsFragment;
import com.softdesign.school.ui.fragments.ProfileFragment;
import com.softdesign.school.utils.Lg;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox mCheckBox;
    private EditText mEditText;
    private static final String VISABLE_KEY = "VISABLE";
    private static final String COUNT_KEY = "COUNT";
    private int mCount;
    private Toolbar mToolbar;
    private Toast mToast;
    private DrawerLayout mNavigationDrawer;
    private NavigationView mNavigationView;
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lg.e(this.getClass().getSimpleName(), "onCreate");
        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mEditText = (EditText) findViewById(R.id.text_field_2);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigation_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);

        setupToolbar();
        setupDrawer();
        setTitle(this.getClass().getSimpleName());

        if (savedInstanceState != null) {
            int visibleState = savedInstanceState.getBoolean(VISABLE_KEY) ? View.VISIBLE : View.INVISIBLE;
            mCount = savedInstanceState.getInt(COUNT_KEY);
            mCount++;
            mEditText.setVisibility(visibleState);
            mToast = Toast.makeText(this, "активити создано " + mCount + " раз", Toast.LENGTH_SHORT);
        } else {
            mToast = Toast.makeText(this, "активити создано впервые", Toast.LENGTH_SHORT);
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, new ProfileFragment()).commit();
        }
        mToast.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Lg.e(this.getClass().getSimpleName(), "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Lg.e("TAG", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Lg.e(this.getClass().getSimpleName(), "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Lg.e(this.getClass().getSimpleName(), "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Lg.e(this.getClass().getSimpleName(), "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Lg.e(this.getClass().getSimpleName(), "onRestart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getClass().getSimpleName(), "onRestoreInstanceState()");
        Lg.e(this.getClass().getSimpleName(), String.valueOf(savedInstanceState.getBoolean(VISABLE_KEY)));
        int visibleState = savedInstanceState.getBoolean(VISABLE_KEY) ? View.VISIBLE : View.INVISIBLE;

        mEditText.setVisibility(visibleState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Lg.e(this.getClass().getSimpleName(), "onSaveInstanceState()");
        outState.putBoolean(VISABLE_KEY, mEditText.getVisibility() == View.VISIBLE);
        outState.putInt(COUNT_KEY, mCount);
        Lg.e(this.getClass().getSimpleName(), String.valueOf(mEditText.getVisibility() == View.VISIBLE));
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.checkBox:
                if (mCheckBox.isChecked()) {
                    mEditText.setVisibility(View.INVISIBLE);
                } else {
                    mEditText.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.button_green:
                mToolbar.setBackgroundColor(getResources().getColor(R.color.green));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.green_dark));
                }
                break;

            case R.id.button_blue:
                mToolbar.setBackgroundColor(getResources().getColor(R.color.primary));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.primary_dark));
                }
                break;

            case R.id.button_red:
                mToolbar.setBackgroundColor(getResources().getColor(R.color.red));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.red_dark));
                }
                break;

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mNavigationDrawer.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }


    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupDrawer() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_profile:
                        mFragment = new ProfileFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_profile).setChecked(true);
                        break;
                    case R.id.drawer_contacts:
                        mFragment = new ContactsFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);
                        break;
                }

                if (mFragment!=null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, mFragment).addToBackStack(null).commit();
                }

                mNavigationDrawer.closeDrawers();
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        Fragment findingFragment = (Fragment) getSupportFragmentManager().findFragmentById(R.id.main_frame_container);
        if (findingFragment != null && findingFragment instanceof ProfileFragment) {
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        super.onBackPressed();
    }
}