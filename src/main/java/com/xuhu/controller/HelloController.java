package com.xuhu.controller;

import com.xuhu.HelloBean;
import com.xuhu.IHelloBean;
import com.xuhu.prop.DataProp;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.ProxyBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuhu on 2017/2/11.
 */

@RestController
public class HelloController {

    @Autowired
    private DataProp dataProp;

    @Autowired
    private CamelContext camelContext;


    @RequestMapping("/")
    public String hello(){
        return "Hello world->" + dataProp.getMsg();
    }

    @RequestMapping("/hello1")
    public String hello1()throws Exception{
        IHelloBean proxy=new ProxyBuilder(camelContext).endpoint("direct:start1").build(IHelloBean.class);
        String test=proxy.sayHello("123r");
        return "Hello world->" + test;
    }

}
