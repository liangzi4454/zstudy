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
		DynamicDataSourceHolder.setRouteKey(DynamicDataSourceHolder.DATASOURCE1);
		return this.userMapper.getUserEntityById(userId);
	}

	public List<UserEntity> getUserEntities() {
		return this.userMapper.getUserEntities();
	}
	
	@Transactional(readOnly = false, propagation=Propagation.REQUIRED)
	public UserEntity insertUserEntity(UserEntity userEntity) {
		try {
			Object obj = null;
			this.userMapper.insertUser(userEntity);
			throw new Exception("sssssssssssssss");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userEntity;
	}
}