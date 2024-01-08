package org.example.services;

import org.example.components.MyComponent;

/**
 * @Service 如果使用 @Service 以及 XML 注入，會造成這錯誤
 * The bean 'myService', defined in class path resource [applicationContext.xml], could not be registered. A bean with that name has already been defined in file
 */
public class MyService {
    private MyComponent myComponent;

    public void setMyComponent(MyComponent myComponent) {
        this.myComponent = myComponent;
    }

    public String getHelloMessage() {
        return myComponent.doSomething();
    }
}