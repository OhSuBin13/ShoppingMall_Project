package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.Item;

@Mapper
public interface ItemMapper {
	@Select("select * from item")
	@Results({
        @Result(property = "itemName", column="name",javaType = String.class),
        @Result(property = "itemOrigin", column="origin",javaType = String.class),
        @Result(property = "itemNumber", column = "number",javaType = Integer.class),
        @Result(property = "itemPrice", column = "price",javaType = Integer.class),
        @Result(property = "itemInformation", column = "information",javaType = String.class),
        @Result(property = "itemType", column="type",javaType = String.class)
	})
	public List<Item> findAll();
	
	@Select("select * from item where name = #{name}")
	@Results({
		@Result(property = "itemName", column="name",javaType = String.class),
        @Result(property = "itemOrigin", column="origin",javaType = String.class),
        @Result(property = "itemNumber", column = "number",javaType = Integer.class),
        @Result(property = "itemPrice", column = "price",javaType = Integer.class),
        @Result(property = "itemInformation", column = "information",javaType = String.class),
		@Result(property = "itemType", column="type",javaType = String.class)
	})
	public Item findItemByName(String name);
	
	@Select("select * from item where type = #{type}")
	@Results({
		@Result(property = "itemName", column="name",javaType = String.class),
        @Result(property = "itemOrigin", column="origin",javaType = String.class),
        @Result(property = "itemNumber", column = "number",javaType = Integer.class),
        @Result(property = "itemPrice", column = "price",javaType = Integer.class),
        @Result(property = "itemInformation", column = "information",javaType = String.class),
		@Result(property = "itemType", column="type",javaType = String.class)
	})
	public Item findItemByType(String type);
	
	@Select("select * from item where type = #{type}")
	@Results({
		@Result(property = "itemName", column="name",javaType = String.class),
        @Result(property = "itemOrigin", column="origin",javaType = String.class),
        @Result(property = "itemNumber", column = "number",javaType = Integer.class),
        @Result(property = "itemPrice", column = "price",javaType = Integer.class),
        @Result(property = "itemInformation", column = "information",javaType = String.class),
		@Result(property = "itemType", column="type",javaType = String.class)
	})
	public List<Item> findTypeAll(String type);
		   

	@Insert("INSERT INTO item(name, origin, number, price, information, type) VALUES "
			+ "(#{itemName},#{itemOrigin},#{itemNumber},#{itemPrice}, #{itemInformation}, #{itemType})")
	public void save(Item item) ;
	
	
	
	@Update("update item set origin=#{itemOrigin, jdbcType=CHAR}," 
			+ "number=#{itemNumber, jdbcType=BIGINT},"
			+ "price=#{itemPrice, jdbcType=BIGINT},"
			+ "information=#{itemInformation, jdbcType=CHAR},"
			+ "type=#{itemType, jdbcType=CHAR}"
			+ "where name=#{itemName}")
	public void edit(Item item);	
	
	
	@Delete("DELETE FROM item  WHERE name=#{name}")
	public void delete(String name);

}
