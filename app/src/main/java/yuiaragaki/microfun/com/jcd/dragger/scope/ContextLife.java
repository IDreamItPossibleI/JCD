package yuiaragaki.microfun.com.jcd.dragger.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by yuiaragaki on 2018/2/11.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ContextLife {
    String value();
}
