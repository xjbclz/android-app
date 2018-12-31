package com.example.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

public class JobSchedulerService extends JobService {

    private static String TAG = "JobScheduler";

    public static final int MY_JOB_MESSAGE = 1;

    private Handler mJobHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage( Message msg ) {
            Toast.makeText( getApplicationContext(), "JobService task running", Toast.LENGTH_LONG).show();

            Log.v(TAG, "JobService task running");

            jobFinished( (JobParameters) msg.obj, false);
            return true;
        }
    } );

    @Override
    public boolean onStartJob(JobParameters params ) {
//        mJobHandler.sendMessage( Message.obtain( mJobHandler, MY_JOB_MESSAGE, params ) );
//
        Log.v(TAG, "JobService task start");
//
//        return false;
        StringBuilder sb = new StringBuilder();
        sb.append("Media content has changed:\n");
        if (params.getTriggeredContentAuthorities() != null) {
            sb.append("Authorities: ");
            boolean first = true;
            for (String auth :
                    params.getTriggeredContentAuthorities()) {
                if (first) {
                    first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(auth);
            }
            if (params.getTriggeredContentUris() != null) {
                for (Uri uri : params.getTriggeredContentUris()) {
                    sb.append("\n");
                    sb.append(uri);
                }
            }
        } else {
            sb.append("(No content)");
        }
        Log.v(TAG, sb.toString());
        return true;
    }

    @Override
    public boolean onStopJob( JobParameters params ) {

        Toast.makeText( getApplicationContext(), "JobService task stop", Toast.LENGTH_SHORT ).show();

        Log.v(TAG, "JobService task stop");

        mJobHandler.removeMessages(MY_JOB_MESSAGE);
        return false;
    }

}
