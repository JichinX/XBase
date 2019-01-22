package me.xujichang.xbase;

import android.content.Context;
import android.util.Log;

import java.io.ObjectInputStream;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * Des:XBase - me.xujichang.xbase
 *
 * @author xujichang
 * @date 2019/1/22 15:27
 * <p>
 * modify:
 */
public class CompressWorker extends Worker {
    private static final String TAG = "WorkerTest";

    public CompressWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        doCompress();
        return Result.success();
    }

    private void doCompress() {
        Log.i(TAG, "doCompress: 。。。 。。。");
    }
}
