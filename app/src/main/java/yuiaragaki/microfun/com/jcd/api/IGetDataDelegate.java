package yuiaragaki.microfun.com.jcd.api;

/**
 *
 * 网络请求回调
 * Created by yuiaragaki on 2018/2/5.
 */

public interface IGetDataDelegate<T> {

    void getDataSuccess(T t);
    void getDataError(String msg);

}
