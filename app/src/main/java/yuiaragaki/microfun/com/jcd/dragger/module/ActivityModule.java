package yuiaragaki.microfun.com.jcd.dragger.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import yuiaragaki.microfun.com.jcd.dragger.scope.ContextLife;
import yuiaragaki.microfun.com.jcd.dragger.scope.PerActivity;

/**
 * Created by yuiaragaki on 2018/2/12.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity)
    {
        this.mActivity = activity;
    }

    @Provides
    @PerActivity
    @ContextLife("Activity")
    public Context provideActivityContext()
    {
        return mActivity;
    }

    @Provides
    @PerActivity
    public Activity provideActivity()
    {
        return mActivity;
    }

}
