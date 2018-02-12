package yuiaragaki.microfun.com.jcd.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yuiaragaki on 2018/2/5.
 */

public interface HttpGetConfig {

    @GET("my")
    Observable<ResponseBody> getMyData();

}
