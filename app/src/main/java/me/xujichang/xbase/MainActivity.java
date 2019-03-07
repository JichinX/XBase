package me.xujichang.xbase;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import me.xujichang.xbase.ui.activity.BaseActionBarActivity;

public class MainActivity extends BaseActionBarActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActionBar();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(getCompatActivity(), R.id.nav_main_host).navigateUp();
    }

    private void initActionBar() {
        showBackArrow();
        setCenterActionBarTitle("首页");
    }
}
