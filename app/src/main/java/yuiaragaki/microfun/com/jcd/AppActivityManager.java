package yuiaragaki.microfun.com.jcd;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import java.util.Stack;

/**
 *
 * 统一管理activity
 *
 * Created by yuiaragaki on 2017/12/8.
 */

public class AppActivityManager {

    private static Stack<Activity> mActivityStack;
    private static AppActivityManager mAppManager;

    private AppActivityManager()
    {
    }

    /**
     * 单一实例
     * @return
     */
    public static AppActivityManager getInstance()
    {
        if(mAppManager == null)
        {
            mAppManager = new AppActivityManager();
        }
        return mAppManager;
    }

    /**
     * 添加Activity到堆栈
     * @param activity
     */
    public void addActivity(Activity activity)
    {
        if(mActivityStack == null)
        {
            mActivityStack = new Stack<>();
        }
        mActivityStack.add(activity);
    }

    /**
     * 移除Activity到堆外
     * @param activity
     */
    public void removeActivity(Activity activity)
    {
        mActivityStack.remove(activity);
    }

    /**
     * 获取栈顶Activity
     * @return
     */
    public Activity getTopActivity()
    {
        return mActivityStack.lastElement();
    }

    /**
     * 结束栈顶Activity
     */
    public void killTopActivity()
    {
        Activity activity = mActivityStack.lastElement();

    }

    /**
     * 结束指定的Activity
     * @param activity
     */
    public void killActivity(Activity activity)
    {
        if(activity != null)
        {
            mActivityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定类名的Activity
     * @param cls
     */
    public void killActivity(Class<?> cls)
    {
        for(Activity activity : mActivityStack)
        {
            if(activity.getClass().equals(cls))
            {
                killActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void killAllActivity()
    {
        for(int i = 0, size = mActivityStack.size(); i < size; i++)
        {
            if(null != mActivityStack.get(i))
            {
                mActivityStack.get(i).finish();
            }
        }
        mActivityStack.clear();
    }

    /**
     * 退出应用程序
     * @param context
     */
    public void AppExit(Context context)
    {
        try
        {
            killAllActivity();
            android.app.ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityManager.restartPackage(context.getPackageName());
            System.exit(0);
        }catch (Exception e)
        {
            Log.e("AppActivityManager", e+"");
        }
    }

}
