### springboot脚手架
![build](https://img.shields.io/badge/build-success-brightgreen.svg)
![gradle](https://img.shields.io/badge/gradle-4.9-brightgreen.svg)
![springboot](https://img.shields.io/badge/springboot-2.0.2-brightgreen.svg)
![swagger2](https://img.shields.io/badge/swagger2-2.8.0-brightgreen.svg)
![database](https://img.shields.io/badge/database-mysql-brightgreen.svg)
![database](https://img.shields.io/badge/database-oracle-brightgreen.svg)
![database](https://img.shields.io/badge/database-postgresql-brightgreen.svg)
![download](https://img.shields.io/badge/download-2714k-yellow.svg)

 基于gradle构建，主体框架为springboot2.0.2<br/>
 项目未包含数据库表，只需要按照Account实体类去新建表，修改application-dev.yml数据库为你自己的数据库即可运行<br/>
 项目使用了Lombok,建议使用idea查看代码。安装lombok插件<br/>
 swagger可以做快速测试及API文档生成，运行成功访问(http://localhost:8080/swagger-ui.html#/)<br/>
 redis需要你在application-dev.yml配置你自己的redis地址以及账号密码<br/>
 checkstyle做代码质量检查，只需要运行 gradle check即可查看代码检查情况，也可以自定义规则修改checkstyle.xml即可<br/>
 多数据源切换支持了Mysql，Oracle，PostgreSQL。<br/>
 日志管理使用log4j2，做了平台，业务，异常，运行，数据库切割。可自行定义log4j2-dev.yml，log4j2-prod.yml<br/>
 异常管理做了一些封装，可自行扩展<br/>
 增加了对rocketmq的支持，可自行扩展<br/>
 项目参考了网上一些不错的做法，永远感谢那些依然愿意免费分享的人<br/>
 项目结构如下<br/>
 ```
├── build.gradle
├── config
│   └── checkstyle
│       └── checkstyle.xml
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── lib
│   └── ojdbc6.jar
├── settings.gradle
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── sd
    │   │           ├── Application.java
    │   │           ├── Swagger2.java
    │   │           ├── controller
    │   │           │   ├── AccountController.java
    │   │           │   ├── ExceptionTestController.java
    │   │           │   ├── RedisTestController.java
    │   │           │   └── RocketMQTestController.java
    │   │           ├── dbconfig
    │   │           │   ├── DataSourceContextHolder.java
    │   │           │   ├── DataSourceType.java
    │   │           │   ├── DynamicDataSource.java
    │   │           │   ├── DynamicDataSourceAspect.java
    │   │           │   ├── DynamicDataSourceConfig.java
    │   │           │   └── SwitchDataSource.java
    │   │           ├── exception
    │   │           │   ├── BusinessException.java
    │   │           │   ├── ErrorEnum.java
    │   │           │   ├── ErrorInfo.java
    │   │           │   ├── GlobalExceptionHandler.java
    │   │           │   └── MyException.java
    │   │           ├── log
    │   │           │   ├── LogEnum.java
    │   │           │   └── LogUtils.java
    │   │           ├── mapper
    │   │           │   └── AccountMapper.java
    │   │           ├── model
    │   │           │   └── Account.java
    │   │           ├── redis
    │   │           │   ├── IRedisService.java
    │   │           │   ├── RedisConfig.java
    │   │           │   └── RedisServiceImpl.java
    │   │           ├── rocketmq
    │   │           │   ├── Consumer.java
    │   │           │   └── Producer.java
    │   │           ├── service
    │   │           │   ├── IAccountService.java
    │   │           │   └── impl
    │   │           │       └── AccountServiceImpl.java
    │   │           └── utils
    │   │               └── MyBatisUtil.java
    │   └── resources
    │       ├── application-dev.yml
    │       ├── application-prod.yml
    │       ├── application.yml
    │       ├── log4j2-dev.yml
    │       ├── log4j2-prod.yml
    │       ├── public
    │       ├── static
    │       └── templates
    │           ├── error.html
    │           └── index.html
    └── test
        ├── java
        └── resources
 ```
