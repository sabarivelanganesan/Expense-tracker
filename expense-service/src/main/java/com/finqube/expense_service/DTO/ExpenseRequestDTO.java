package com.finqube.expense_service.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
@Schema(name = "Expense")
public class ExpenseRequestDTO {

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String exp_name;
    @NotBlank(message = "Expense amount is required")
    private String exp_amount;

    @NotBlank(message = "Expense Date is required")
    @Pattern(
            regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$",
            message = "Invalid date format. Expected a valid yyyy-MM-dd date."
    )
    private String expenseDate;

    @NotBlank(message = "Expense Category is required")
    private String Exp_category_id;

    @NotBlank(message = "Expense payment method is required")
    private String exp_pay_method;

    @NotBlank(message = "Expense notes is required")
    private String exp_notes;
}
