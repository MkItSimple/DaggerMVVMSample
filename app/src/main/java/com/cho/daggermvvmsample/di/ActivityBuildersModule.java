package com.cho.daggermvvmsample.di;

import com.cho.daggermvvmsample.di.auth.AuthModule;
import com.cho.daggermvvmsample.di.auth.AuthScope;
import com.cho.daggermvvmsample.di.auth.AuthViewModelsModule;
import com.cho.daggermvvmsample.di.main.MainFragmentBuildersModule;
import com.cho.daggermvvmsample.di.main.MainModule;
import com.cho.daggermvvmsample.di.main.MainScope;
import com.cho.daggermvvmsample.di.main.MainViewModelsModule;
import com.cho.daggermvvmsample.ui.auth.AuthActivity;
import com.cho.daggermvvmsample.ui.main.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module
public abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class, AuthModule.class})
    abstract AuthActivity contributeAuthActivity();


    @MainScope
    @ContributesAndroidInjector(
            modules = {MainFragmentBuildersModule.class, MainViewModelsModule.class, MainModule.class}
    )
    abstract MainActivity contributeMainActivity();

}
