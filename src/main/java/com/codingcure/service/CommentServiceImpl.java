package com.codingcure.service;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
		  String commentId = bo.getCommentType().toLowerCase();
				
		 bo.setCommentType(commentId);
		
		bo.setCommentDate(new Date());
		System.out.println(bo);
		return commentRepositary.save(bo);
	}
	
	@Override
	public List<CommentBo> getComments(String  commentType) {
		// TODO Auto-generated method stub
		System.out.println(commentType);
			String cmt = commentType.toLowerCase();	
						
				
		System.out.println(cmt);
		 List<CommentBo> findByCommentTypeOrderByCommentDateDesc = commentRepositary.findByCommentTypeOrderByCommentDateDesc(cmt);
		 System.out.println(findByCommentTypeOrderByCommentDateDesc);
		 return findByCommentTypeOrderByCommentDateDesc;
	}
	
	/*
	 * private String removeBlankSpace(String commentIds) { String cmntid =
	 * commentIds.toLowerCase().chars() .mapToObj(c -> (char)c) .map(c -> c == ' ' ?
	 * '_' : c) .map(String::valueOf) .collect(Collectors.joining());
	 * 
	 * return cmntid; }
	 */
}
