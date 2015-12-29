package cn.com.study.application.service;

import java.util.List;

import cn.com.study.application.model.UserEntity;

public interface UserService {
	public UserEntity getUserEntityById(String userId);
	
	public List<UserEntity> getUserEntities();
	
	public UserEntity insertUserEntity(UserEntity userEntity);
}
