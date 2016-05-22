package cn.com.study.application.ibase;

import java.util.List;

import cn.com.study.application.model.BaseModel;

public interface IbaseMapper<T> {
	public T get(int id);

	public List<T> getList();

	int insert(T record);

	int insertSelective(T record);

	int updateByPrimaryKeySelective(T record);

	int updateByPrimaryKey(T record);

	T selectByPrimaryKey(Integer uid);

	int deleteByPrimaryKey(Integer uid);
}
