package cn.com.study.application.ibase;

import java.util.List;

public interface IbaseService<T> {
	public T get(int id);
	
	public void remove(T t);
	
	public void update(T t);
	
	public List<T> getList();
	
	public void insert(T t);
}
