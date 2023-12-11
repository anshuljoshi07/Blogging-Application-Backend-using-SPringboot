package com.blogging_durgesh.demo.Controller;


import com.blogging_durgesh.demo.Exceptions.ResourceNotFoundException;
import com.blogging_durgesh.demo.Services.CommentsService;
import com.blogging_durgesh.demo.entities.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/comments")
public class CommentCOntroller {

    @Autowired
    private CommentsService commentsService;



    @PostMapping (value="/user/{user_id}/post/{post_id}")
    public Comments CreateComment(@RequestBody Comments comment,@PathVariable int user_id, @PathVariable int post_id) {
        this.commentsService.CreateComment(comment, user_id, post_id);
        return comment;
    }

    @PostMapping(value="/{c_id}")
    public Comments UpdateComment(@RequestBody Comments comment,@PathVariable int c_id) {
        return  this.commentsService.UpdateComment(comment, c_id);

    }

    @DeleteMapping(value="/{C_id}")
    public void DeleteComment(int C_id) {
       this.commentsService.DeleteComment(C_id);


    }
}






