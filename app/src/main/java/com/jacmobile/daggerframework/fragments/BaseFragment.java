package com.jacmobile.daggerframework.fragments;

import android.app.Fragment;
import android.os.Bundle;

import com.jacmobile.daggerframework.activities.BaseActivity;

/**
 * Base fragment which performs injection using the activity-scoped object graph
 */
public abstract class BaseFragment extends Fragment
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Assume that it lives within a BaseActivity host
        ((BaseActivity)getActivity()).inject(this);
    }

    protected <T> T getView(int id) {
        return (T) getView().findViewById(id);
    }
}
