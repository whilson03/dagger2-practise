package com.olabode.wilson.dagger.di;

import android.app.Application;

import com.olabode.wilson.dagger.BaseApplication;
import com.olabode.wilson.dagger.SessionManager;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by OLABODE WILSON on 2020-02-19.
 */

@Singleton
@Component(
        modules = {AndroidSupportInjectionModule.class,
                ActivityBuildersModule.class,
                AppModule.class,
                ViewModelFactoryModule.class,

        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

    SessionManager sessionManager();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
