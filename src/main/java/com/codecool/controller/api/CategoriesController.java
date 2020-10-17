package com.codecool.controller.api;

import com.codecool.model.Category;
import com.codecool.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoriesController {

    private CategoryService categoryService;

    public CategoriesController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseBody
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
