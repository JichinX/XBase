package me.xujichang.xbase.baseutils.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import io.reactivex.disposables.CompositeDisposable;
import me.xujichang.xbase.baseutils.lifecycle.SimpleLifecycleObserver;
import me.xujichang.xbase.baseutils.simple.SimpleAvoidShake;

/**
 * Des:XBase - me.xujichang.xbase.baseutils.view
 *
 * @author xujichang
 * @date 2019/1/25 16:06
 * <p>
 * modify:
 */
public class ViewHelper extends SimpleAvoidShake {
    private static ViewHelper          instance;
    private        Lifecycle           mLifecycle;
    private        CompositeDisposable mDisposable;

    private ViewHelper() {

    }

    protected ViewHelper(String pS) {

    }

    private static class ClassHolder {

        public static ViewHelper mViewTool = new ViewHelper();
    }

    public static ViewHelper getInstance(Lifecycle lifecycle) {
        if (null == instance) {
            instance = ClassHolder.mViewTool;
        }
        instance.init(lifecycle);
        return instance;
    }

    public static ViewHelper getInstance(LifecycleOwner lifecycleOwner) {
        return getInstance(lifecycleOwner.getLifecycle());
    }

    private void init(Lifecycle lifecycle) {
        clear();
        mDisposable = new CompositeDisposable();
        mLifecycle = lifecycle;
        mLifecycle.addObserver(new SimpleLifecycleObserver() {
            @Override
            public void onDestroy() {
                mDisposable.dispose();
            }
        });
    }

    private void clear() {
        mLifecycle = null;
        mDisposable = null;
    }
}
