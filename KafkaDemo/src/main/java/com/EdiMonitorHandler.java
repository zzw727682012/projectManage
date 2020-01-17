package com;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class EdiMonitorHandler implements InvocationHandler {

    private Map<String, Object> targetMap = new HashMap<String, Object>();
    private Object target;


    public Object createProxyInstance(Object targetObject) {
        this.target = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("使用动态代理了！");
        Class<?>[] types = method.getParameterTypes();
        if(method.getName().matches("get.+") && types.length == 1 && types[0] == String.class) {
            System.out.println("getXXX()方法，使用缓存");
            String key = (String)args[0];
            Object value = targetMap.get(key);
            if(value == null) {
                value = method.invoke(target, args);
                targetMap.put(key, value);
            }
            return value;
        }
        return method.invoke(target, args);

    }
}
