package yuiaragaki.microfun.com.jcd.base;

/**
 * Created by yuiaragaki on 2018/2/5.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);
    void detachView();

}
