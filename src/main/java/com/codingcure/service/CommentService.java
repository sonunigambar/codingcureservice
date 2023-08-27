package com.codingcure.service;

import java.util.List;

import com.codingcure.entity.CommentBo;

public interface CommentService {

	CommentBo saveComment(CommentBo bo);

	List<CommentBo> getComments(String commentType);

}
