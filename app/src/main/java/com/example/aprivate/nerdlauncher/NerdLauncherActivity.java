package com.example.aprivate.nerdlauncher;

import android.support.v4.app.Fragment;

import com.example.aprivate.nerdlauncher.abstract_fragment.SingleFragmentActivity;

public class NerdLauncherActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return NerdLauncherFragment.newInstance();
    }

}
