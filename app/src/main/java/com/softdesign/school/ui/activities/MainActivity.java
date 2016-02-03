package com.softdesign.school.ui.activities;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.softdesign.school.R;
import com.softdesign.school.ui.fragments.ContactsFragment;
import com.softdesign.school.ui.fragments.ProfileFragment;
import com.softdesign.school.utils.BitmapUtils;
import com.softdesign.school.utils.ConstantManager;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private Toast mToast;
    /*private Toolbar mToolbar;
    private DrawerLayout mNavigationDrawer;
    private NavigationView mNavigationView;
    public AppBarLayout mAppBar;
    public CollapsingToolbarLayout mCollapsingToolbar;*/
    private Fragment mFragment;
    private View mHeaderLayout;
    private String mFragmentTag = null;
    private FragmentManager mFragmentManager;

    public AppBarLayout.LayoutParams params = null;

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.navigation_drawer) DrawerLayout mNavigationDrawer;
    @Bind(R.id.navigation_view) NavigationView mNavigationView;
    @Bind(R.id.appbar_layout) AppBarLayout mAppBar;
    @Bind(R.id.collapsing_toolbar) CollapsingToolbarLayout mCollapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // инициализируем View компоненты
        /*mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigation_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mAppBar = (AppBarLayout) findViewById(R.id.appbar_layout);
        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);*/
        ButterKnife.bind(this);
        mHeaderLayout = mNavigationView.inflateHeaderView(R.layout.drawer_header);

        // инициализируем встроенные методы Activity
        mFragmentManager = getSupportFragmentManager();

        // инициализируем UI
        setupToolbar();
        setupDrawer();

        // проверка на первый запуск
        if (savedInstanceState != null) {
            //// TODO: Сохраненные значения из bundle обрабатывать здесь
        } else {
            mToast = Toast.makeText(this, "активити создано впервые", Toast.LENGTH_SHORT);
            mFragment = fragmentInstanceByTag(ConstantManager.FRAGMENT_TAG_PROFILE);
            mFragmentManager.beginTransaction().replace(R.id.main_frame_container, mFragment, mFragmentTag).commit();
            mToast.show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mNavigationDrawer.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Fragment findingFragment = (Fragment) getSupportFragmentManager().findFragmentById(R.id.main_frame_container);

        if (findingFragment != null && findingFragment instanceof ProfileFragment) {
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        super.onBackPressed();
    }

    /**
     * Инициализирует ToolBar
     */
    public void setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        params = (AppBarLayout.LayoutParams) mCollapsingToolbar.getLayoutParams();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Инициализирует NavigationDrawer
     */
    private void setupDrawer() {
        avatarToDrawer();
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.drawer_profile:
                        mFragmentTag = ConstantManager.FRAGMENT_TAG_PROFILE;
                        mNavigationView.getMenu().findItem(R.id.drawer_profile).setChecked(true);
                        break;

                    case R.id.drawer_contacts:
                        mFragmentTag = ConstantManager.FRAGMENT_TAG_CONTACTS;
                        mNavigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);
                        break;
                }

                mFragment = fragmentInstanceByTag(mFragmentTag);
                mFragmentManager.beginTransaction().replace(R.id.main_frame_container, mFragment, mFragmentTag)
                        .addToBackStack(mFragmentTag).commit();

                mNavigationDrawer.closeDrawers();
                return false;
            }
        });
    }

    /**
     * Сворачивает ToolBar
     *
     * @param collapse true - свернуть / false -  развернуть
     */
    public void collapseAppBar(boolean collapse) {
        if (collapse) {
            AppBarLayout.OnOffsetChangedListener mListener = new AppBarLayout.OnOffsetChangedListener() {
                @Override
                public void onOffsetChanged(AppBarLayout mAppBar, int verticalOffset) {
                    if (mCollapsingToolbar.getHeight() + verticalOffset <= ViewCompat.getMinimumHeight(mCollapsingToolbar) + getStatusBarHeight()) {
                        mAppBar.removeOnOffsetChangedListener(this);
                        LockToolBar();
                    }
                }
            };
            mAppBar.addOnOffsetChangedListener(mListener);
            mAppBar.setExpanded(false);
        } else {
            UnLockToolBar();
            mAppBar.setExpanded(true);
        }
    }

    /**
     * Снимает блокировку с ToolBar выставляя scrollFlag
     */
    private void LockToolBar() {
        params.setScrollFlags(0);
        mCollapsingToolbar.setLayoutParams(params);
    }

    /**
     * Блокирует ToolBar выставляя scrollFlag
     */
    private void UnLockToolBar() {
        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
        mCollapsingToolbar.setLayoutParams(params);
    }

    /**
     * Возвращает высоту статусбара
     */
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * Устанавливает аватар в NavigationDrawer header
     */
    private void avatarToDrawer() {
        ImageView avatar = (ImageView) mHeaderLayout.findViewById(R.id.imageView);
        Bitmap imageBitmap = ((BitmapDrawable) avatar.getDrawable()).getBitmap();
        avatar.setImageBitmap(BitmapUtils.getCircleMaskedBitmapUsingShader(imageBitmap, 54));
    }

    /**
     * Создаем фрагмент по его тегу
     *
     * @param mFragmentTag - тег фрагмента
     * @return фрагмент
     */
    private Fragment fragmentInstanceByTag(String mFragmentTag) {

        Fragment newFragment;
        switch (mFragmentTag) {
            case ConstantManager.FRAGMENT_TAG_PROFILE:
                newFragment = mFragmentManager.findFragmentByTag(mFragmentTag);
                if (newFragment == null) {
                    newFragment = new ProfileFragment();
                }
                break;
            case ConstantManager.FRAGMENT_TAG_CONTACTS:
                newFragment = mFragmentManager.findFragmentByTag(mFragmentTag);
                if (newFragment == null) {
                    newFragment = new ContactsFragment();
                }
                break;
            default:
                newFragment = mFragmentManager.findFragmentById(R.id.main_frame_container);
                break;
        }
        return newFragment;
    }
}