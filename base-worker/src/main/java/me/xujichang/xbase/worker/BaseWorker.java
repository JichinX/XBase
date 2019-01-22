package me.xujichang.xbase.worker;

import android.content.Context;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;
import com.evernote.android.job.JobManager;

import me.xujichang.xbase.worker.creator.DefaultJobCreator;

/**
 * Des:XBase - me.xujichang.xbase.worker
 *
 * @author xujichang
 * @date 2019/1/22 14:32
 * <p>
 * modify:
 */
public class BaseWorker {
    public static void init(Context context) {
        registerJobCreator(context, new DefaultJobCreator());
    }

    public static void registerJobCreator(Context context, JobCreator creator) {
        JobManager.create(context).addJobCreator(creator);
    }
}
