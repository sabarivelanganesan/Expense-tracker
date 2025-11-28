package com.finqube.expense_service.Mapper;

import com.finqube.expense_service.DTO.ExpenseRequestDTO;
import com.finqube.expense_service.DTO.ExpenseResponseDTO;
import com.finqube.expense_service.Model.Category;
import com.finqube.expense_service.Model.Expense;

import java.time.LocalDate;

public class ExpenseMapper {

    public static ExpenseResponseDTO convertToDTO(Expense expense) {
        ExpenseResponseDTO expenseDTO = new ExpenseResponseDTO();
        expenseDTO.setExp_id(expense.getExp_id().toString());
        expenseDTO.setExp_name(expense.getExp_name());
        expenseDTO.setExp_amount(expense.getExp_amount().toString());
        expenseDTO.setExpenseDate(expense.getExpense_date().toString());
        expenseDTO.setExp_category_id(expense.getCategory().getCategory_id());
        expenseDTO.setExp_pay_method(expense.getPayment_method().toString());
        expenseDTO.setExp_notes(expense.getExp_notes().toString());

       return expenseDTO;
    }

    public static Expense convertToModel(ExpenseRequestDTO expenseRequestDTO, Category category) {
        Expense expense = new Expense();
//        expense.setExp_id(UUID.fromString(expenseDTO.getExp_id()));
        expense.setExp_name(expenseRequestDTO.getExp_name());
        expense.setExp_amount(Double.parseDouble(expenseRequestDTO.getExp_amount()));
        expense.setExpense_date(LocalDate.parse(expenseRequestDTO.getExpenseDate()));
        expense.setCategory(category);
        expense.setExp_notes(expenseRequestDTO.getExp_notes());
        expense.setPayment_method(expenseRequestDTO.getExp_pay_method());

        return expense;
    }
}
