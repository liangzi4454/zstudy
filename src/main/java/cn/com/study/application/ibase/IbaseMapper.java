package cn.com.study.application.ibase;

import java.util.List;

public interface IbaseMapper<T> {
	public T get(int id);
	
	public List<T> getList();
	
	public void insert(T t);
}
