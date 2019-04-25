package me.xujichang.xbase;

import android.os.Bundle;

import me.xujichang.xbase.ui.activity.BaseActionBarActivity;

public class MainActivity extends BaseActionBarActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarBackground(R.color.colorPrimary);
        setTextColor(R.color.white);
        setCenterActionBarTitle("Test");
        showBackArrow(R.color.white);
        showRightText(R.string.test);
    }
}
