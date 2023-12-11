package com.blogging_durgesh.demo.Services;


import com.blogging_durgesh.demo.entities.Comments;
import com.blogging_durgesh.demo.entities.Posts;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostsService {
     List<Posts> GetAllPosts();
    List<Posts> GetAllPostsUser(int id);
    List<Posts> GetAllPostsCatergories( int Cat_id);
    Posts GetPosts(int P_id);

    void DeletingPosts(int P_id);

    Posts UpdatingPosts(int P_id, Posts new_post);

    Posts CreatingPosts(Posts post, int id, int Cat_id);

    List<Comments> GetAllCommentsPost(int P_id);

}
