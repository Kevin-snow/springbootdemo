springbootdemo:
    1.前期准备，建设数据库表。一共5张表，用户表、角色表、权限表、角色权限表、用户角色表。
    2.用户与角色是一对多的关系，角色与权限是一对多的关系。
    3.开发pojo类、mapper类、service类、serviceImpl类、mapper.xml等。
    4.pom.xml引入shiro包。
    5.重写Realm类中的授权方法、认证方法。
    6.写ShiroConfig配置类，配置拦截器规则。
    7.写controller的登录业务逻辑。
    
注意事项：
    1.application.java的启动类中，设置MapperScan
    2.application.yml配置数据源、server.port、context-path
    3.当mapper接口对应不上mapper.xml时，检查是否配置了mybatis.mapper-locations
    
Shiro简单介绍：
    shiro是apache的一个开源框架，是一个权限管理的框架，实现用户认证、用户授权。 
    spring中有spring security (原名Acegi)，是一个权限框架，它和spring依赖过于紧密，没有shiro使用简单。
    shiro不依赖于spring，shiro不仅可以实现web应用的权限管理，还可以实现c/s系统，分布式系统权限管理，shiro属于轻量框架，越来越多企业项目开始使用shiro。
    使用shiro实现系统的权限管理，有效提高开发效率，从而降低开发成本。