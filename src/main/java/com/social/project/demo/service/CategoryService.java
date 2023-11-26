package com.social.project.demo.service;

import com.social.project.demo.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    Category create(Category category);
    Category readById(UUID id);
    Category update(Category category);
    void delete(UUID id);
    List<Category> getAll();
}
