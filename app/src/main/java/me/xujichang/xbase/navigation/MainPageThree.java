package me.xujichang.xbase.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import me.xujichang.xbase.R;

/**
 * Des:XBase - me.xujichang.xbase.navigation
 *
 * @author xujichang
 * @date 2019/1/25 14:53
 * <p>
 * modify:
 */
public class MainPageThree extends Fragment {
    private Button mBtnBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.demo_layout_fragment_main_page_three, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView(view);
    }

    private void initView(View pview) {
        mBtnBack = pview.findViewById(R.id.btn_back);
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(pview).navigate(R.id.action_nav_three_back);
            }
        });
    }
}
