package com.example.aprivate.nerdlauncher.adapters;

import android.app.Activity;
import android.content.pm.ResolveInfo;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aprivate.nerdlauncher.holders.ActivityHolder;

import java.util.List;


public class ActivityAdapter extends RecyclerView.Adapter<ActivityHolder> {
    private Activity mActivity;
    private final List<ResolveInfo> mActivities;

    public ActivityAdapter(Activity activity, List<ResolveInfo> mActivities){
        mActivity = activity;
        this.mActivities = mActivities;

    }

    @Override
    public ActivityHolder onCreateViewHolder
            (ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mActivity);
        View view = layoutInflater
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ActivityHolder(view, mActivity);
    }

    @Override
    public void onBindViewHolder(ActivityHolder activityHolder, int position) {
        ResolveInfo resolveInfo = mActivities.get(position);
        activityHolder.bindActivity(resolveInfo);
    }

    @Override
    public int getItemCount() {
        return mActivities.size();
    }
}
