package me.xujichang.xbase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private             OneTimeWorkRequest  mOneTimeRequest;
    private             PeriodicWorkRequest mPeriodicWorkRequest;
    public static final String              TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Constraints constraints =
                new Constraints.Builder()
                        .setRequiredNetworkType(NetworkType.CONNECTED)
                        .build();
        mOneTimeRequest =
                new OneTimeWorkRequest
                        .Builder(CompressWorker.class)
                        .setConstraints(constraints)
                        .addTag("OneTime")
                        .build();
        mPeriodicWorkRequest = new PeriodicWorkRequest
                .Builder(PhotoCheckWorker.class, 900_000L, TimeUnit.MILLISECONDS)
                .addTag("Period")
                .build();
        WorkManager.getInstance().enqueue(mOneTimeRequest);
        WorkManager.getInstance().enqueue(mPeriodicWorkRequest);
    }
}
