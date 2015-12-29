package cn.com.study.application.mapper;

import java.util.List;

import cn.com.study.application.model.UserEntity;

public interface UserMapper {
	public UserEntity getUserEntityById(String userId);
	
	public List<UserEntity> getUserEntities();
	
	public int insertUser(UserEntity userEntity);
}
