# ssh-shiro-template

> ssh框架整合shiro

> 说明

``` bash
# 1 jdbc文件根据实际情况进行修改
# 2 整合过程
## （1）在pom.xml中引入包
##  <dependency>
         <groupId>org.apache.shiro</groupId>
         <artifactId>shiro-spring</artifactId>
         <version>1.4.0</version>
    </dependency>
## （2）引入配置文件
### shiro.properties : 用于MD5密码加密的配置
### spring-shiro.xml : shiro配置文件
## （3）修改web.xml文件
### <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring-common.xml,classpath:spring-shiro.xml</param-value>
      </context-param>
###<filter>
       <filter-name>shiroFilter</filter-name>
       <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
       <init-param>
         <param-name>targetFilterLifecycle</param-name>
         <param-value>true</param-value>
       </init-param>
     </filter>

     <filter-mapping>
       <filter-name>shiroFilter</filter-name>
       <url-pattern>/*</url-pattern>
     </filter-mapping>
##（3）实现AuthorizingRealm类（InvoiceRealm.java）

```