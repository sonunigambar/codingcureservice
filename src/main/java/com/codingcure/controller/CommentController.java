package com.codingcure.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingcure.constants.ConstantsValue;
import com.codingcure.entity.CommentBo;
import com.codingcure.service.CommentService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	
//	@PostMapping("/saveComment")
//	public ResponseEntity<String> saveComment(@RequestBody CommentBo  bo)
//	{
//		CommentBo commentBo = commentService.saveComment(bo);
//		if(commentBo !=null)
//			return new ResponseEntity<String>(ConstantsValue.SUCCESS_MESSAGE, HttpStatusCode.valueOf(ConstantsValue.SUCCESS_CREATED));
//		else
//			return new ResponseEntity<String>(ConstantsValue.ERROR_MESSAGE, HttpStatusCode.valueOf(ConstantsValue.ERROE_CODE));
//	}
	
	//Sonu's changes code. Here i hv remove userName
	@PostMapping("/saveComment")
	public ResponseEntity<String> saveComment(@RequestBody CommentBo  bo)
	{
		CommentBo commentBo = commentService.saveComment(bo);
		if(commentBo !=null)
			return new ResponseEntity<String>(ConstantsValue.SUCCESS_MESSAGE, HttpStatusCode.valueOf(ConstantsValue.SUCCESS_CREATED));
		else
			return new ResponseEntity<String>(ConstantsValue.ERROR_MESSAGE, HttpStatusCode.valueOf(ConstantsValue.ERROE_CODE));
	}
	
	@GetMapping("/comments")
	public ResponseEntity<List<CommentBo>> getComments(@RequestParam("commentType") String commentType)
	{
		System.out.println(commentType);
		List<CommentBo> commentList=commentService.getComments(commentType);
		ResponseEntity<List<CommentBo>> responseEntity = new ResponseEntity<List<CommentBo>>(commentList, HttpStatusCode.valueOf(ConstantsValue.SUCCESS_CODE));
		System.out.println(responseEntity);
		
			return responseEntity;
	}
	
	
}
