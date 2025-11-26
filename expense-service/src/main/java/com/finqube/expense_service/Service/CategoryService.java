package com.finqube.expense_service.Service;

import com.finqube.expense_service.Repository.CategoryRepository;
import com.finqube.expense_service.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category getCategoryByID(Long category_id) {
        return categoryRepository.findById(category_id).orElseThrow(() -> new RuntimeException("Category not found"));
    }
}
