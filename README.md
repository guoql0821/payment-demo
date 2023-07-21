1:需要先把doc里面的jce_policy-8解压出来放下面说的地方
2:异步返回通知需要使用内网穿透ngrok来生成这个ip和端口生成的域名，把这个域名填写在wxpay.properties文件的
wxpay.notify-domain 这个参数



我们做Java开发，或是Android开发，都会先在电脑上安装JDK(Java Development Kit) 并配置环境变量，JDK也就是 Java 语言的软件开发工具包，JDK中包含有JRE（Java Runtime Environment，即：Java运行环境），JRE中包括Java虚拟机（Java Virtual Machine）、Java核心类库和支持文件，而我们今天要说的主角就在Java的核心类库中。在Java的核心类库中有一个JCE（Java Cryptography Extension），JCE是一组包，它们提供用于加密、密钥生成和协商以及 Message Authentication Code（MAC）算法的框架和实现，所以这个是实现加密解密的重要类库。

在我们安装的JRE目录下有这样一个文件夹：%JAVE_HOME%\jre\lib\security（%JAVE_HOME%是自己电脑的Java路径，一版默认是：C:\Program Files\Java，具体看自己当时安装JDK和JRE时选择的路径是什么），其中包含有两个.jar文件：“local_policy.jar ”和“US_export_policy.jar”，也就是我们平时说的jar包，再通俗一点说就是Java中包含的类库（Sun公司的程序大牛封装的类库，供使用Java开发的程序员使用），这两个jar包就是我们JCE中的核心类库了。JRE中自带的“local_policy.jar ”和“US_export_policy.jar”是支持128位密钥的加密算法，而当我们要使用256位密钥算法的时候，已经超出它的范围，无法支持，所以才会报：“java.security.InvalidKeyException: Illegal key size or default parameters”的异常。那么我们怎么解决呢？

使用说明
下载后解压，可以看到local_policy和US_export_policy以及readme.txt
如果安装了JRE，将两个jar文件放到%JRE_HOME%\lib\security目录下覆盖原来的文件。

如果安装了JDK，还要将两个jar文件也放到%JDK_HOME%\jre\lib\security目录下覆盖原来文件。