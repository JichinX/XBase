package me.xujichang.xbase.worker.work;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * Des:XBase - me.xujichang.xbase.worker.work
 *
 * @author xujichang
 * @date 2019/1/22 14:52
 * <p>
 * modify:
 */
public class UploadWorker extends Worker {
    public static final String TAG = "UploadWorker";

    public UploadWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.i(TAG, "doWork: ");
        return Result.success();
    }
}
