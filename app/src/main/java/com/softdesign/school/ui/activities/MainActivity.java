package com.softdesign.school.ui.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
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
import android.widget.Toast;

import com.softdesign.school.R;
import com.softdesign.school.ui.fragments.CollapsingToolbarFragment;
import com.softdesign.school.ui.fragments.ContactsFragment;
import com.softdesign.school.ui.fragments.ProfileFragment;
import com.softdesign.school.ui.fragments.SimpleToolbarFragment;
import com.softdesign.school.utils.Lg;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private Toast mToast;
    private DrawerLayout mNavigationDrawer;
    private NavigationView mNavigationView;
    private Fragment mFragment;
    private Fragment mToolbarFragment;
    private CoordinatorLayout mCoordinatorContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lg.e(this.getClass().getSimpleName(), "onCreate");

        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigation_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mCoordinatorContainer = (CoordinatorLayout) findViewById(R.id.coordinator_container);

        //setupToolbar();
        setupDrawer();
        //setTitle(this.getClass().getSimpleName());

        if (savedInstanceState != null) {

        } else {
            mToast = Toast.makeText(this, "активити создано впервые", Toast.LENGTH_SHORT);
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, new ProfileFragment()).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.toolbar_layout, new CollapsingToolbarFragment()).commit();

        }
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
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
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        /*switch (id) {
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

        }*/

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mNavigationDrawer.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }


    public void setupToolbar() {
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
                        mToolbarFragment = new CollapsingToolbarFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_profile).setChecked(true);
                        //mCoordinatorContainer.setFitsSystemWindows(true);

                        break;
                    case R.id.drawer_contacts:
                        mFragment = new ContactsFragment();
                        mToolbarFragment = new SimpleToolbarFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);
                        //mCoordinatorContainer.setFitsSystemWindows(false);
                        break;
                }

                if (mFragment!=null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, mFragment).addToBackStack(null).commit();
                    getSupportFragmentManager().beginTransaction().replace(R.id.toolbar_layout, mToolbarFragment).commit();
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