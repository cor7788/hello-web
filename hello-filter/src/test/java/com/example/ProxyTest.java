package com.example;

import com.example.domain.Animal;
import com.example.domain.Dog;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    public void testProxy() {
        Dog dog = new Dog();
        Animal animal = (Animal) Proxy.newProxyInstance(dog.getClass().getClassLoader(),
                dog.getClass().getInterfaces(), new InvocationHandler() {

                    /**
                     * 真实对象的方法执行时都会触发这个方法的执行
                     * @param proxy 代理对象
                     * @param method 真实对象正在执行的方法
                     * @param args 真实对象正在执行的方法的参数
                     * @return 代理对象执行方法后的返回值
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = method.invoke(dog, args);
                        return returnValue;
                    }
                });
        String result = animal.eat();
        System.out.println(result);
    }
}
