package yuiaragaki.microfun.com.jcd.api;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.zhxu.library.api.BaseApi;
import com.zhxu.library.listener.HttpOnNextListener;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import rx.Observable;
import yuiaragaki.microfun.com.jcd.MyBean;

/**
 * Created by yuiaragaki on 2018/2/5.
 */

public class MyApi extends BaseApi<MyBean> {

    public MyApi(HttpOnNextListener listener, RxAppCompatActivity rxAppCompatActivity) {
        super(listener, rxAppCompatActivity);
        setMethod("");
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        HttpGetConfig httpGetConfig = retrofit.create(HttpGetConfig.class);
        return httpGetConfig.getMyData();
    }

    @Override
    public MyBean call(ResponseBody responseBody) {
        String str = "";
        try {
            str = responseBody.string();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        return JsonParseUtils.parseTopBean(string);
        return null;
    }
}
