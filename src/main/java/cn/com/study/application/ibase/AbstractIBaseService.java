package cn.com.study.application.ibase;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public abstract class AbstractIBaseService<T> implements IbaseService<T> {
	
	private AbstractIBaseMapper<T> abstractIBaseMapper;
	
	public void setConfig(AbstractIBaseMapper<T> abstractIBaseMapper) {
		this.abstractIBaseMapper = abstractIBaseMapper;
	}

	public T get(int id) {
		
		return abstractIBaseMapper.get(id);
	}
	
	public void remove(T t) {
		
	}
	
	public void update(T t) {
		
	}
	
	public List<T> getList() {
		return abstractIBaseMapper.getList();
	}
}
