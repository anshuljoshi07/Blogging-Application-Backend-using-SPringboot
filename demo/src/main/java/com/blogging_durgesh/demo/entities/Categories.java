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
@Table(name="Categories")
public class Categories {

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer Cat_id;

    private String Title;

    @OneToMany
   private List<Posts> posts;




}
