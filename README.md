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
##（3）实现AuthorizingRealm类（MyRealm.java）

## 调用过程
### （1）调用login接口时，首先使用UsernamePasswordToken生成登录用户的token
### （2）通过Subject currentUser = SecurityUtils.getSubject()获取当前登录用户
### （3）currentUser.login(token);
### （4）调用MyRealm.java中的doGetAuthenticationInfo()方法进行验证（只要是new SimpleAuthenticationInfo()）
### （5）调用其他接口时，如果有@RequiresRoles注解，则调用MyRealm.java中的doGetAuthorizationInfo()方法进行授权


## 使用@RequiresRoles("administrator")可以对接口进行访问角色限制
### 相关配置文件必须写在spring-mvc的配置文件（spring-servlet.xml）中，该注解才能在Controller层起作用，
### 否则只能在Service层起作用

## web.xml文件中的filter使用spring配置文件中的bean：代理——DelegatingFilterProxy类
### 如项目中的shiroFilter

## 需要注意filterChainDefinitions过滤器中对于路径的配置是有顺序的，当找到匹配的条目之后容器不会再继续寻找。因此带有通配符的路径要放在后面。
### 如项目中的spring-shiro.xml中的配置

```