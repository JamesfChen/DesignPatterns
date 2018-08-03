package com.hawksjamesf.designpatterns.structural.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawks.jamesf
 * @since: Aug/02/2018  Thu
 */
//static proxy
interface IBinder {
    void transact();
}

class Binder implements IBinder {

    public void transact() {
        onTransact();
    }

    public void onTransact() {

    }
}

class BinderProxy implements IBinder {
    public void transact() {

    }
}

class Activity {
    private BinderProxy proxy = new BinderProxy();
}


//dynamic proxy
class Activity2 {
    private void call(Class service) {
        Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service}, new ProxyHandler());
    }
}

class ProxyHandler implements InvocationHandler {

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        //todo something
        return null;
    }
}