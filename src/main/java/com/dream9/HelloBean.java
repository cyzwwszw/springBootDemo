package com.dream9;

import org.springframework.stereotype.Component;

/**
 * Created by cyzww on 2017/4/20.
 */
@Component(value = "myBean")
public class HelloBean implements IHelloBean{

    public String sayHello(String name) {
        return "Hello "+name;
    }
}
