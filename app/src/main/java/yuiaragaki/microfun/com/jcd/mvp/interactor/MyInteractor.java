package yuiaragaki.microfun.com.jcd.mvp.interactor;

import javax.inject.Inject;

import yuiaragaki.microfun.com.jcd.MyBean;
import yuiaragaki.microfun.com.jcd.api.IGetDataDelegate;
import yuiaragaki.microfun.com.jcd.base.BaseActivity;

/**
 * Created by yuiaragaki on 2018/2/5.
 */

public class MyInteractor {

    private IGetDataDelegate<MyBean> mDelegate;

    @Inject
    public MyInteractor()
    {

    }

    public void loadMyData(BaseActivity activity, IGetDataDelegate<MyBean> delegate)
    {
        this.mDelegate = delegate;
    }

}
