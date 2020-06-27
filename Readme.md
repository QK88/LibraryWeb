安装说明：

1、 数据库(mysql)部署

a)    数据库安装教程为：https://www.cnblogs.com/laumiansnotes/p/9069498.html

 

b)   进行数据库的数据库构建，数据迁移，

数据库文件为：见文件夹\数据库\

数据库数据迁移方法见：https://blog.csdn.net/u012318074/article/details/76695985

数据库的：用户名：root   密码：password

2、 tomcat服务器配置；idea及apache-tomcat-8.5.38环境变量配置教程见：

[IntelliJ IDEA配置Tomcat（完整版教程）](https://www.cnblogs.com/Miracle-Maker/articles/6476687.html)

1.导入项目，此处为import project，选择文件包

<img src=".\ReadmeImg\clip_image002.jpg" alt="img" style="zoom:50%;" />

2.根据源建立程序 

<img src=".\ReadmeImg\clip_image004.jpg" alt="img" style="zoom:80%;" />

3.next至以下界面 ：选择JavaExterprise,webApplicaton,选择您下载的JDK

<img src=".\ReadmeImg\clip_image006.jpg" alt="img" style="zoom:50%;" />

4.点击如图所示小三角，接着点击Edit Configurations-->绿色加号-->如果列表里没有则-->点击33 items more irrelevant这一项后继续寻找。

<img src=".\ReadmeImg\clip_image008.jpg" alt="img" style="zoom:80%;" />

Tomcat Server-->Local

5.

 

 

 

 

 

<img src=".\ReadmeImg\clip_image010.jpg" style="zoom:80%;" />

点击"Configure..."，配置Apache你从官网上下载的Tomcat，zip压缩包解压后的文件目录 ，我的是apache-tomcat-9.0.0.M13。

<img src=".\ReadmeImg\clip_image012.jpg" style="zoom:50%;" />

6.选择浏览器

<img src=".\ReadmeImg\clip_image014.jpg" style="zoom:50%;" />

建议使用火狐或者Chrome，开发者必备。

 7.配置artifacts，

 

![](.\ReadmeImg\clip_image016.jpg)

标签由Server跳到Deploment，点击小铅笔一样的图标对artifacts进行配置

<img src=".\ReadmeImg\clip_image018.jpg" style="zoom:50%;" />

新建文件夹-->绿色小加号-->Directory Content选择Web存放的位置，当然是Tomcat的webapps了,生成的war文件部署在该项目中才可以在Tomcat服务器上运行。直接运行在web文件夹下的index。jsp文件，做最后验证。

 

3、 启动tomcat、mysql后，在任意浏览器输入http://localhost:8080/libraryweb/index.jsp

即可使用