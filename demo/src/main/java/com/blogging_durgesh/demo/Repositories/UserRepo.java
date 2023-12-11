package com.blogging_durgesh.demo.Repositories;

import com.blogging_durgesh.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
