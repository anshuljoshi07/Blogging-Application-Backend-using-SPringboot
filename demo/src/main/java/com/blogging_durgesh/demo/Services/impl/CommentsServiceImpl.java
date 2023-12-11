package com.blogging_durgesh.demo.Services.impl;

import com.blogging_durgesh.demo.Exceptions.ResourceNotFoundException;
import com.blogging_durgesh.demo.Repositories.CommentsRepo;
import com.blogging_durgesh.demo.Repositories.PostsRepo;
import com.blogging_durgesh.demo.Repositories.UserRepo;
import com.blogging_durgesh.demo.Services.CommentsService;
import com.blogging_durgesh.demo.entities.Comments;
import com.blogging_durgesh.demo.entities.Posts;
import com.blogging_durgesh.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepo CommentRepo;

    @Autowired
    private PostsRepo Postrepo;

    @Autowired
    private UserRepo Userrepo;

    @Override
    public Comments CreateComment(Comments comment , int P_id , int User_id) {
        Posts p = this.Postrepo.findById(P_id).orElseThrow(()->new ResourceNotFoundException("COmment not found", "comment_id", P_id));
        User u  = this.Userrepo.findById(User_id).orElseThrow(()->new ResourceNotFoundException("COmment not found", "comment_id", User_id));
        comment.setUser(u);
        comment.setPost(p);
        this.CommentRepo.save(comment);
        return comment;
    }

    @Override
    public Comments UpdateComment(Comments comment, int C_id) {
        Comments c = this.CommentRepo.findById(C_id).orElseThrow(()->new ResourceNotFoundException("COmment not found", "comment_id", C_id));
        this.CommentRepo.deleteById(C_id);
        c.setMessage(comment.getMessage());
        this.CommentRepo.save(c);
        return c;
    }

    @Override
    public void DeleteComment(int C_id) {
       // Comments c = this.CommentRepo.findById(C_id).orElseThrow(()->new ResourceNotFoundException("COmment not found", "comment_id", C_id));
        this.CommentRepo.deleteById(C_id);
        return ;
    }
}
