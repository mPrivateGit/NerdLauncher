package com.example.aprivate.nerdlauncher.holders;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class ActivityHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener{
    private Activity mActivity;
    private ResolveInfo mResolveInfo;
    private TextView mTextView;

    public ActivityHolder(View itemView, Activity activity) {
        super(itemView);

        mTextView = (TextView) itemView;
        mTextView.setOnClickListener(this);
        mActivity = activity;
    }

    public void bindActivity(ResolveInfo resolveInfo) {
        mResolveInfo = resolveInfo;
        PackageManager pm = mActivity.getPackageManager();
        String appName = mResolveInfo.loadLabel(pm).toString();
        mTextView.setText(appName);
    }

    @Override
    public void onClick(View v) {
        ActivityInfo activityInfo = mResolveInfo.activityInfo;
        Intent i = new Intent(Intent.ACTION_MAIN)
                .setClassName(activityInfo.applicationInfo.packageName,
                        activityInfo.name)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mActivity.startActivity(i);
    }
}
