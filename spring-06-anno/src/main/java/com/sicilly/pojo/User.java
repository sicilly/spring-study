package com.sicilly.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 等价于<bean id="user" class="com.sicilly.pojo.User"/>
@Component
@Scope("prototype")
public class User {
    // 相当于 <property name="name" value="可达鸭"></property>
    @Value("可达鸭")
    public String name;
}
