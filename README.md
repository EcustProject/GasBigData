# GasBigDataProject
## *** 说明 ***
我们新建的这个项目，将db.properties加入到了.gitignore, 所以请大家将本地项目的db.properties加入到
/GasBigData/src/main/resources/properties/下。

## 如何构建项目

### 1.clone 项目
intellij -> New -> Project from Version Control
### 2.maven导入
intellij-> New -> Project from Existing Sources 选择step.1 clone的项目。
### 3.将db.properties加入到resources
 /GasBigData/src/main/resources/properties/ 正式环境使用
 /GasBigData/src/test/resources/properties/ 测试使用

### 4.配置tomcat
edit configurations -> + tomcat -> local
### 5.测试项目是否可正常启动
启动tomcat,访问http://localhost:8080/view/index，查看是否返回正确数据。

## 接口文档
我们项目的文档位于doc文件夹下。
其中http接口的相关描述采用markdown编写，具体格式可参照地暖用户API.md
为了便于阅读，可以安装sublime 以及 其插件sublimetext-markdown-preview，将.md文档编译为.html。
http://www.jianshu.com/p/aa30cc25c91b
