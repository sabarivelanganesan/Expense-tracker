package com.finqube.expense_service.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "Expense")
public class ExpenseDTO {
    @NotNull(message = "Expense amount is required")
    private String exp_amount;

    @NotNull(message = "Category Id is required")
    private Long exp_category_id;

    @NotNull(message = "Expense Date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String expenseDate;

    @NotNull(message = "Payment methods is required")
    private String exp_pay_method;

    private String exp_notes;
}
