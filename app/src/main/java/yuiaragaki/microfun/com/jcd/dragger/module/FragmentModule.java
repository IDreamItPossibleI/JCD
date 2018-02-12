package yuiaragaki.microfun.com.jcd.dragger.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import yuiaragaki.microfun.com.jcd.dragger.scope.ContextLife;
import yuiaragaki.microfun.com.jcd.dragger.scope.PerFragment;

/**
 * Created by yuiaragaki on 2018/2/12.
 */

@Module
public class FragmentModule {

    private Fragment mFragment;

    public FragmentModule(Fragment fragment)
    {
        this.mFragment = fragment;
    }

    @Provides
    @PerFragment
    @ContextLife("Activity")
    public Context provideFragmentContext()
    {
        return mFragment.getContext();
    }

    @Provides
    @PerFragment
    public Activity provideActivity()
    {
        return mFragment.getActivity();
    }

    @Provides
    @PerFragment
    public Fragment provideFragment()
    {
        return mFragment;
    }

}
