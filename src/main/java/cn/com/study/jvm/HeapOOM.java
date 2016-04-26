package cn.com.study.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试堆内存异常：java.lang.OutOfMemoryError: Java heap space
 * @author Administrator
 *
 */
public class HeapOOM {
	static class OOMObject {
		
	}
	public static void main(String[] args) {
		List<HeapOOM> list = new ArrayList<>();
		
		while (true) {
			list.add(new HeapOOM());
		}
	}
}
