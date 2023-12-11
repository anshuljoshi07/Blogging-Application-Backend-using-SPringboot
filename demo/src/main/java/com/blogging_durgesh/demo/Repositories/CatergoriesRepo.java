package com.blogging_durgesh.demo.Repositories;

import com.blogging_durgesh.demo.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatergoriesRepo extends JpaRepository<Categories, Integer> {
}
