package cn.com.study.application.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.study.application.mapper.UserMapper;
import cn.com.study.application.model.UserEntity;

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

	public UserEntity getUserEntityById(String userId) {
		return this.userMapper.getUserEntityById(userId);
	}

	public List<UserEntity> getUserEntities() {
		return this.userMapper.getUserEntities();
	}
	
	@Transactional
	public UserEntity insertUserEntity(UserEntity userEntity) {
		this.userMapper.insertUser(userEntity);
		return getUserEntityById(userEntity.getUserId());
	}
}