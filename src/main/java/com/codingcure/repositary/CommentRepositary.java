package com.codingcure.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcure.entity.CommentBo;

@Repository
public interface CommentRepositary extends JpaRepository<CommentBo,Long> {
	    List<CommentBo> findByCommentTypeOrderByCommentDateDesc(String commentType);

}
