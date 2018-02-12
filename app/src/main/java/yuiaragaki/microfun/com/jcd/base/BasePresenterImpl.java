package yuiaragaki.microfun.com.jcd.base;

/**
 * Created by yuiaragaki on 2018/2/5.
 */

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {

    protected T mPresenterView;

    @Override
    public void attachView(T view) {
        this.mPresenterView = view;
    }

    @Override
    public void detachView() {
        this.mPresenterView = null;
    }
}
