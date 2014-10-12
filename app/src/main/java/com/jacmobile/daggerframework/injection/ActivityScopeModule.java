package com.jacmobile.daggerframework.injection;

import android.app.Activity;
import android.content.Context;

import com.jacmobile.daggerframework.activities.BaseActivity;
import com.jacmobile.daggerframework.activities.MainActivity;
import com.jacmobile.daggerframework.fragments.MainFragment;
import com.jacmobile.daggerframework.injection.ApplicationScopeModule;
import com.jacmobile.daggerframework.injection.annotations.ForActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Here it provides the dependencies those have same lifetime of one activity in your MyCoolApp
 */
@Module(
        complete = true,    // Here we enable object graph validation
        library = true,
        addsTo = ApplicationScopeModule.class, // Important for object graph validation at compile time
        injects = {
                MainActivity.class,
                MainFragment.class
        }
)
public class ActivityScopeModule {

    private final BaseActivity mActivity;

    public ActivityScopeModule(BaseActivity activity) {
        mActivity = activity;
    }

    @Provides
    @Singleton
    @ForActivity
    Context providesActivityContext() {
        return mActivity;
    }

    @Provides
    @Singleton
    Activity providesActivity() {
        return mActivity;
    }
}
