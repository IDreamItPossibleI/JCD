package yuiaragaki.microfun.com.jcd.mvp.presenter;

import yuiaragaki.microfun.com.jcd.base.BaseActivity;
import yuiaragaki.microfun.com.jcd.base.BasePresenter;
import yuiaragaki.microfun.com.jcd.mvp.view.view.MyFragmentView;

/**
 * Created by yuiaragaki on 2018/2/5.
 */

public interface MyFragmentPresenter extends BasePresenter<MyFragmentView> {

    void getMyData(BaseActivity activity);

}
