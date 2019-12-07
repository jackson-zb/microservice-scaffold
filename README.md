## microservice-scaffold
[![Build Status](https://travis-ci.org/michaelliao/openweixin.svg?branch=master)](https://travis-ci.org/ZhaiBo/microservice-scaffold)
[![codecov](https://codecov.io/gh/ZhaiBo/microservice-scaffold/branch/master/graph/badge.svg)](https://codecov.io/gh/ZhaiBo/microservice-scaffold)

基于Spring Cloud（Greenwich.SR2）搭建的微服务脚手架，已集成注册中心（Nacos Config）、配置中心（Nacos Discovery）、认证授权（Oauth
2 + JWT）、日志处理（ELK + Kafka）、限流熔断（AliBaba Sentinel）、应用指标监控（Prometheus + Grafana）、调用链监控（Pinpoint）、以及Spring Boot Admin。

## 快速开始
依赖环境：
- [java8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 
- [docker](https://www.docker.com/) 
- [git](https://git-scm.com/)
- [maven](http://maven.apache.org/) 

###  启动
#### 基础环境搭建
##### nacos
当前应用配置文件在config/example下，需要导入到nacos中，[nacos官方文档](https://editor.csdn.net/md/?articleId=103337840)
##### elk + kafka
进入config/docker-env/kafka-docker目录下，执行：`docker-compose up -d`；进入config/docker-env/docker-elk目录下，执行：`docker-compose up -d`即可。
可参考：[Spring Cloud日志集中化处理：ELK + Kafka](https://editor.csdn.net/md/?articleId=102717007)
##### prometheus + grafana
进入config/docker-env/prometheus目录下，执行：`docker-compose up -d`即可。
可参考：[Spring Cloud应用指标监控：Prometheus + Grafana](https://editor.csdn.net/md/?articleId=103337840)
##### pinpoint
进入config/docker-env/prometheus目录下，执行：`docker-compose pull && docker-compose up -d`即可。
可参考：[Spring Cloud链路追踪：Pinpoint](https://editor.csdn.net/md/?articleId=103335777)

##### 创建数据库及表
导入根路径db/目录下各模块下数据库脚本，可创建一个库或者分模块创建。

##### 启动应用
将工程导入idea，逐个启动SpringBoot应用即可。所依赖的基础服务如下：

|  基础服务           |   服务名         |  端口     | 说明                                            |
|----------------|-----------------|-----------|-------------------------------------------------|
|  KV缓存         |   redis         |  6379     |  目前用于存储JWT生成的access_token   |
|  数据库         |   mysql         |  3306     |  |
|  消息中间件      |   kafka      |  9092    |  与ELK集成 |
|  注册与配置中心  |   nacos     |  8848     |    |
|  日志处理  |   elk |  es:9200,kibana:5601,logstash:5000     |    |
|  应用指标监控    |   prometheus|9090 |  共用    |
|  数据可视化工具  |   grafana       |  3000     |  |
|  调用链路监控|   pinpoint|  8079|  |
|  限流熔断|   alibaba sentinel|  8858|  |
|  spring boot admin|   pinpoint|  8100|  |

各模块依赖服务：

|  服务名称           |   说明         |  依赖     | 服务端口 |
|----------------|-----------------|-----------|-----|
|  auth        |  认证服务器|  mysql、redis     |  8190   |
|  api-gateway         |   api网关        |  redis     | 8088 |
|  web-app      |   服务聚合层      |   alibaba sentinel    |  8087 |
|  user-svc  |   用户服务|  mysql |  8000  |
|  springboot admin|   应用监控|       |  8100  |

目前，仅完成基础框架搭建和统一报文、统一异常处理，暂未确定做什么业务。