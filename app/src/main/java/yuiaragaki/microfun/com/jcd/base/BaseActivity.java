package yuiaragaki.microfun.com.jcd.base;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;

import yuiaragaki.microfun.com.jcd.AppActivityManager;
import yuiaragaki.microfun.com.jcd.R;

/**
 * Created by yuiaragaki on 2018/2/5.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ViewGroup barLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getSupportActionBar().hide();
        //保持竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        AppActivityManager.getInstance().addActivity(this);
        //初始化布局
        initLayout();
//        ButterKnife.inject(this);
        //设置沉浸式状态栏
        setStatus();
        //初始化view
        initView();
    }

    /**
     * 初始化布局
     */
    protected abstract void initLayout();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 系统版本4.4或以上才可以设置沉浸式
     *
     * 设置沉浸式状态栏
     */
    private void setStatus()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            // 设置状态栏透明
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //设置导航栏透明
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

            barLayout = (ViewGroup) findViewById(R.id.bar_layout);
            if(barLayout != null)
            {
                final int statusBarHeight = getStatusBarHeight();
                barLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        int height = barLayout.getHeight();
                        ViewGroup.LayoutParams layoutParams = barLayout.getLayoutParams();
                        layoutParams.height = statusBarHeight + height;
                        barLayout.setLayoutParams(layoutParams);
                    }
                });
            }
        }
    }

    /**
     *  获取状态栏的高度
     * @return
     */
    protected int getStatusBarHeight()
    {
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            Field status_bar_height = clazz.getField("status_bar_height");
            Object objectHeight = status_bar_height.get(object);
            int height = Integer.parseInt(objectHeight.toString());
            return getResources().getDimensionPixelSize(height);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return 0;
    }

    protected void openActivity(Class clazz)
    {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);
    }

    @Override
    protected void onDestroy() {
        AppActivityManager.getInstance().removeActivity(this);
        super.onDestroy();
    }

}
