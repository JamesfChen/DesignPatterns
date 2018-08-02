package com.hawksjamesf.designpatterns.creational.java;

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawks.jamesf
 * @since: Aug/02/2018  Thu
 */

class JavaSingleton {
    //eager load-thread safe
    private static final JavaSingleton ourInstance = new JavaSingleton();

    static JavaSingleton getInstance() {
        return ourInstance;
    }

    private JavaSingleton() {
    }
}

class JavaSingleton2 {
    //lazy load-thread safe
    private static final JavaSingleton2 ourInstance = null;

    static JavaSingleton2 getInstance() {
        return ourInstance;
    }

    private JavaSingleton2() {
    }
}
