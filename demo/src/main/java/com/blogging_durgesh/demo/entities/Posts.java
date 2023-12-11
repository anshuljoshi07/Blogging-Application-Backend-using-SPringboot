package com.blogging_durgesh.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="Posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  P_id;

    @OneToMany
    private List<Comments> comments;

   @ManyToOne
   private User user;

    @ManyToOne
    private  Categories categories;

    private String message;

}
