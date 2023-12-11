package com.blogging_durgesh.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="Comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int  C_id;

    private String message;

    @ManyToOne
    private Posts  post;

    @ManyToOne
    private User user;

}
