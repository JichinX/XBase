package me.xujichang.xbase.ui.simple;

import android.os.Bundle;

import androidx.annotation.Nullable;
import me.xujichang.xbase.ui.R;
import me.xujichang.xbase.ui.activity.login.BaseLoginActivity;

/**
 * Des:XBase - me.xujichang.xbase.ui.simple
 *
 * @author xujichang
 * @date 2019/1/28 17:04
 * <p>
 * modify:
 */
public class SimpleLoginActivity extends BaseLoginActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_activity_simple_login);
    }
}
