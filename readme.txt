发布第三方Jar到本地库中：
  
cmd中使用如下命令倒入

mvn install:install-file -DgroupId=javax.jms -DartifactId=jms -Dversion=1.1 -Dpackaging=jar -Dfile=D:\ProgramFiles\3thd_jar\javax.jms-1.1.jar

然后再pom.xml中可以正常使用
<dependency>
	<groupId>javax.jms</groupId>
	<artifactId>jms</artifactId>
	<version>1.1</version>
</dependency>