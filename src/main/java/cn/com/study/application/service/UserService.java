package cn.com.study.application.service;

import java.util.List;

import cn.com.study.application.ibase.IbaseService;
import cn.com.study.application.model.UserEntity;

public interface UserService extends IbaseService<UserEntity> {
	public UserEntity getUserEntityById(int userId);
	
	public List<UserEntity> getUserEntities();
	
	public UserEntity insertUserEntity(UserEntity userEntity);
}
