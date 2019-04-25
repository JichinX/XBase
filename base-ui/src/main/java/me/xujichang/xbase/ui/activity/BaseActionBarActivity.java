package me.xujichang.xbase.ui.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.ViewPager;

import me.xujichang.xbase.baseutils.shake.XOnClickListener;
import me.xujichang.xbase.ui.R;

/**
 * Des:XBase - me.xujichang.xbase.ui.activity
 * 带有Actionbar的Activity
 *
 * @author xujichang
 * @date 2019/1/25 09:29
 * <p>
 * modify:
 */
public class BaseActionBarActivity extends BaseActivity {
    private static final int DEFAULT_TITLE_SIZE = 18;
    private static final int DEFAULT_TEXT_COLOR = Color.DKGRAY;
    /**
     * ActionBar Title
     */
    private FrameLayout mCenterActionBarTitleContainer;
    /**
     * 左侧布局 父布局
     */
    private LinearLayout mCenterActionBarLeftContainer;
    /**
     * 右侧布局 父布局
     */
    private LinearLayout mCenterActionBarRightContainer;
    /**
     * 左侧文字
     */
    private TextView mLeftText;
    /**
     * 右测文字
     */
    private TextView mRightText;
    /**
     * 左侧图标
     */
    private ImageView mLeftImg;
    /**
     * 右侧图标
     */
    private ImageView mRightImg;

    private Group mGroupActionbar;
    private boolean mCustombackPressed = false;
    private ConstraintLayout mClActionbarContainer;
    private TextView mActionbarTitle;
    private TabLayout mActionbarTitles;
    /**
     * 状态栏文字颜色
     */
    private int textColor = DEFAULT_TEXT_COLOR;
    /**
     * title 文字大小
     */
    private int titleSize = 18;
    /**
     * 状态栏背景色
     */
    private int bgColor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActionBarView();
    }

    @Override
    protected ViewGroup onCreateCustomRootView(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = View.inflate(getContext(), R.layout.ui_activity_layout_base_actionbar, null);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return (ViewGroup) view;
    }

    @Override
    protected void onSetContentView() {
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.hide();
        }
    }

    private void initActionBarView() {
        mCenterActionBarTitleContainer = findViewById(R.id.center_action_bar_title_container);
        mCenterActionBarLeftContainer = findViewById(R.id.center_action_bar_left_container);
        mCenterActionBarRightContainer = findViewById(R.id.center_action_bar_right_container);
        mClActionbarContainer = findViewById(R.id.cl_actionbar_container);
        mGroupActionbar = findViewById(R.id.group_actionbar);
    }

    //常用方法

    /**
     * 设置Title
     *
     * @param res
     *         res
     */
    protected void setCenterActionBarTitle(@StringRes int res) {
        setCenterActionBarTitle(getResources().getString(res));
    }

    /**
     * 设置Title
     *
     * @param text
     *         title
     */
    protected void setCenterActionBarTitle(String text) {
        setActionBarTitle(text, titleSize, textColor);
    }

    /**
     * 设置Title
     *
     * @param text
     *         title
     * @param resId
     *         状态栏文字颜色
     */
    protected void setCenterActionBarTitle(String text, @ColorRes int resId) {
        setActionBarTitle(text, titleSize, getResources().getColor(resId));
    }

    protected void setCenterActionBarTitle(String text, int size, @ColorRes int resId) {
        setActionBarTitle(text, size, getResources().getColor(resId));
    }

    /**
     * 设置Title
     *
     * @param text
     *         title
     * @param size
     *         文字大小
     * @param color
     *         状态栏文字颜色
     */
    protected void setActionBarTitle(String text, int size, int color) {
        mCenterActionBarTitleContainer.removeAllViews();
        mActionbarTitle = createTextView(text, size, color);
        mCenterActionBarTitleContainer.addView(mActionbarTitle);
    }

    /**
     * 显示返回 按钮
     */
    protected void showBackArrow() {
        showBackArrow(R.color.white);
    }

    protected void showBackArrow(@ColorRes int resId) {
        enableCustomBackPressed();
        Drawable drawable = getResources().getDrawable(R.drawable.ic_navigate_before_black_24dp);
        int color = getResources().getColor(resId);
        DrawableCompat.setTint(drawable, color);
        addLeftImg(drawable);
    }

    protected void enableCustomBackPressed() {
        mCenterActionBarLeftContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mCustombackPressed = true;
    }

    protected void disableCustomBackPressed() {
        mCustombackPressed = false;
        mCenterActionBarLeftContainer.setOnClickListener(null);
    }

    /**
     * 隐藏ActionBar
     */
    protected void hideActionBar() {
        hideActionBar(true);
    }

    /**
     * 隐藏ActionBar
     */
    protected void hideActionBar(boolean hide) {
        mGroupActionbar.setVisibility(hide ? View.GONE : View.VISIBLE);
    }

    protected void showLeftText(@StringRes int resId) {
        if (null == mLeftText) {
            mLeftText = addLeftText(getResources().getString(resId));
        }
        mLeftText.setVisibility(View.VISIBLE);
        mLeftText.setText(getResources().getText(resId));
    }

    protected void showLeftImg(@DrawableRes int resId) {
        if (null == mLeftImg) {
            mLeftImg = addLeftImg(getResources().getDrawable(resId));
        }
        mLeftImg.setVisibility(View.VISIBLE);
        mLeftImg.setImageResource(resId);
    }

    protected void showRightText(@StringRes int resId) {
        if (null == mRightText) {
            mRightText = addLeftText(getResources().getString(resId));
        }
        mRightText.setVisibility(View.VISIBLE);
        mRightText.setText(getResources().getText(resId));
    }

    protected void showRightImg(@DrawableRes int resId) {
        if (null == mRightImg) {
            mRightImg = addLeftImg(getResources().getDrawable(resId));
        }
        mRightImg.setVisibility(View.VISIBLE);
        mRightImg.setImageResource(resId);
    }

    protected void showRightImage() {
        if (null == mRightImg) {
            return;
        }
        mRightImg.setVisibility(View.VISIBLE);
    }

    protected void showRightText() {
        if (null == mRightText) {
            return;
        }
        mRightText.setVisibility(View.VISIBLE);
    }

    protected void showLeftImage() {
        if (null == mLeftImg) {
            return;
        }
        mLeftImg.setVisibility(View.VISIBLE);
    }

    protected void showLeftText() {
        if (null == mLeftText) {
            return;
        }
        mLeftText.setVisibility(View.VISIBLE);
    }

    protected void hideRightImage() {
        if (null == mRightImg) {
            return;
        }
        mRightImg.setVisibility(View.GONE);
    }

    protected void hideRightText() {
        if (null == mRightText) {
            return;
        }
        mRightText.setVisibility(View.GONE);
    }

    protected void hideLeftImage() {
        if (null == mLeftImg) {
            return;
        }
        mLeftImg.setVisibility(View.GONE);
    }

    protected void hideLeftText() {
        if (null == mLeftText) {
            return;
        }
        mLeftText.setVisibility(View.GONE);
    }

    protected TextView addLeftText(String text) {
        TextView mTextView = createTextView(text);
        addLeftView(mTextView);
        return mTextView;
    }

    protected TextView addRightText(String text) {
        TextView mTextView = createTextView(text);
        addRightView(mTextView);
        return mTextView;
    }

    protected ImageView addLeftImg(Drawable drawable) {
        ImageView mView = createImageView(drawable);
        addLeftView(mView);
        return mView;
    }

    protected ImageView addRightImg(Drawable drawable) {
        ImageView mView = createImageView(drawable);
        addRightView(mView);
        return mView;
    }

    protected void addLeftView(View view) {
        mCenterActionBarLeftContainer.addView(view);
    }

    protected void addRightView(View view) {
        mCenterActionBarRightContainer.addView(view);
    }


    protected void clearAndAddLeftView(View view) {
        clearContainer(mCenterActionBarLeftContainer);
        addLeftView(view);
    }

    protected void clearAndAddRightView(View view) {
        clearContainer(mCenterActionBarRightContainer);
        addRightView(view);
    }

    protected void deleteLeftView(View view) {
        deleteViewForContainer(mCenterActionBarLeftContainer, view);
    }

    protected void deleteRightView(View view) {
        deleteViewForContainer(mCenterActionBarRightContainer, view);
    }

    protected void setRightAreaClick(XOnClickListener<View> onClickListener) {
        proxyClick(mCenterActionBarRightContainer, onClickListener);
    }

    protected void setLeftAreaClick(XOnClickListener<View> onClickListener) {
        proxyClick(mCenterActionBarLeftContainer, onClickListener);
    }

    /**
     * 清除右侧指定View,view为空，表示清除所有
     */
    protected void clearRightView() {
        clearContainer(mCenterActionBarRightContainer);
    }

    /**
     * 清除左侧指定View，view为null,表示清除所有
     */
    protected void clearLeftView() {
        clearContainer(mCenterActionBarLeftContainer);
    }


    private void clearContainer(ViewGroup container) {
        container.removeAllViews();
    }

    private void deleteViewForContainer(ViewGroup container, View view) {
        container.removeView(view);
    }

    /**
     * android:gravity="center"
     * android:maxLines="1"
     * android:textColor="@color/white"
     * android:textSize="18sp"
     * 创建TextView
     *
     * @param text
     *
     * @return
     */
    protected TextView createTextView(String text, float size) {
        TextView textView = new TextView(getContext());
        textView.setText(text);
        if (size > 0) {
            textView.setTextSize(size);
        }
        textView.setGravity(Gravity.CENTER);
        textView.setMaxLines(1);
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        TextViewCompat.setAutoSizeTextTypeWithDefaults(textView,
                TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
        textView.setTextColor(textColor);
        return textView;
    }

    protected TextView createTextView(String text) {
        return createTextView(text, -1);
    }

    /**
     * android:gravity="center"
     * android:maxLines="1"
     * android:textColor="@color/white"
     * android:textSize="18sp"
     * 创建TextView
     *
     * @param text
     *
     * @return
     */
    protected TextView createTextView(String text, float size, int color) {
        TextView textView = new TextView(getContext());
        textView.setText(text);
        if (size > 0) {
            textView.setTextSize(size);
        }
        textView.setGravity(Gravity.CENTER);
        textView.setMaxLines(1);
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        TextViewCompat.setAutoSizeTextTypeWithDefaults(textView,
                TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
        textView.setTextColor(color);
        return textView;
    }

    /**
     * 创建ImageView
     *
     * @param drawable
     *
     * @return
     */
    protected ImageView createImageView(Drawable drawable) {
        ImageView imageView = new ImageView(getContext());
        imageView.setAdjustViewBounds(true);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setImageDrawable(drawable);
        return imageView;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    //颜色  主题

    /**
     * 设置背景
     */
    protected void setActionBarBackground(@ColorRes int resId) {
        int color = getResources().getColor(resId);
        bgColor = color;
        mClActionbarContainer.setBackgroundColor(bgColor);
    }

    protected void setTextColor(@ColorRes int resId) {
        int color = getResources().getColor(resId);
        textColor = color;
    }

    protected void setCenterActionBarTitles(ArrayList<String> titles, TabLayout.OnTabSelectedListener listener) {
        if (null == titles || titles.size() == 0) {
            return;
        }
        if (titles.size() == 1) {
            setCenterActionBarTitle(titles.get(0));
        } else {
            mCenterActionBarTitleContainer.removeAllViews();
            mActionbarTitles = createTitleTables(titles, listener);
            mCenterActionBarTitleContainer.addView(mActionbarTitles);
        }
    }

    protected void setCenterActionBarTitles(ArrayList<String> titles, ViewPager pager) {
        if (null == titles || titles.size() == 0) {
            return;
        }
        if (titles.size() == 1) {
            setCenterActionBarTitle(titles.get(0));
        } else {
            mCenterActionBarTitleContainer.removeAllViews();
            mActionbarTitles = createTitleTables(titles, pager);
            mCenterActionBarTitleContainer.addView(mActionbarTitles);
        }
    }

    private TabLayout createTitleTables(ArrayList<String> titles, ViewPager pager) {
        return createTitleTables(titles, pager, null);
    }

    private TabLayout createTitleTables(ArrayList<String> titles, TabLayout.OnTabSelectedListener listener) {
        return createTitleTables(titles, null, listener);
    }

    private TabLayout createTitleTables(ArrayList<String> titles, ViewPager pager, TabLayout.OnTabSelectedListener selectedListener) {
        TabLayout tabLayout = new TabLayout(getContext());
        //        for (String title : titles) {
        //            tabLayout.addTab(createTab(title));
        //        }
        if (null != pager) {
            tabLayout.setupWithViewPager(pager);
        }
        if (null != selectedListener) {
            tabLayout.addOnTabSelectedListener(selectedListener);
        }
        return tabLayout;
    }

    private TabLayout.Tab createTab(String title) {
        TabLayout.Tab tab = new TabLayout.Tab();
        tab.setCustomView(R.layout.ui_layout_tab);
        tab.setText(title);
        return tab;
    }
}
