package com.finqube.expense_service.Controller;

import com.finqube.expense_service.DTO.ExpenseDTO;
import com.finqube.expense_service.DTO.ExpenseResponseDTO;
import com.finqube.expense_service.Service.CategoryService;
import com.finqube.expense_service.Service.ExpenseService;
import com.finqube.expense_service.Model.Category;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@Tag(name = "Expense details", description = "Manage Expense Details")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @Operation(summary = "Create new expense")
    public ResponseEntity<ExpenseResponseDTO> createExpense(@Valid @RequestBody ExpenseDTO expenseDTO) {
        Category category = categoryService.getCategoryByID(expenseDTO.getExp_category_id());
        ExpenseResponseDTO response =  expenseService.createExpense(expenseDTO, category);
        return ResponseEntity.status(201).body(response);
    }
    @GetMapping
    @Operation(summary = "Get all expenses")
    public ResponseEntity<List<ExpenseResponseDTO>> getExpenses() {
        List<ExpenseResponseDTO> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok().body(expenses);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get expense by ID")
    public ResponseEntity<ExpenseResponseDTO> getExpenseByID(@PathVariable("id") String expense_id) {
        ExpenseResponseDTO response = expenseService.getExpenseByID(expense_id);
        return ResponseEntity.ok().body(response);
    }

}
