package com.art.artproject.controller;

import com.art.artproject.domain.TalentResponse;
import com.art.artproject.dto.CategoryResponse;
import com.art.artproject.dto.NewCategoryRequest;
import com.art.artproject.entity.Category;
import com.art.artproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @PostMapping
    public ResponseEntity<TalentResponse<CategoryResponse>> saveNewCategory(@RequestBody NewCategoryRequest request) {  // @RequestBody annotation is used to bind the parameter with the body of the HTTP request
        TalentResponse<CategoryResponse> talentResponse=
                new TalentResponse<>(categoryService.saveNewCategory(request),"Successfully created",HttpStatus.CREATED );
        return new ResponseEntity<>(talentResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Category> updateCategory(@RequestParam Long id,@RequestBody NewCategoryRequest request){
        Category result = categoryService.update(id,request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categoryList = categoryService.findAll();

        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCategory(@RequestParam Long id){
        categoryService.delete(id);

        return new ResponseEntity<>(" Deleted By Id " + id, HttpStatus.NO_CONTENT);
    }


}
