package me.xujichang.xbase.base.activity;

import android.app.Activity;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Des:XBase - me.xujichang.XBase.base.activity
 *
 * @author xujichang
 * @date 2019/1/21 15:26
 * <p>
 * modify:
 */
public class BaseActivity extends AppCompatActivity {
    protected Context getContext() {
        return this;
    }

    protected Activity getActivity() {
        return this;
    }
}
