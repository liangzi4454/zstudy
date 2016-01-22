package cn.com.study.application.mapper;

import java.util.List;

import cn.com.study.application.model.UserEntity;
import cn.com.study.db.dynamic.spring.DataSource;

public interface UserMapper {
	public UserEntity getUserEntityById(int userId);
	
	public List<UserEntity> getUserEntities();
	@DataSource("dataource2")
	public int insertUser(UserEntity userEntity);
}
