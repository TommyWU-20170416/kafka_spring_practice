package org.example.controller;

import org.example.services.MyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Controller 如果使用 @Controller 以及 XML 注入，會造成這錯誤
 * The bean 'myService', defined in class path resource [applicationContext.xml], could not be registered. A bean with that name has already been defined in file
 */

/**
 * @Autowired 是注入的方式 可使用在 setMyService 的方法上面，且跟 XML 可共用
 */
@RequestMapping("/my")
public class MyController {

    private MyService myService;

    // 搭配 <constructor-arg ref="myService"/>
//    public MyController(MyService myService) {
//        this.myService = myService;
//    }

    // 搭配 <property name="myService" ref="myService"/>
    public void setMyService(MyService myService) {
        this.myService = myService;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return myService.getHelloMessage();
    }
}