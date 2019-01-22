package me.xujichang.xbase.worker.creator;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Des:XBase - me.xujichang.xbase.worker.creator
 *
 * @author xujichang
 * @date 2019/1/22 17:01
 * <p>
 * modify:
 */
public class DefaultJobCreator implements JobCreator {
    @Nullable
    @Override
    public Job create(@NonNull String tag) {
        return null;
    }
}
