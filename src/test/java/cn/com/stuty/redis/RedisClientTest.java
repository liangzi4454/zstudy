package cn.com.stuty.redis;

import org.junit.Test;

import cn.com.study.redis.RedisClient;

/**
 * ubuntu 下安装redis
 * <p>
 * 1.在Download目录中执行命令:wget http://download.redis.io/releases/redis-2.8.12.tar.gz 下载redis;<br>
 * 2.当前目录执行命令  tar zxvf redis-2.8.12.tar.gz 解压到当前目录;<br>
 * 3.当前目录执行命令 mv redis-2.8.12 /usr/local/ && cd /usr/local/redis-2.8.12 将解压出来的redis文件移动到该目录并跳转到该目录;<br>
 * 4.执行命令:sudo make 进行编译;
 * 5.执行命令:sudo make install 安装;<br>
 * 6.启动 server 当前目录执行命令:src/redis-server;<br>
 * 7.启动client 另起一个窗口个并进入安装目录执行命令:src/redis-cli;<br>
 * 8.测试:
 * <pre>
 *  set name LHY
 *  get name
 *  若是能得到"LHY"字符串，说明创建并启动成功,连接无错;
 * </pre>
 * 9.关闭redis命令:进入src目录 执行 redis-cli -h 127.0.0.1 -p 6379 shutdown
 * </p>
 * @author LHY
 * 2015年12月11日 下午5:54:00
 */
public class RedisClientTest {
	@Test
	public void KeyOperate() {
//		RedisClient.instance.operate();
//		RedisClient.instance.KeyOperate();
		RedisClient.instance.SetOperate();
	}
}