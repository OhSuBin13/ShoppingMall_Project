package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.User;

@Mapper
public interface UserMapper {

	/*
	 * private String studentName;
	 * 
	 * private int studentNumber;
	 * 
	 * private String phoneNumber;
	 * 
	 * private String emailAddress;
	 */
	
	@Select("select * from user")
	@Results({
		@Result(property = "id", column="id",javaType = Long.class),
        @Result(property = "userName", column="user_name",javaType = String.class),
        @Result(property = "userId", column="user_id",javaType = String.class),
        @Result(property = "userPw", column = "user_pw",javaType = String.class),
        @Result(property = "phoneNumber", column = "phone_number",javaType = String.class),
        @Result(property = "emailAddress", column = "email_address",javaType = String.class),
        @Result(property = "userLevel", column = "user_level",javaType = Long.class)
	})
	public List<User> findAll();
	
	@Select("select * from user where id = #{id}")
	@Results({
		@Result(property = "id", column="id",javaType = Long.class),
        @Result(property = "userName", column="user_name",javaType = String.class),
        @Result(property = "userId", column="user_id",javaType = String.class),
        @Result(property = "userPw", column = "user_pw",javaType = String.class),
        @Result(property = "phoneNumber", column = "phone_number",javaType = String.class),
        @Result(property = "emailAddress", column = "email_address",javaType = String.class),
        @Result(property = "userLevel", column = "user_level",javaType = Long.class)
	})
	public User findUserById(long id);
	
	@Select("select * from user where user_id = #{userId}")
	@Results({
		@Result(property = "id", column="id",javaType = Long.class),
        @Result(property = "userName", column="user_name",javaType = String.class),
        @Result(property = "userId", column="user_id",javaType = String.class),
        @Result(property = "userPw", column = "user_pw",javaType = String.class),
        @Result(property = "phoneNumber", column = "phone_number",javaType = String.class),
        @Result(property = "emailAddress", column = "email_address",javaType = String.class),
		@Result(property = "userLevel", column = "user_level",javaType = Long.class)
	})
	public User findUserByuserId(String userId);
	   
	
	@Insert("INSERT INTO user(user_name, user_id, user_pw, phone_number, email_address, user_level) VALUES "
			+ "(#{userName},#{userId},#{userPw},#{phoneNumber}, #{emailAddress}, 1)")
	public void save(User user) ;
	
	
	
	@Update("update user set user_name=#{userName, jdbcType=CHAR}," 
			+ "user_id=#{userId, jdbcType=CHAR},"
			+ "user_pw=#{userPw, jdbcType=CHAR},"
			+ "phone_number=#{phoneNumber, jdbcType=CHAR},"
			+ "email_address=#{emailAddress, jdbcType=CHAR}"
			+ "where id=#{id}")
	public void edit(User user);	
	
	
	@Delete("DELETE FROM user WHERE id = #{id}")
	public void delete(long id);

}
