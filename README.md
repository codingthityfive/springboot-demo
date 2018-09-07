### springboot脚手架
![build](https://img.shields.io/badge/build-success-brightgreen.svg)
![gradle](https://img.shields.io/badge/gradle-4.9-brightgreen.svg)
![springboot](https://img.shields.io/badge/springboot-2.0.2-brightgreen.svg)
![swagger2](https://img.shields.io/badge/swagger2-2.8.0-brightgreen.svg)
![database](https://img.shields.io/badge/database-mysql-brightgreen.svg)
![database](https://img.shields.io/badge/database-oracle-brightgreen.svg)
![database](https://img.shields.io/badge/database-postgresql-brightgreen.svg)
![download](https://img.shields.io/badge/download-2714k-yellow.svg)


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
