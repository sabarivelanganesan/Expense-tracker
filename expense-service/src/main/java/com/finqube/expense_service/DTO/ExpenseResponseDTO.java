package com.finqube.expense_service.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@Schema(name = "Expense Response")
public class ExpenseResponseDTO {
    private String exp_id;
    private String exp_name;
    private String exp_amount;
    private Long exp_category_id;
    private String expenseDate;
    private String exp_pay_method;
    private String exp_notes;
}
