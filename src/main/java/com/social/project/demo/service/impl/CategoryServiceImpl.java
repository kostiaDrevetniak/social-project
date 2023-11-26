package com.social.project.demo.service.impl;

import com.social.project.demo.model.Category;
import com.social.project.demo.repository.CategoryRepository;
import com.social.project.demo.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        if (category == null)
            throw new IllegalArgumentException("Category cannot be 'null'");
        return categoryRepository.save(category);
    }

    @Override
    public Category readById(UUID id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Category with id " + id + " not found"));
    }

    @Override
    public Category update(Category category) {
        if (category == null)
            throw new IllegalArgumentException("Category cannot be 'null'");
        readById(category.getId());
        return categoryRepository.save(category);
    }

    @Override
    public void delete(UUID id) {
        Category category = readById(id);
        categoryRepository.delete(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
