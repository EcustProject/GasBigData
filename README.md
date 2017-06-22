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
启动tomcat,访问http://localhost:8080/test/hello，查看是否返回正确数据。