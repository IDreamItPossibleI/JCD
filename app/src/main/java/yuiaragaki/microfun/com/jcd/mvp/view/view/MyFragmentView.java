package yuiaragaki.microfun.com.jcd.mvp.view.view;

import yuiaragaki.microfun.com.jcd.MyBean;
import yuiaragaki.microfun.com.jcd.base.BaseView;

/**
 * Created by yuiaragaki on 2018/2/5.
 */

public interface MyFragmentView extends BaseView {

    void onMyDataSuccess(MyBean myBean);
    void onMyDataError(String msg);

}
