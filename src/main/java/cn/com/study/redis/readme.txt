ubuntu 下安装redis:

1.在Download目录中执行命令:wget http://download.redis.io/releases/redis-3.0.5.tar.gz 下载redis;
2.当前目录执行命令  tar zxvf redis-3.0.5.tar.gz 解压到当前目录;
3.当前目录执行命令 mv redis-3.0.5 /usr/local/ && cd /usr/local/redis-3.0.5 将解压出来的redis文件移动到该目录并跳转到该目录;
4.执行命令:sudo make 进行编译;
5.执行命令:sudo make install 安装;
6.启动 server 进入src目录执行命令:./redis-server;
7.启动 client 进入src目录执行命令:./redis-cli; 该操作即对数据库的操作
8.测试:
	set name LHY
	get name
 	若是能得到"LHY"字符串，说明创建并启动成功,连接无错;
 	
9.关闭 server 进入src目录 执行 ./redis-cli shutdown


redis分片操作:即一个redis服务器启动多个实例(Pre-Sharding)

1.进入redis安装目录,执行命令: cp redis.conf redis6380.conf;
2.vim redis6380.conf; 修改内容如下:
	pidfile /var/run/redis_6380.pid
	port 6380
	logfile "logfile/var/run/redis/redis_6380.log"
	dbfilename dump_6380.rdb
3.进入src目录,启动两个实例命令如下:
	./redis-server --port 6379;
	./redis-server --port 6380;

分片技术可以访问下边的网站
http://blog.csdn.net/lang_man_xing/article/details/38405269


注意:

Redis目前master/slave不是很成熟,目前只支持主从;
Redis在master是非阻塞模式,也就是说在slave执行数据同步的时候,master是可以接受客户端的请求的,并不影响同步数据的一致性;
然而在slave端是阻塞模式的,slave在同步master数据时,并不能够响应客户端的查询;
可以根据master/slave的特点,master不dump,它只负责写数据,让slave去dump;

redis主从的配置和使用 

http://blog.chinaunix.net/uid-20498361-id-3202002.html