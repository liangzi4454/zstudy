package cn.com.study.application.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.study.application.mapper.UserMapper;
import cn.com.study.application.model.UserEntity;
import cn.com.study.db.dynamic.spring.DynamicDataSourceHolder;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public UserEntity getUserEntityById(int userId) {
		DynamicDataSourceHolder.setDataSource(DynamicDataSourceHolder.DATASOURCE1);
		return this.userMapper.getUserEntityById(userId);
	}

	public List<UserEntity> getUserEntities() {
		return this.userMapper.getUserEntities();
	}
	
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public UserEntity insertUserEntity(UserEntity userEntity) {
		this.userMapper.insertUser(userEntity);
		return userEntity;
	}

	
	public UserEntity get(int id) {
		return null;
	}

	
	public void remove(UserEntity t) {
	}

	
	public void update(UserEntity t) {
	}

	
	public List<UserEntity> getList() {
		return null;
	}

	
	public void insert(UserEntity t) {
	}
}