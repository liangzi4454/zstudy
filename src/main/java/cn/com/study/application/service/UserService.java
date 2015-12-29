package cn.com.study.application.service;

import java.util.List;

import cn.com.study.application.model.UserEntity;

public interface UserService {
	UserEntity getUserEntityById(String userId);
	
	List<UserEntity> getUserEntities();
	
	UserEntity insertUserEntity(UserEntity userEntity);
}
