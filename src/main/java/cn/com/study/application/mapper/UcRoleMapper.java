package cn.com.study.application.mapper;

import cn.com.study.application.model.UcRole;

public interface UcRoleMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table uc_role
	 *
	 * @mbggenerated Tue Apr 26 21:53:13 CST 2016
	 */
	int deleteByPrimaryKey(Integer uid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table uc_role
	 *
	 * @mbggenerated Tue Apr 26 21:53:13 CST 2016
	 */
	int insert(UcRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table uc_role
	 *
	 * @mbggenerated Tue Apr 26 21:53:13 CST 2016
	 */
	int insertSelective(UcRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table uc_role
	 *
	 * @mbggenerated Tue Apr 26 21:53:13 CST 2016
	 */
	UcRole selectByPrimaryKey(Integer uid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table uc_role
	 *
	 * @mbggenerated Tue Apr 26 21:53:13 CST 2016
	 */
	int updateByPrimaryKeySelective(UcRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table uc_role
	 *
	 * @mbggenerated Tue Apr 26 21:53:13 CST 2016
	 */
	int updateByPrimaryKey(UcRole record);
}