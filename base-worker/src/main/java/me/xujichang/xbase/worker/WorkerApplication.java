package me.xujichang.xbase.worker;

import android.app.Application;

import com.evernote.android.job.JobManager;

import me.xujichang.xbase.worker.creator.DefaultJobCreator;
import me.xujichang.xbase.worker.util.WorkerUtil;

/**
 * Des:XBase - me.xujichang.xbase.worker
 *
 * @author xujichang
 * @date 2019/1/22 16:52
 * <p>
 * modify:
 */
public class WorkerApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BaseWorker.registerJobCreator(this, new DefaultJobCreator());
    }
}
