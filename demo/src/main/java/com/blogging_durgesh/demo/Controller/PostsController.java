package com.blogging_durgesh.demo.Controller;

import com.blogging_durgesh.demo.Exceptions.ResourceNotFoundException;
import com.blogging_durgesh.demo.Services.PostsService;
import com.blogging_durgesh.demo.entities.Categories;
import com.blogging_durgesh.demo.entities.Posts;
import com.blogging_durgesh.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/posts")
public class PostsController {

    @Autowired
   private PostsService postsService;


    @PostMapping(value="/user/{userID}/category/{categoryId}")
public Posts CreatePost(@RequestBody Posts posts, @PathVariable Integer userID,
                        @PathVariable Integer categoryId){

       return this.postsService.CreatingPosts(posts,userID,categoryId);


    }

    @GetMapping(value="/")
    public List<Posts> GetAllPosts(){
        return this.postsService.GetAllPosts();
    }


    @GetMapping(value="/user/{id}")
    public List<Posts> GetAllPostsUser(@PathVariable int id) {
      return this.postsService.GetAllPostsUser(id);
    }

    @GetMapping(value="/Categories/{Cat_id}")
    public List<Posts> GetAllPostsCatergories(@PathVariable int Cat_id) {
      return this.postsService.GetAllPostsCatergories(Cat_id);
    }

    @GetMapping(value="/{P_id}")
    public Posts GetPosts(@PathVariable int P_id) {
      return this.postsService.GetPosts(P_id);
    }

    @DeleteMapping(value="/{P_id}")
    public void DeletingPosts(@PathVariable int P_id) {
        this.postsService.DeletingPosts(P_id);

    }

    @PostMapping(value="/{P_id}")
    public Posts UpdatingPosts(@PathVariable int P_id,@RequestBody Posts new_post) {
        return this.postsService.UpdatingPosts(P_id,new_post);

    }




}
