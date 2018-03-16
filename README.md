# 项目概述

    此项目为web 项目，服务端负责提供接口给apk 和管理员操作台
    web客户端 使用 jsp +js +css 实现
    服务端使用 servlet +mysqlite 实现
    整个项目基本没有使用开源框架。如果您有web 项目开发经验，可参考目前基本需求，重新进行快速开发。

# 软件环境版本
- eclipse 
- mySQL 5.7.19
- tomcat 8.5.23


# 目前完成状态

可以在web前端实现如下功能 
1.  信息人员 工号+姓名 录入
2.  分时间段将用户信息成绩展示。 
3.  按工号对某一用户成绩进行查询。
4.  在删除界面可对用户信息进行删除。
5.  考试文档的上传
6.  服务器考试文档目录检索 

如图：


# 待完成部分

1. 管理员登录
2. 将上传的文档文件解析为对应的题目格式（可以通过正则表达式将规定好的格式剪切为考试题目）并通过接口返回
3. 如投入使用，请购买服务器配置。

---

# 程序设计部分

## 基本遵循mvc设计模式

### M层

src->dao
dao层主要对数据库进行操作
GradeDBManager 操作数据库的方法都被封装在这个类中
GradeDBuitl 为数据库链接类 所有有关数据库链接都在此类中
DBString 数据库建表语句（目前只有一个表，后续可根据业务复杂程度进行关联）

//按日期查询
SELECT * FROM grade_manager_db.grade_table_reset  where DATE_FORMAT(grade_table_reset.current_time,'%Y-%M-%d')>DATE_FORMAT('2017-12-05','%Y-%M-%d') and DATE_FORMAT(grade_table_reset.current_time,'%Y-%M-%d')<DATE_FORMAT('2017-12-07','%Y-%M-%d');



### C层

src->servlet->
servlet 都在servlet 包下 根据名字可推断出此servlet 的用途 
servlet添加了Dispatcher层， 这层的逻辑很简单，主要是为了分辨请求源是 网页 还是apk 并通过不同的接口，返回对应的数据。

交互流程为：jsp->servlet->dao->Dispatcher->servlet->jsp

备注：tool 包下的工具类是 为此 AddExamFileSlt 提供读取服务器 文档名字和内容的方法（java 操作shell 脚本读取本地文件）。

other: 这个包类比较多,但其中的业务逻辑都很简单，并添加了注释。


### v层

webContent->webINF
jsppc
包含了增删改查jsp
views
上下左右模块的视图框架
index.jsp 为此web页面的入口

备注：其他样式 css 和el 表达式都在 jsp 中，都很基础和简单。


# 暴露给APK接口

1：
request:
http://localhost:8085/ExamSystems/login?name=value1&jobnumber=123456 注册格式。
result:

2:
requset:
http://localhost:8085/ExamSystems/Gradedbsert?type=2&grade=60&jobnumber=324 //修改成绩 
result:
[{"changeok":true}]

3:
request:
http://localhost:8085/ExamSystems/Gradedbsert?type=1  //查询所有 
result:
[{"jobnumber":"324","name":"崔泽辉"},{"jobnumber":"34","name":"张三"},{"jobnumber":"98547","name":"李四"}]

注册：
http://localhost:8085/ExamSystems/InsertSlt?fromtype=android&jobnumber=63&name=86786

备注：部分接口可能有所变动，或者设计不合理，如后续开发可将参数和返回格式进行重新优化。

---

# 学习计划
如果你是初学者，可以按照我个人学习路线进行学习。

        第一周：
        1.web服务器 servlet搭建
        2.数据库连接
        3.建表 
        第二周：
        4.json 数据封装
        5.数据库增加_连接池
        6.登录验证filter
        第三周：
        web请求转发和重定向
        第四周：
        1.jsp+js 入门（jqueary 学习）
        2.css 
        3.el 语句学习
        js 调试方式
        第五周：
        jstl 学习
        文件上传 调用shell 语句

# 最后
如有后续更新，欢迎push 给我共同学习，谢谢！