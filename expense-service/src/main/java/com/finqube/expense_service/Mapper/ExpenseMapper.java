package com.finqube.expense_service.Mapper;

import com.finqube.expense_service.DTO.ExpenseDTO;
import com.finqube.expense_service.DTO.ExpenseResponseDTO;
import com.finqube.expense_service.Model.Category;
import com.finqube.expense_service.Model.Expense;

import java.time.LocalDate;

public class ExpenseMapper {

    public static ExpenseResponseDTO convertToDTO(Expense expense) {
        ExpenseResponseDTO expenseDTO = new ExpenseResponseDTO();
        expenseDTO.setExp_id(expense.getExp_id().toString());
        expenseDTO.setExp_amount(expense.getExp_amount().toString());
        expenseDTO.setExpenseDate(expense.getExpense_date().toString());
        expenseDTO.setExp_category_id(expense.getCategory().getCategory_id());
        expenseDTO.setExp_pay_method(expense.getPayment_method().toString());
        expenseDTO.setExp_notes(expense.getExp_notes().toString());

       return expenseDTO;
    }

    public static Expense convertToModel(ExpenseDTO expenseDTO, Category category) {
        Expense expense = new Expense();
//        expense.setExp_id(UUID.fromString(expenseDTO.getExp_id()));
        expense.setExp_amount(Double.parseDouble(expenseDTO.getExp_amount()));
        expense.setExpense_date(LocalDate.parse(expenseDTO.getExpenseDate()));
        expense.setCategory(category);
        expense.setExp_notes(expenseDTO.getExp_notes());
        expense.setPayment_method(expenseDTO.getExp_pay_method());

        return expense;
    }
}
