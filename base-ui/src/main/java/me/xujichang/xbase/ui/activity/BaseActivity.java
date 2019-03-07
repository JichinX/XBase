package me.xujichang.xbase.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import me.xujichang.xbase.baseutils.shake.XOnClickListener;
import me.xujichang.xbase.baseutils.view.ViewHelper;

/**
 * Des:XBase - me.xujichang.xbase.ui.activity
 * 最基本的Activity 最后所有的方法都会沉淀到此Activity
 *
 * @author xujichang
 * @date 2019/1/25 09:29
 * <p>
 * modify:
 */
public class BaseActivity extends AppCompatActivity {
    private ViewGroup mCustomViewGroup;
    private boolean mHasCustomRoot = false;
    private ViewHelper mViewHelper;
    //=================拦截View的创建==============================

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCustomViewGroup = onCreateCustomRootView(savedInstanceState);
        mHasCustomRoot = mCustomViewGroup != null;
        mViewHelper = ViewHelper.getInstance(getLifecycleOwner());
        if (mHasCustomRoot) {
            super.setContentView(mCustomViewGroup);
            onSetContentView();
        }
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        if (mHasCustomRoot) {
            //            clearParent(view);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            mCustomViewGroup.addView(view);
            return;
        }
        if (null == params) {
            super.setContentView(view);
        } else {
            super.setContentView(view, params);
        }
        onSetContentView();
    }

    private void clearParent(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (null != viewGroup) {
            viewGroup.removeView(view);
        }
    }

    @Override
    public void setContentView(View view) {
        setContentView(view, null);
    }

    @Override
    public void setContentView(int layoutResID) {
        setContentView(View.inflate(getContext(), layoutResID, null));
    }


    protected ViewGroup onCreateCustomRootView(Bundle savedInstanceState) {
        return null;
    }

    /**
     * after setContentView
     */
    protected void onSetContentView() {

    }

    protected Context getContext() {
        return this;
    }

    protected AppCompatActivity getCompatActivity() {
        return this;
    }

    public LifecycleOwner getLifecycleOwner() {
        return this;
    }

    //防抖点击
    protected <V extends View> void proxyClick(V view, final XOnClickListener<V> listener,
                                               boolean enable) {
        if (null == listener) {
            return;
        }
        if (enable) {
            mViewHelper.proxyClick(view, listener);
        } else {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick((V) v);
                }
            });
        }
    }

    protected <V extends View> void proxyClick(V view, final XOnClickListener<V> listener) {
        proxyClick(view, listener, mViewHelper != null);
    }
    //拦截返回事件

    //键盘处理
    //状态栏处理
}
