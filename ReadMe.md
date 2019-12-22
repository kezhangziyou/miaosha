# Java秒杀系统方案优化-高性能高并发实战
[Examples](https://github.com/kezhangziyou/miaosha)  &nbsp;| &nbsp; [中文](README.md)

--- 

## 秒杀实战（目录结构说明）

- [miaosha_1](https://github.com/kezhangziyou/miaosha/tree/master/miaosha_1)：第1章-课程介绍及项目框架搭建
    * 1.Spring Boot环境搭建
    * 2.集成Thymeleaf , Result结果封装
    * 3.集成Mybatis+ Druid
    * 4.集成Jedis+ Redis安装+通用缓存Key封装
- [miaosha_2](https://github.com/kezhangziyou/miaosha/tree/master/miaosha_2)：第2章-实现用户登录以及分布式session功能
    * 1.数据库设计
    * 2.明文密码两次MD5处理
    * 3.JSR303参数检验+全局异常处理器
    * 4.分布式Session：uuid 和用户信息绑定，存储到 redis，同时把客户端的 session 存到 redis 同时控制生命周期

- [miaosha_3](https://github.com/kezhangziyou/miaosha/tree/master/miaosha_3)：第3章-秒杀功能开发及管理后台
    * 1.数据库设计
    * 2.商品列表页
    * 3.商品详情页
    * 4.订单详情页
    
- [miaosha_4](https://github.com/kezhangziyou/miaosha/tree/master/miaosha_4)：第4章-秒杀压测-Jmeter压力测试
    * 1.jmeter的安装
    * 2.jmeter的使用
    
- [miaosha_5](https://github.com/kezhangziyou/miaosha/tree/master/miaosha_5)：第5章-页面级高并发秒杀优化（Redis缓存+静态化分离）
    * 1.页面缓存+ URL缓存+对象缓存
    * 2.页面静态化,前后端分离
    * 3.静态资源优化
    * 4. CDN优化
    
- [miaosha_6](https://github.com/kezhangziyou/miaosha/tree/master/miaosha_6)：第6章-服务级高并发秒杀优化（RabbitMQ+接口优化）
    * 1.Redis预减库存减少数据库访问
    * 2.内存标记减少Redis访问
    * 3.请求先入队缓冲,异步下单,增强用户体验
    * 4.RabbitMQ与Spring Boot集成
    * 5.Ngin水平扩展
    * 6.mycat
    
- [miaosha_7](hhttps://github.com/kezhangziyou/miaosha/tree/master/miaosha_7)：第7章-图形验证码及恶意防刷
    * 1.秒杀接口地址隐藏
    * 2.数学公式验证码
    * 3.接口防刷


笔记
====================
#两次MD5
 *.用户端:PASS=MD5(明文+固定Salt)
 *.服务端: PASS = MD5 (用户输入+随机Salt )
 
# 缓存技术
redis缓存
页面静态化
分布式 session
# 接口优化
##第六章接口优化
1. Redis预减库存减少数据库访问
2. 内存标记减少Redis访问
3. 请求先入队缓冲,异步下单,增强用户体验
4. RabbitMQ与Spring Boot集成
5. Ngin水平扩展
6. mycat

##思路:减少数据库访问
1.系统初始化,把商品库存数量加载到Redis
2.收到请求, Redis预减库存,库存不足,直接返回,否则进入3
3.请求入队，立即返回排队中
4.请求出队,生成订单,减少库存
5.客户端轮询,是否秒杀成功

# SpringBoot集成RabbitMQ
1.添加依赖spring-boot-starter-amqp
2.创建消息接受者
3.创建消息发送者

# 限流
 对接口做限流