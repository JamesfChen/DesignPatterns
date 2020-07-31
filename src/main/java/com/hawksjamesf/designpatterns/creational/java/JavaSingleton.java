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
    private static JavaSingleton2 ourInstance;

    static JavaSingleton2 getInstance() {
        //由于java懒汉式单例线程不安全，所以需要加锁，最为常见的就是使用双重检查
        if (ourInstance == null) {
            synchronized (JavaSingleton.class) {
                if (ourInstance == null) {
                    ourInstance = new JavaSingleton2();
                    return ourInstance;
                }
            }
        }
        return ourInstance;
    }

    private JavaSingleton2() {
    }
}
