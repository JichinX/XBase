package me.xujichang.xbase.baseutils.lifecycle;

import android.app.Activity;
import android.os.Bundle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Des:XBase - me.xujichang.xbase.baseutils.lifecycle
 *
 * @author xujichang
 * @date 2019/1/28 16:43
 * <p>
 * modify:
 */
public abstract class AbstractLifecycleObserver implements LifecycleObserver {
    /**
     * 对应Activity的生命周期{@link Activity#onStart()}
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public abstract void onStart();

    /**
     * 对应Activity的生命周期{@link Activity#onStart()}
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public abstract void onStop();

    /**
     * 对应Activity的生命周期{@link Activity#onResume()} ()}
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public abstract void onResume();

    /**
     * 对应Activity的生命周期{@link Activity#onPause()} ()}
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public abstract void onPause();

    /**
     * 对应Activity的生命周期{@link Activity#onCreate(Bundle)} ()}
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public abstract void onCreate();

    /**
     * 对应Activity的生命周期{@link Activity#onDestroy()} ()}
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public abstract void onDestroy();

    /**
     * 对应Activity的生命周期的每个变化都会响应
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public abstract void onChange();
}

