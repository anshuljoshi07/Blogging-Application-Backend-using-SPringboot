package com.blogging_durgesh.demo.Repositories;

import com.blogging_durgesh.demo.entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepo extends JpaRepository<Posts, Integer> {


}
