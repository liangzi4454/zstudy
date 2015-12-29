package cn.com.study.application.mapper;

import java.util.List;

import cn.com.study.application.model.UserEntity;

public interface UserMapper {
	UserEntity getUserEntityById(String userId);
	
	List<UserEntity> getUserEntities();
	
	int insertUser(UserEntity userEntity);
}
