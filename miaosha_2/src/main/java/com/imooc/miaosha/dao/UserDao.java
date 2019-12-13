package com.imooc.miaosha.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.imooc.miaosha.domain.User;
/**
 * @description 
 * @author zhangke
 * @date 1:59 PM 2019/12/9
 * @version 1.0
 **/
@Mapper
public interface UserDao {
	/**
	 * 不需要 xml 文件,更加简单些,
	 * @param id
	 * @return
	 */
	@Select("select * from user where id = #{id}")
	public User getById(@Param("id")int id	);

	@Insert("insert into user(id, name)values(#{id}, #{name})")
	public int insert(User user);
	
}
