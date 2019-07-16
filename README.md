##第一天,第一次使用

##参考b站码匠社区

资料

[Spring 文档](https://spring.io/guides/gs/serving-web-content/)

[Spring 视频](https://www.bilibili.com/video/av50200264/?p=3) 

[bootstrap](https://v3.bootcss.com/components/#navbar)

[bootstrapCDN](https://www.bootcdn.cn/)

##工具

[git](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)

##第二天

调用github,登录流程
![Image text](https://raw.githubusercontent.com/sanelee38/picture/master/picture/login.PNG)


##第三天

把所有需要的变量封装到application.properties中

Session和Cookies,实现登录、显示用户名

加入H2数据库

##第四天

[Spring](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)

##第五天

##集成mybatis并实现插入操作，登录用户数据返回到h2数据库

##遇到的问题：

1.无法启动项目，显示没有对应的bean。
        
        原因：发现是包名引用错误。
        
        解决方法：重新引用后成功启动项目

2.项目启动成功后，用户登录数据无法返回到h2数据库。

        原因：数据库数据项目与返回数据项目不匹配。
        
        解决：添加数据项目，解决问题。
        
##第六天

#脚本

        create table USER
        (
            ID int,Auto_increment primary key not null
            ACCOUNT_ID varchar(100),
            NAME varchar(50),
            TOKEN varchar(36),
            GMT_CREATE bigint,
            GMT_MODIFIED bigint
        );





