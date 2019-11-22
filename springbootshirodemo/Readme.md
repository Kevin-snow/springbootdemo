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