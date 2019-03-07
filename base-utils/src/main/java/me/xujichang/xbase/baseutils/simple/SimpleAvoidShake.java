package me.xujichang.xbase.baseutils.simple;

import android.view.View;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import me.xujichang.xbase.baseutils.shake.AvoidShake;
import me.xujichang.xbase.baseutils.shake.XOnClickListener;

/**
 * Des:XBase - me.xujichang.xbase.ui.simple
 *
 * @author xujichang
 * @date 2019/2/14 11:32
 * <p>
 * modify:
 */
public class SimpleAvoidShake implements AvoidShake {

    public <T extends View> void proxyClick(final T view, final XOnClickListener<T> listener, long seconds) {
        proxyClickListener(seconds, view, listener);
    }

    public <T extends View> void proxyClick(final T view,
                                            final XOnClickListener<T> listener) {
        proxyClick(view, listener, 500);
    }

    /**
     * 通过将View的点击事件进行转接 配合Rxjava实现View的防抖操作
     */
    @Override
    public <T extends View> void proxyClickListener(long seconds, T view, final XOnClickListener<T> listener) {
        XObservableOnSubscribe<T> subscribe = new XObservableOnSubscribe<T>(view) {
            @Override
            protected void subscribe(final ObservableEmitter<T> e, final T view) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        e.onNext(view);
                    }
                });
            }
        };
        Observer<T> observer = new Observer<T>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(@NonNull T t) {
                listener.onClick(t);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        Observable
                .create(subscribe)
                .throttleFirst(seconds, TimeUnit.MILLISECONDS)
                .subscribe(observer);
    }

    abstract static class XObservableOnSubscribe<T extends View> implements ObservableOnSubscribe<T> {

        private T view;

        XObservableOnSubscribe(T view) {
            this.view = view;
        }

        @Override
        public void subscribe(@NonNull ObservableEmitter<T> e) throws Exception {
            subscribe(e, view);
        }

        /**
         * 订阅事件
         *
         * @param e
         * @param view
         */
        protected abstract void subscribe(ObservableEmitter<T> e, T view);

    }
}
