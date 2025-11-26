package com.finqube.expense_service.Service;

import com.finqube.expense_service.DTO.ExpenseDTO;
import com.finqube.expense_service.DTO.ExpenseResponseDTO;
import com.finqube.expense_service.Mapper.ExpenseMapper;
import com.finqube.expense_service.Repository.CategoryRepository;
import com.finqube.expense_service.Repository.ExpenseRepository;
import com.finqube.expense_service.Model.Category;
import com.finqube.expense_service.Model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<ExpenseResponseDTO> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream().map(ExpenseMapper::convertToDTO).toList();
    }

    public ExpenseResponseDTO createExpense(ExpenseDTO expenseDTO, Category category) {
        Expense expense = expenseRepository.save(ExpenseMapper.convertToModel(expenseDTO, category));
        return ExpenseMapper.convertToDTO(expense);
    }

    public ExpenseResponseDTO getExpenseByID(String expenseId) {
        Expense expense = expenseRepository.findById(UUID.fromString(expenseId)).orElseThrow(() -> new RuntimeException("Expense not Found"));
        return ExpenseMapper.convertToDTO(expense);
    }
}
