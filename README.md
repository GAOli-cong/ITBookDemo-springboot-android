# ITBookDemo-springboot-android
基于安卓原生和springboot后台的图书管理系统


[csdn博客地址](https://blog.csdn.net/glc11223344/article/details/105934214)


ITBook文件夹是安卓代码

login-register文件夹是java后台代码

## 项目简介
根据springboot+mybatis后端返回json格式数据，移动端安卓完成登录、注册，图书列表页面的展示（增删改查）功能。

[登录注册的相关介绍可以查看此csdn博客](https://blog.csdn.net/glc11223344/article/details/105822237)

## 工具
**java后台：**
开发工具：idea
mysql版本：5.7版本      
 数据库中图书Item表资源来源于这位大佬 [weixin_43912367](https://blog.csdn.net/weixin_43912367)

通过springboot2.x+mybatis+mysql，通过pagehelper插件完成数据的分页功能


**安卓前台：**
开发工具：Android Studio
接口测试工具：postman
用到的jar包有volley（网络请求），Gson（解析json），glide（网络图片展示），GsonFormat工具生成json对应的实体类 ，使用fragment+viewPage实现页面的切换
## java后台
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200505162755540.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dsYzExMjIzMzQ0,size_16,color_FFFFFF,t_70)
使用的三层架构视图层(ItemController)、业务层(ItemService)、Dao层(ItemMapper)完成整个图书Item单表的CRUD,这里使用到MyBatis分页插件 PageHelper,可以让我们简单的完成数据的分页逻辑。
## 安卓端
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200505164503146.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dsYzExMjIzMzQ0,size_16,color_FFFFFF,t_70)
使用的是原生安卓，通过网络请求框架Volley完成对后台数据的获取。通过listview完成数据的展示。

*对于详细的代码片段因时间原因就不更了可以自行下载*
[这里是后端和安卓端源码Github下载链接，如果对您有帮助不妨给一个star](https://github.com/GAOli-cong/ITBookDemo-springboot-android)


