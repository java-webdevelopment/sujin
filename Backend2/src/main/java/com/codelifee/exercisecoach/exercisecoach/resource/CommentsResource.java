package com.codelifee.exercisecoach.exercisecoach.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codelifee.exercisecoach.exercisecoach.mapper.CommentsMapper;
import com.codelifee.exercisecoach.exercisecoach.model.Comments;

@RestController
@RequestMapping("/rest/comments")
@CrossOrigin(origins="http://localhost:5000")
public class CommentsResource {

	private CommentsMapper commentsMapper;
	
	@Autowired
	public CommentsResource(CommentsMapper commentsMapper) {
		this.commentsMapper = commentsMapper;
	}
	
	@GetMapping("/all")
	public List<Comments> getAll() {
		return commentsMapper.findAll();
	}
	
	@GetMapping("/{com_id}")
	public Comments getComments(@PathVariable("com_id")int com_id) {
		return commentsMapper.getComments(com_id);
	}
	
	@PutMapping("/create_comment")
	public void createComments(@RequestParam("contents")String contents, @RequestParam("user_id")String user_id, 
			@RequestParam("exer_id")String exer_id) {
		commentsMapper.insertComments(contents, user_id, exer_id);
	}
	
	@PostMapping("/{com_id}")
	public void updateComments(@PathVariable("com_id")int com_id, @RequestParam("contents")String contents) {
		commentsMapper.updateComments(contents, com_id);
	}
	
	@DeleteMapping("/{com_id}")
	public void deleteComments(@PathVariable("com_id")int com_id) {
		commentsMapper.deleteComments(com_id);
	}
	
}
