package com.finqube.expense_service.Service;

import com.finqube.expense_service.DTO.ExpenseRequestDTO;
import com.finqube.expense_service.DTO.ExpenseResponseDTO;
import com.finqube.expense_service.Mapper.ExpenseMapper;
import com.finqube.expense_service.Repository.CategoryRepository;
import com.finqube.expense_service.Repository.ExpenseRepository;
import com.finqube.expense_service.Model.Category;
import com.finqube.expense_service.Model.Expense;
import com.finqube.expense_service.exception.ExpenseIDNotFoundException;
import com.finqube.expense_service.exception.ExpenseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<ExpenseResponseDTO> getExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream().map(ExpenseMapper::convertToDTO).toList();
    }

    public ExpenseResponseDTO createExpense(ExpenseRequestDTO expenseRequestDTO, Category category) {

        Expense expense = expenseRepository.save(ExpenseMapper.convertToModel(expenseRequestDTO, category));
        return ExpenseMapper.convertToDTO(expense);
    }

    public ExpenseResponseDTO getExpenseByID(String expenseId) {
        if (expenseRepository.findAll().isEmpty()) {
            throw new ExpenseNotFoundException("No expense found. Please create one to get started.");
        }
        Expense expense = expenseRepository.findById(UUID.fromString(expenseId)).orElseThrow(() -> new ExpenseIDNotFoundException(
                "No expense found with ID "+ expenseId
        ));
        return ExpenseMapper.convertToDTO(expense);
    }

    public ExpenseResponseDTO updateExpenseByID(String expenseId, ExpenseRequestDTO expenseRequestDTO, Category category) {
//        if (expenseRepository.existsById(UUID.fromString(expenseId))) {
//            throw new ExpenseNotFoundException("No expense found. Please create one to get started.");
//        }
        Expense expense = expenseRepository.findById(UUID.fromString(expenseId)).orElseThrow(() -> new ExpenseIDNotFoundException("No expense found with ID" + expenseId));

        expense.setExp_name(expenseRequestDTO.getExp_name());
        expense.setExp_amount(Double.parseDouble(expenseRequestDTO.getExp_amount()));
        expense.setExpense_date(LocalDate.parse(expenseRequestDTO.getExpenseDate()));
        expense.setExp_notes(expenseRequestDTO.getExp_notes());
        expense.setCategory(category);
        expense.setPayment_method(expenseRequestDTO.getExp_pay_method());

        Expense updateExpense = expenseRepository.save(expense);

        return ExpenseMapper.convertToDTO(updateExpense);
    }

    public Map<String, String> deleteExpense(String expenseId) {
        Expense expense = expenseRepository.findById(UUID.fromString(expenseId)).orElseThrow(() -> new ExpenseIDNotFoundException("No expense found with ID" + expenseId));
        expenseRepository.delete(expense);
        Map<String, String> deletedMessage = new HashMap<>()
;
        deletedMessage.put("message", "The expense has been deleted");
        return deletedMessage;
    }
}
