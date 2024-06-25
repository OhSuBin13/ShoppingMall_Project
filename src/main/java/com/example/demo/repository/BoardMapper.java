package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.Board;

@Mapper
public interface BoardMapper {
	@Select("select * from board")
	@Results({
        @Result(property = "id", column="id",javaType = Integer.class),
        @Result(property = "userId", column="user_id",javaType = String.class),
        @Result(property = "boardTitle", column = "title",javaType = String.class),
        @Result(property = "boardInformation", column = "information",javaType = String.class)
	})
	public List<Board> findAll();
	
	@Select("select * from board where id = #{id}")
	@Results({
        @Result(property = "id", column="id",javaType = Integer.class),
        @Result(property = "userId", column="user_id",javaType = String.class),
        @Result(property = "boardTitle", column = "title",javaType = String.class),
        @Result(property = "boardInformation", column = "information",javaType = String.class)
	})
	public Board findBoardById(String id);		   

	@Insert("INSERT INTO board(user_id, title, information) VALUES "
			+ "(#{userId},#{boardTitle},#{boardInformation})")
	public void save(Board board);
	
	@Update("update board set title=#{boardTitle, jdbcType=CHAR}," 
			+ "information=#{boardInformation, jdbcType=CHAR}"
			+ "where user_id=#{userId}")
	public void edit(Board board);	
	
	
	@Delete("DELETE FROM board  WHERE user_id=#{userId}")
	public void delete(String userId);

}
