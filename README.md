# spring-study

## 1. Spring概述

### 简介

Spring : 春天 --->给软件行业带来了春天

2002年，Rod Jahnson首次推出了Spring框架雏形interface21框架。

2004年3月24日，Spring框架以interface21框架为基础，经过重新设计，发布了1.0正式版。

很难想象Rod Johnson的学历 , 他是悉尼大学的博士，然而他的专业不是计算机，而是音乐学。

Spring理念 : 使现有技术更加实用 . 本身就是一个大杂烩 , 整合现有的框架技术

官网 : http://spring.io/

官方下载地址 : https://repo.spring.io/libs-release-local/org/springframework/spring/

GitHub : https://github.com/spring-projects

### 优点

1、Spring是一个开源免费的框架 , 容器  .

2、Spring是一个轻量级的框架 , 非侵入式的 .

**3、控制反转 IoC  , 面向切面 Aop**

4、对事物的支持 , 对框架的支持

.......

一句话概括：

**Spring是一个轻量级的控制反转(IoC)和面向切面(AOP)的容器（框架）。**

### 组成

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7KtDiaOqFy5ourlJ8FTVV2FF6KnNia5YDhfatibrMvAUAhxgF27g4HdJsBGl6Fae9yQlUQJc9Bf8uftw/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

Spring 框架是一个分层架构，由 7 个定义良好的模块组成。Spring 模块构建在核心容器之上，核心容器定义了创建、配置和管理 bean 的方式 .

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7KtDiaOqFy5ourlJ8FTVV2FFetRkkw19r7H3mHDibgs4RpRNHdG6CcIMdnxRCu2yYXNiano7ESCCMF0A/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

组成 Spring 框架的每个模块（或组件）都可以单独存在，或者与其他一个或多个模块联合实现。每个模块的功能如下：

- **核心容器**：核心容器提供 Spring 框架的基本功能。核心容器的主要组件是 BeanFactory，它是工厂模式的实现。BeanFactory 使用*控制反转*（IOC） 模式将应用程序的配置和依赖性规范与实际的应用程序代码分开。
- **Spring 上下文**：Spring 上下文是一个配置文件，向 Spring 框架提供上下文信息。Spring 上下文包括企业服务，例如 JNDI、EJB、电子邮件、国际化、校验和调度功能。
- **Spring AOP**：通过配置管理特性，Spring AOP 模块直接将面向切面的编程功能 , 集成到了 Spring 框架中。所以，可以很容易地使 Spring 框架管理任何支持 AOP的对象。Spring AOP 模块为基于 Spring 的应用程序中的对象提供了事务管理服务。通过使用 Spring AOP，不用依赖组件，就可以将声明性事务管理集成到应用程序中。
- **Spring DAO**：JDBC DAO 抽象层提供了有意义的异常层次结构，可用该结构来管理异常处理和不同数据库供应商抛出的错误消息。异常层次结构简化了错误处理，并且极大地降低了需要编写的异常代码数量（例如打开和关闭连接）。Spring DAO 的面向 JDBC 的异常遵从通用的 DAO 异常层次结构。
- **Spring ORM**：Spring 框架插入了若干个 ORM 框架，从而提供了 ORM 的对象关系工具，其中包括 JDO、Hibernate 和 iBatis SQL Map。所有这些都遵从 Spring 的通用事务和 DAO 异常层次结构。
- **Spring Web 模块**：Web 上下文模块建立在应用程序上下文模块之上，为基于 Web 的应用程序提供了上下文。所以，Spring 框架支持与 Jakarta Struts 的集成。Web 模块还简化了处理多部分请求以及将请求参数绑定到域对象的工作。
- **Spring MVC 框架**：MVC 框架是一个全功能的构建 Web 应用程序的 MVC 实现。通过策略接口，MVC 框架变成为高度可配置的，MVC 容纳了大量视图技术，其中包括 JSP、Velocity、Tiles、iText 和 POI。

### 拓展

**Spring Boot与Spring Cloud**

- Spring Boot 是 Spring 的一套快速配置脚手架，可以基于Spring Boot 快速开发单个微服务;
- Spring Cloud是基于Spring Boot实现的；
- Spring Boot专注于快速、方便集成的单个微服务个体，Spring Cloud关注全局的服务治理框架；
- Spring Boot使用了约束优于配置的理念，很多集成方案已经帮你选择好了，能不配置就不配置 , Spring Cloud很大的一部分是基于Spring Boot来实现，Spring Boot可以离开Spring Cloud独立使用开发项目，但是Spring Cloud离不开Spring Boot，属于依赖的关系。
- SpringBoot在SpringClound中起到了承上启下的作用，如果你要学习SpringCloud必须要学习SpringBoot。

![图片](https://mmbiz.qpic.cn/mmbiz_png/uJDAUKrGC7KtDiaOqFy5ourlJ8FTVV2FFH5GFXM4YPUGrmA2JdpPic3FwYaI1JZHBZxibaUJVXWzzTFeCayk4XAIg/640?wx_fmt=png&wxfrom=5&wx_lazy=1&wx_co=1)

## 2. IOC理论推导

1、UserDao接口

2、UserDaoImpl实现类

3、UserService接口

4、UserServiceImpl实现类

在我们之前的业务中，用户的需求可能会影响我们原来的代码，我们需要根据用户的需求去修改源代码！如果程序代码量十分大，修改一次的成本代价十分昂贵！

我们使用一个set接口实现,已经发生类革命性的变化

```java
    private UserDao userDao;

    //利用set进行动态实现的注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
```

- 之前，程序是主动创建对象！控制权在程序猿手上！

- 使用了set注入后，程序不再具有主动性，而是变成类被动的接受对象！

  

这种思想，从本质上解决了问题，我们程序猿不用再去管理对象的创建了。系统的耦合行大大降低，可以更加专注的在业务实现上（横向扩展Mysql，Oracle，Sqlserver），这是IOC原型



#### IOC本质

**控制反转ioc(Inversion of Control),是一种设计思想，DI（依赖注入）是实现Ioc的一种方法，**也有人认为DI只是Ioc的另一种说法。没有Ioc的程序中，我们使用面向对象编程，对象的创建与对象间的依赖关系完全硬编码在程序中，对象的创建由程序自己控制，控制反转后将对象的创建转移给第三方，个人认为所谓的控制反转就是：获得依赖对象的方式反转类。



采用XML方式配置Bean的时候，Bean的定义信息是和实现分离的，而采用注解的方式可以把两者合为一体，Bean的定义信息直接以注解的形式定义在实现类中，从而达到了零配置的目的。

**控制反转是一种通过描述（XML或注解）并通过第三方去生产或获取特定对象的方式。在spring中实现控制反转的是ioc容器，其实现方法是依赖注入（Dependency Injection,DI）.**



## 3. HelloSpring

```java
public class MyTest {
    public static void main(String[] args) {
        // 解析beans.xml文件，生成管理相应的Bean对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // getBean：参数即为spring配置文件中bean的id
        Hello hello = (Hello)context.getBean("hello");
        System.out.println(hello.toString());
    }
}
```

**思考问题**

- hello对象是谁创建的？

  hello对象是由sping创建的

- hello对象属性是怎么设置的？

  hello对象的属性是由spring容器设置的

这个过程就叫**控制反转**：

**控制：**谁来控制对象的创建，传统应用程序的对象是由程序本身控制创建的，使用spring后，对象是由spring来创建的

**反转：**程序本身不创建对象，而变成被动的接收对象，

**依赖注入：**就是利用set方法进行注入的

IOC是一种编程思想，由主动的编程变成被动的接收

可以通过newClassPathXmlApplicationContext去浏览一下底层源码

OK，到了现在，我们彻底不用再程序中去改动类，要实现不同的操作，只需要在xml配置文件中进行修改，**所谓的ioc，一句话搞定：对象由spring来创建，管理，装配**

## 4. IOC创建对象的方式

实体类User

```java
package com.sicilly.pojo;

public class User {
    private String name;

    public User(){
        System.out.println("User的无参构造");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("name="+name);
    }
}

```

实体类注册到bean.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
<!--    id相当于要new的对象名，class相当于要new的对象的类-->
    <bean id="user" class="com.sicilly.pojo.User">
<!--    User类里有一个属性叫name，是一个基本类型，所以给它一个value-->
        <property name="name" value="zhangsan"></property>
    </bean>

</beans>
```

MyTest

```java
public class MyTest {
    public static void main(String[] args) {
        // 拿到容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 通过beans.xml中定义好的id拿到bean，转成User类
        User user = (User)context.getBean("user");
        // 调用user中的方法show
        user.show();

    }
}

```

输出：

```
User的无参构造
name=zhangsan
```

上面演示的是默认使用无参构造创建对象。

假设要使用有参构造创建对象。

```java
// 有参构造
public User(String name){
	this.name=name;
}
```

有以下几种方法：

1. 下标赋值

   ```xml
   <bean id="user" class="com.sicilly.pojo.User">
       <constructor-arg index="0" value="有参构造第一种"/>
   </bean>
   ```

2. 类型（不推荐）

   ```xml
   <bean id="user" class="com.sicilly.pojo.User">
       <constructor-arg type="java.lang.String" value="有参构造第二种"/>
   </bean>
   ```

3. 直接通过参数名（最容易理解）		

   ```xml
   <bean id="user" class="com.sicilly.pojo.User">
       <constructor-arg name="name" value="有参构造第三种"/>
   </bean>
   ```

总结：在配置文件加载的时候，容器中管理的对象就已经初始化了！
