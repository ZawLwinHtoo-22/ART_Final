package com.art.artproject.service;

import com.art.artproject.dto.CategoryResponse;
import com.art.artproject.dto.NewCategoryRequest;
import com.art.artproject.entity.Category;

import java.util.List;

public interface CategoryService {

    CategoryResponse saveNewCategory(NewCategoryRequest name);

    List<Category> findAll();

    void delete(Long id);

    public Category update(Long id,NewCategoryRequest request);
}
