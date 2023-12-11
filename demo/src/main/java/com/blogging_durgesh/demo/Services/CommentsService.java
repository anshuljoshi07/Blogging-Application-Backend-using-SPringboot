package com.blogging_durgesh.demo.Services;

import com.blogging_durgesh.demo.entities.Comments;

public interface CommentsService {

   public Comments CreateComment(Comments comment,int P_id , int User_id);
    public Comments UpdateComment(Comments comment, int C_id);
   public void DeleteComment(int C_id);





}
