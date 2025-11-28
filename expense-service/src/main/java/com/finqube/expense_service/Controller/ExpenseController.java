package com.finqube.expense_service.Controller;

import com.finqube.expense_service.DTO.ExpenseRequestDTO;
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
import java.util.Map;

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
    public ResponseEntity<ExpenseResponseDTO> createExpense(@Valid @RequestBody ExpenseRequestDTO expenseRequestDTO) {
        Category category = categoryService.getCategoryByID(Long.parseLong(expenseRequestDTO.getExp_category_id()));
        ExpenseResponseDTO response =  expenseService.createExpense(expenseRequestDTO, category);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping
    @Operation(summary = "Get all expenses")
    public ResponseEntity<List<ExpenseResponseDTO>> getExpenses() {
        List<ExpenseResponseDTO> expenses = expenseService.getExpenses();
        return ResponseEntity.ok().body(expenses);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get expense by ID")
    public ResponseEntity<ExpenseResponseDTO> getExpenseByID(@PathVariable("id") String expense_id) {
        ExpenseResponseDTO response = expenseService.getExpenseByID(expense_id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update expense")
    public ResponseEntity<ExpenseResponseDTO> updateExpenseByID(@PathVariable("id") String expense_id, @Valid @RequestBody ExpenseRequestDTO expenseRequestDTO) {
        Category category = categoryService.getCategoryByID(Long.parseLong(expenseRequestDTO.getExp_category_id()));

        ExpenseResponseDTO expenseResponseDTO = expenseService.updateExpenseByID(expense_id, expenseRequestDTO, category);

        return ResponseEntity.ok().body(expenseResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete expense")
    public ResponseEntity<Map<String, String>> deleteExpense(@PathVariable("id") String expense_id) {
        return ResponseEntity.ok().body(expenseService.deleteExpense(expense_id));
    }

}
