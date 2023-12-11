package com.blogging_durgesh.demo.Controller;

import com.blogging_durgesh.demo.Exceptions.ResourceNotFoundException;
import com.blogging_durgesh.demo.Services.CategoriesService;
import com.blogging_durgesh.demo.entities.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="Categories")
public class CatController {

    @Autowired
    private CategoriesService CatService;


    @GetMapping(value="/")
    public List<Categories> GetAllCategories() {
        return this.CatService.GetAllCategories();
    }

    @PostMapping(value="/")
    public Categories CreateCategories(@RequestBody Categories Cat) {
        return this.CatService.CreateCategories(Cat);

    }

    @DeleteMapping (value="/{Cat_id}")
    public void DeleteCategories(int Cat_id) {
      this.CatService.DeleteCategories(Cat_id);
    }

    @PostMapping(value="/{Cat_id}")
    public Categories UpdateCategories(@PathVariable int Cat_id, @RequestBody Categories c) {

        return this.CatService.UpdateCategories(Cat_id, c);
    }

}
