package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.Board3;

@Mapper
public interface BoardMapper3 {
	@Select("select * from board3")
	@Results({
        @Result(property = "id", column="id",javaType = Integer.class),
        @Result(property = "userId", column="user_id",javaType = String.class),
        @Result(property = "boardTitle", column = "title",javaType = String.class),
        @Result(property = "boardInformation", column = "information",javaType = String.class)
	})
	public List<Board3> findAll();
	
	@Select("select * from board3 where id = #{id}")
	@Results({
        @Result(property = "id", column="id",javaType = Integer.class),
        @Result(property = "userId", column="user_id",javaType = String.class),
        @Result(property = "boardTitle", column = "title",javaType = String.class),
        @Result(property = "boardInformation", column = "information",javaType = String.class)
	})
	public Board3 findBoardById(String id);		   

	@Insert("INSERT INTO board3(user_id, title, information) VALUES "
			+ "(#{userId},#{boardTitle},#{boardInformation})")
	public void save(Board3 board3);
	
	@Update("update board3 set title=#{boardTitle, jdbcType=CHAR}," 
			+ "information=#{boardInformation, jdbcType=CHAR}"
			+ "where user_id=#{userId}")
	public void edit(Board3 board3);	
	
	
	@Delete("DELETE FROM board3  WHERE user_id=#{userId}")
	public void delete(String userId);

}
