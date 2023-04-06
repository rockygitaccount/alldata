package com.boggingApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boggingApp.Entity.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
