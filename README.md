# microservice-scaffold
[![Build Status](https://travis-ci.org/michaelliao/openweixin.svg?branch=master)](https://travis-ci.org/ZhaiBo/microservice-scaffold)
### nacos面板：http://localhost:8848/nacos/index.html 帐号和密码：nacos nacos
### hystrix面板：http://localhost:8761/hystrix
### kibana http://localhost:5601

### elk docker 快速搭建
https://elk-docker.readthedocs.io/#installation
### 错误解决：max virtual memory areas vm.max_map_count [65530] is too low, increase to at least [262144]
```sysctl -w vm.max_map_count=262144```

http://114.67.106.146:5601 kibana面板

elk:
  image: sebp/elk
  ports:
    - "5601:5601"
    - "9200:9200"
    - "5044:5044
docker run -d -p 5601:5601 -p 9200:9200 -p 5044:5044 -it --name elk sebp/elk

TODO
nocas集成zuul实现动态路由
Skywalking
Sentinel
