package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.Board2;

@Mapper
public interface BoardMapper2 {
	@Select("select * from board2")
	@Results({
        @Result(property = "id", column="id",javaType = Integer.class),
        @Result(property = "userId", column="user_id",javaType = String.class),
        @Result(property = "boardTitle", column = "title",javaType = String.class),
        @Result(property = "boardInformation", column = "information",javaType = String.class)
	})
	public List<Board2> findAll();
	
	@Select("select * from board2 where id = #{id}")
	@Results({
        @Result(property = "id", column="id",javaType = Integer.class),
        @Result(property = "userId", column="user_id",javaType = String.class),
        @Result(property = "boardTitle", column = "title",javaType = String.class),
        @Result(property = "boardInformation", column = "information",javaType = String.class)
	})
	public Board2 findBoardById(String id);		   

	@Insert("INSERT INTO board2(user_id, title, information) VALUES "
			+ "(#{userId},#{boardTitle},#{boardInformation})")
	public void save(Board2 board);
	
	@Update("update board2 set title=#{boardTitle, jdbcType=CHAR}," 
			+ "information=#{boardInformation, jdbcType=CHAR}"
			+ "where user_id=#{userId}")
	public void edit(Board2 board);	
	
	
	@Delete("DELETE FROM board2  WHERE user_id=#{userId}")
	public void delete(String userId);

}
