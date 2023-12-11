package com.blogging_durgesh.demo.Services.impl;

import com.blogging_durgesh.demo.Exceptions.ResourceNotFoundException;
import com.blogging_durgesh.demo.Repositories.CatergoriesRepo;
import com.blogging_durgesh.demo.Services.CategoriesService;
import com.blogging_durgesh.demo.entities.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatergoriesServiceImpl implements CategoriesService {

    @Autowired
    private CatergoriesRepo CatRepo;


    @Override
    public List<Categories> GetAllCategories() {
       return this.CatRepo.findAll();
    }

    @Override
    public Categories CreateCategories(Categories Cat) {
      //  int id = Cat.getCat_id();
        this.CatRepo.save(Cat);
        return Cat;
    }

    @Override
    public void DeleteCategories(int Cat_id) {
       Categories c =  this.CatRepo.findById(Cat_id).orElseThrow(() -> new ResourceNotFoundException("Category ", "category id", Cat_id));
        this.CatRepo.delete(c);
    }

    @Override
    public Categories UpdateCategories(int Cat_id, Categories c) {
        Categories cat =  this.CatRepo.findById(Cat_id).orElseThrow(() -> new ResourceNotFoundException("Category ", "category id", Cat_id));
       cat.setPosts(c.getPosts());
       cat.setTitle(c.getTitle());


        return cat;
    }
}
