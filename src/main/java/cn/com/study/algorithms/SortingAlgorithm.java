package cn.com.study.algorithms;

import org.junit.Test;

/**
 * 8个常用排序算法:插入排序、冒泡排序、选择排序、希尔排序 、快速排序、归并排序、堆排序、LST基数排序
 * 
 * @author LHY 2016年3月22日 上午10:22:02
 */
public class SortingAlgorithm {
	/**
	 * 插入排序：时间复杂度o(n^2)
	 * @param a
	 * @return
	 */
	public static int[] insertSort(int a[]) {
		for (int i = 1; i < a.length; ++i) {
			int temp = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > temp) {
				a[j + 1] = a[j];
				--j;
			}
			a[j + 1] = temp;
		}
		return a;
	}
	
	/**
	 * 冒泡排序：时间复杂度o(n^2)
	 * @param a
	 * @param n
	 */
	public static int[] bubbleSort(int a[]) {
		for (int i = a.length - 1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		return a;
	}

	@Test
	public void testSorting() {
		int a[] = {1, 20, 10, 15, 6, 8};
		a = insertSort(a);
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
