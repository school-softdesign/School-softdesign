package com.softdesign.school.ui.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.softdesign.school.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox mCheckBox;
    private EditText mEditText;
    private static final String VISABLE_KEY = "VISABLE";
    private static final String COUNT_KEY = "COUNT";
    private int mCount;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("SCHOOL", "onCreate");
        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mEditText = (EditText) findViewById(R.id.text_field_2);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mCheckBox.setOnClickListener(this);
        setupToolbar();
        Toast mToast;

        if (savedInstanceState != null) {
            int visibleState = savedInstanceState.getBoolean(VISABLE_KEY ) ? View.VISIBLE : View.INVISIBLE;
            mCount = savedInstanceState.getInt(COUNT_KEY);
            mCount++;
            mEditText.setVisibility(visibleState);
            mToast = Toast.makeText(this, "активити создано " + mCount + " раз", Toast.LENGTH_SHORT);
        } else{
            mToast = Toast.makeText(this, "активити создано впервые", Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("SCHOOL", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("SCHOOL", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("SCHOOL", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("SCHOOL", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("SCHOOL", "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("SCHOOL", "onRestart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("SCHOOL", "onRestoreInstanceState()");
        Log.e("SCHOOL", String.valueOf(savedInstanceState.getBoolean(VISABLE_KEY)));
        int visibleState = savedInstanceState.getBoolean(VISABLE_KEY ) ? View.VISIBLE : View.INVISIBLE;

        mEditText.setVisibility(visibleState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("SCHOOL", "onSaveInstanceState()");
        outState.putBoolean(VISABLE_KEY, mEditText.getVisibility() == View.VISIBLE);
        outState.putInt(COUNT_KEY, mCount);
        Log.e("SCHOOL", String.valueOf(mEditText.getVisibility() == View.VISIBLE));
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (view.getId() == R.id.checkBox) {
            if (mCheckBox.isChecked()) {
                mEditText.setVisibility(View.INVISIBLE);
            } else {
                mEditText.setVisibility(View.VISIBLE);
            }
        }
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }
}
