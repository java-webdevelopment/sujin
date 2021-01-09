package com.codelifee.exercisecoach.exercisecoach.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.codelifee.exercisecoach.exercisecoach.model.Comments;

public interface CommentsMapper {

	@Select("select * from comments order by com_id")
	List<Comments> findAll();
	
	@Select("SELECT * FROM comments WHERE com_id=#{com_id}")
	Comments getComments(@Param("com_id")int com_id);
	
	@Insert("INSERT INTO comments(contents,regdate,user_id,exer_id) VALUES(#{contents},now(),#{user_id},#{exer_id})")
	int insertComments(@Param("contents")String contents, @Param("user_id")String user_id, 
			@Param("exer_id")String exer_id);
	
	@Update("UPDATE comments SET contents=#{contents},regdate=now() where com_id=#{com_id}")
	int updateComments(@Param("contents")String contents,@Param("com_id")int com_id);
	
	@Delete("DELETE FROM comments WHERE com_id=#{com_id}")
	int deleteComments(@Param("com_id")int com_id);
}
