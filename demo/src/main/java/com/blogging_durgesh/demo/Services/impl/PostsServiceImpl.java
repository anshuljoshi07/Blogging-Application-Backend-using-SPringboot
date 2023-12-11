package com.blogging_durgesh.demo.Services.impl;

import com.blogging_durgesh.demo.Exceptions.ResourceNotFoundException;
import com.blogging_durgesh.demo.Repositories.CatergoriesRepo;
import com.blogging_durgesh.demo.Repositories.PostsRepo;
import com.blogging_durgesh.demo.Repositories.UserRepo;
import com.blogging_durgesh.demo.Services.PostsService;
import com.blogging_durgesh.demo.entities.Categories;
import com.blogging_durgesh.demo.entities.Comments;
import com.blogging_durgesh.demo.entities.Posts;
import com.blogging_durgesh.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostsServiceImpl implements PostsService {


    @Autowired
    private CatergoriesRepo CatRepo;
    @Autowired
    private PostsRepo postsrepo;

    @Autowired
    private UserRepo userrepo;

    @Override
    public List<Posts> GetAllPosts() {
        List<Posts> posts =  new ArrayList<>();
        posts = this.postsrepo.findAll();
        return posts;
    }

    @Override
    public List<Posts> GetAllPostsUser(int id) {
        User u = this.userrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));
        List<Posts> p = this.postsrepo.findAll();

        List<Posts> final_p = new ArrayList<>();
        for ( Posts i : p){
          //  System.out.println(i.getUser().getId());
            if(i.getUser().getId().equals(id)){

                final_p.add(i);
            }
        }
        return final_p;
    }

    @Override
    public List<Posts> GetAllPostsCatergories(int Cat_id) {
        Categories u = this.CatRepo.findById(Cat_id).orElseThrow(()->new ResourceNotFoundException("Categories","Cat_id", Cat_id));
        List<Posts> p = this.postsrepo.findAll();
        List<Posts> final_p = new ArrayList<>();
        for ( Posts i : p){
            if(i.getCategories().getCat_id().equals(Cat_id)){
                final_p.add(i);
            }
        }
        return final_p;
    }

    @Override
    public Posts GetPosts(int P_id) {
        Posts p = this.postsrepo.findById(P_id).orElseThrow(()->new ResourceNotFoundException("POsts", "post_id", P_id));
        return p;
    }

    @Override
    public void DeletingPosts(int P_id) {
        this.postsrepo.deleteById(P_id);

    }

    @Override
    public Posts UpdatingPosts(int P_id, Posts new_post) {
        Posts p = this.postsrepo.findById(P_id).orElseThrow(()->new ResourceNotFoundException("POsts", "post_id", P_id));
        new_post.setUser(p.getUser());
        new_post.setCategories(p.getCategories());
        this.postsrepo.deleteById(P_id);
        this.postsrepo.save(new_post);
       return new_post;
    }

    @Override
    public Posts CreatingPosts(Posts post, int id, int Cat_id) {
        Posts p = new Posts();
        //User u = new User();
        User u = this.userrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));
        Categories cat = this.CatRepo.findById(Cat_id).orElseThrow(()->new ResourceNotFoundException("Category","Cat_id",Cat_id));
        post.setUser(u);
        post.setCategories(cat);
        this.postsrepo.save(post);

        return post;
    }

    @Override
    public List<Comments> GetAllCommentsPost(int P_id) {
        Posts p = this.postsrepo.findById(P_id).orElseThrow(()->new ResourceNotFoundException("POsts", "post_id", P_id));
        return p.getComments();
    }
}
