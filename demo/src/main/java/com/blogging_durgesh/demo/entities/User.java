package com.blogging_durgesh.demo.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="User")
@NoArgsConstructor
@Getter
@Setter
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  id;
    private String name;
    private String email;
    private String password;
    private String about;

    @OneToMany
    private List<Comments> cmmts;

    @OneToMany
    private List<Posts> posts;



}
