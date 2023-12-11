package com.blogging_durgesh.demo.Services;

import com.blogging_durgesh.demo.entities.Categories;

import java.util.List;

public interface CategoriesService {

    public List<Categories> GetAllCategories();
    public Categories CreateCategories(Categories Cat);
    public void DeleteCategories(int Cat_id);
    public Categories UpdateCategories(int Cat_id, Categories c);

}
