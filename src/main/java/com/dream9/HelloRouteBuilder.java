package com.dream9;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloRouteBuilder extends RouteBuilder {

    @Autowired
    HelloBean helloBean;

    @Override
    public void configure() throws Exception {
        from("direct:start").to("myBean").to("mock:result");
    }
}