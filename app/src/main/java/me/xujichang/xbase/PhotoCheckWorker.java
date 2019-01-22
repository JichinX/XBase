package me.xujichang.xbase;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * Des:XBase - me.xujichang.xbase
 *
 * @author xujichang
 * @date 2019/1/22 15:33
 * <p>
 * modify:
 */
public class PhotoCheckWorker extends Worker {
    private static final String TAG = "WorkerTest";

    public PhotoCheckWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        photoCheck();
        return Result.success();
    }


    private void photoCheck() {
        Log.i(TAG, "photoCheck: ");
    }
}
