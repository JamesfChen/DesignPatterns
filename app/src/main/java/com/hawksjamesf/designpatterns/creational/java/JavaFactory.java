package com.hawksjamesf.designpatterns.creational.java;

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawks.jamesf
 * @since: Aug/02/2018  Thu
 */
//=========================================== abstract factory start
interface JavaAbstractFactory<T> {
    T create();
}

interface ViewModel {

}

class AndroidViewModel implements ViewModel {

}

class CustomViewModel implements ViewModel {

}

class Activity {
    public void call() {
        ViewModel androidViewModel = new JavaAbstractFactory<ViewModel>() {
            @Override
            public ViewModel create() {
                return new AndroidViewModel();
            }
        }.create();


        ViewModel customViewModel = new JavaAbstractFactory<ViewModel>() {
            @Override
            public ViewModel create() {
                return new CustomViewModel();
            }
        }.create();

    }
}
//=========================================== abstract factory end