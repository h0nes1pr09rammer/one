package com.lzq.one.activity;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.lzq.one.R;
import com.lzq.one.fragment.HomePageFragment;
import com.lzq.one.fragment.MovieFragment;
import com.lzq.one.fragment.MusicFragment;
import com.lzq.one.fragment.ReadFragment;

/**
 * Created by CTWLPC on 2017/10/20.
 */
public class MainActivity extends AppCompatActivity {

    private static final int JOKE_PAGE_TWO = 2;
    private static final int JOKE_PAGE_THREE = 3;
    private static final int JOKE_PAGE_FORE = 4;
    private static final int JOKE_PAGE_ONE = 1;

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    private ImageView mImageView;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private int pagerNumber;
    private FragmentManager mFragmentManager;

    private HomePageFragment mHomePageFragment;
    private MovieFragment mMovieFragment;
    private MusicFragment mMusicFragment;
    private ReadFragment mReadFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        initToolbar();
        initNavigationView();
        initActionBarDrawerToggle();
        initFragment();
    }

    private void initFragment() {
        if (mHomePageFragment == null) {
            mHomePageFragment = new HomePageFragment();
        }
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().add(R.id.fragment_content, mHomePageFragment).show(mHomePageFragment).commit();
    }

    private void setThemeColor(int color) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(color);
            mToolbar.setBackgroundColor(color);
        }else{
            Toast.makeText(this,"SDK版本过低",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.joke_toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_joke_drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.id_joke_nv_menu);
        mImageView = (ImageView) mNavigationView.getHeaderView(0).findViewById(R.id.head_img);
//        mImageView.setImageBitmap(BitmapFactory.);
//        if (AVUser.getCurrentUser().getAVFile("head").getUrl()!=null){
//            VolleyUtils.getInstance().displayImageView(AVUser.getCurrentUser().getAVFile("head").getUrl(),mImageView);
//        }
        mImageView.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, PersonInfoActivity.class), ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, mImageView, "mybtn").toBundle());
                mDrawerLayout.closeDrawers();
            }
        });
    }

    /**
     * 初始化ActionBarDrawerToggle
     */
    private void initActionBarDrawerToggle() {
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
    }

    /**
     * 初始化NavigationView
     */
    private void initNavigationView() {
        mNavigationView.inflateMenu(R.menu.navigation_menu_login);
        mNavigationView.setItemIconTintList(null);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.item_movie){
                    showMoviePage(item);
                }
                if (item.getItemId() == R.id.item_music){
                    showMusicPage(item);
                }
                if (item.getItemId() == R.id.item_shouye){
                    showHomePage(item);
                }
                if (item.getItemId() == R.id.item_read){
                    showReadPage(item);
                }
                if (item.getTitle().toString().equals("切换主题")) {
                    showChagePage();
                }
                if (item.getTitle().toString().equals("设置")) {
                    showSetupPage();
                }
                return false;
            }
        });
    }

    /**
     * 设置Toolbar样式
     *
     * @param item
     */
    private void setToolbar(MenuItem item, int pageNumber) {
        item.setChecked(true);
        mToolbar.setTitle(item.getTitle());
        this.pagerNumber = pageNumber;
        invalidateOptionsMenu();
        mDrawerLayout.closeDrawers();
    }

    /**
     * 设置
     */
    private void showSetupPage() {
//        startActivity(new Intent(MainActivity.this, SetupPageActivity.class));
    }

    /**
     * 切换主题
     */
    private void showChagePage() {
        setThemeColor(Color.DKGRAY);
    }

    /**
     * 显示音乐页面
     *
     * @param item
     */
    private void showMusicPage(MenuItem item) {
        setToolbar(item, JOKE_PAGE_ONE);
        if (mMusicFragment == null) {
            mMusicFragment = new MusicFragment();
        }
        showFragment(mMusicFragment);
    }
    /**
     * 显示影视页面
     *
     * @param item
     */
    private void showMoviePage(MenuItem item) {
        setToolbar(item, JOKE_PAGE_FORE);
        if (mMovieFragment == null) {
            mMovieFragment = new MovieFragment();
        }
        showFragment(mMovieFragment);
    }

    /**
     * 显示阅读页面
     *
     * @param item
     */
    private void showReadPage(MenuItem item) {
        setToolbar(item, JOKE_PAGE_THREE);
        if (mReadFragment == null) {
            mReadFragment = new ReadFragment();
        }
        showFragment(mReadFragment);
    }

    /**
     * 显示首页页面
     *
     * @param item
     */
    private void showHomePage(MenuItem item) {
        setToolbar(item, JOKE_PAGE_TWO);
        if (mHomePageFragment == null) {
            mHomePageFragment = new HomePageFragment();
        }
        showFragment(mHomePageFragment);
    }


    /**
     * 显示选中Fragment
     *
     * @param fragment
     */
    public void showFragment(Fragment fragment) {
        FragmentTransaction mShowFragmentTransaction = mFragmentManager.beginTransaction();
        if (!mFragmentManager.getFragments().contains(fragment)) {
            mShowFragmentTransaction.add(R.id.fragment_content, fragment);
        }
        for (Fragment currentFragment : mFragmentManager.getFragments()) {
            mShowFragmentTransaction.hide(currentFragment);
        }
        mShowFragmentTransaction.show(fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.find) {

        }
        if (item.getItemId() == R.id.message) {

        }
        if (item.getItemId() == R.id.about) {

        }
        if (item.getItemId() == R.id.logout) {

        }
        if (item.getItemId() == R.id.shuffle) {

        }
        if (item.getItemId() == R.id.share) {

        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        switch (pagerNumber) {
            case JOKE_PAGE_ONE:
                menu.findItem(R.id.share).setVisible(false);
                menu.findItem(R.id.shuffle).setVisible(true);
                break;
            case JOKE_PAGE_TWO:
                menu.findItem(R.id.share).setVisible(false);
                menu.findItem(R.id.shuffle).setVisible(false);
                break;
            case JOKE_PAGE_THREE:
                menu.findItem(R.id.share).setVisible(false);
                menu.findItem(R.id.shuffle).setVisible(false);
                break;
            case JOKE_PAGE_FORE:
                menu.findItem(R.id.share).setVisible(false);
                menu.findItem(R.id.shuffle).setVisible(false);
                break;
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
