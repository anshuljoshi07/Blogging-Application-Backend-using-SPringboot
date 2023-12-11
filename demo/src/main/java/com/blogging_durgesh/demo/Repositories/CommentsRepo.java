package com.blogging_durgesh.demo.Repositories;

import com.blogging_durgesh.demo.entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepo extends JpaRepository<Comments, Integer> {

}
