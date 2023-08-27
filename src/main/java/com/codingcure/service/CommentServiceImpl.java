package com.codingcure.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcure.entity.CommentBo;
import com.codingcure.repositary.CommentRepositary;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepositary commentRepositary;
	
	@Override
	public CommentBo saveComment(CommentBo bo) {
		bo.setCommentDate(new Date());
		return commentRepositary.save(bo);
	}
	
	@Override
	public List<CommentBo> getComments(String  commentType) {
		// TODO Auto-generated method stub
		System.out.println(commentType);
		 List<CommentBo> findByCommentTypeOrderByCommentDateDesc = commentRepositary.findByCommentTypeOrderByCommentDateDesc(commentType);
		 System.out.println(findByCommentTypeOrderByCommentDateDesc);
		 return findByCommentTypeOrderByCommentDateDesc;
	}
}
