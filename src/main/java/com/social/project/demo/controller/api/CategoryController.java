package com.social.project.demo.controller.api;

import com.social.project.demo.model.Category;
import com.social.project.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable UUID id) {
        return categoryService.readById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        categoryService.delete(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Category category) {
        System.out.println(category);
        Category created = categoryService.create(category);
        return ResponseEntity.created(URI.create("/api/category/" + created.getId())).build();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable UUID id, @RequestBody Category category) {
        category.setId(id);
        categoryService.update(category);
    }
}
