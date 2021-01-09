package com.codelifee.exercisecoach.exercisecoach.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.codelifee.exercisecoach.exercisecoach.model.Exercises;

@Mapper
public interface ExercisesMapper {

	@Select("select * from exercises order by exer_id")
	List<Exercises> findAll();
	
	@Select("SELECT * FROM exercises WHERE exer_id=#{exer_id}")
	Exercises getExercises(@Param("exer_id")String exer_id);
	
	@Insert("INSERT INTO exercises VALUES(#{exer_id},#{exer_name},#{descriptions})")
	int insertExercises(@Param("exer_id")String exer_id, @Param("exer_name")String exer_name,
			@Param("descriptions")String descriptions);
	
	@Update("UPDATE exercises SET exer_id=#{exer_id},exer_name=#{exer_name},descriptions=#{descriptions} where exer_id=#{exer_id}")
	int updateExercises(@Param("exer_id")String exer_id, 
			@Param("exer_name")String exer_name, @Param("descriptions")String descriptions);
	
	@Delete("DELETE FROM exercises WHERE exer_id=#{exer_id}")
	int deleteExercises(@Param("exer_id")String exer_id);
	
}

