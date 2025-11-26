package com.finqube.expense_service.Enum;

public enum ExpenseCategory {
    // These are temporary URL will update it in future
    FOOD("https://cdn.example.com/icons/food.png"),
    TRANSPORT("https://cdn.example.com/icons/transport.png"),
    ENTERTAINMENT("https://cdn.example.com/icons/entertainment.png"),
    GROCERIES("https://cdn.example.com/icons/groceries.png"),
    UTILITIES("https://cdn.example.com/icons/utilities.png"),
    HEALTHCARE("https://cdn.example.com/icons/healthcare.png"),
    EDUCATION("https://cdn.example.com/icons/education.png"),
    SHOPPING("https://cdn.example.com/icons/shopping.png"),
    SUBSCRIPTIONS("https://cdn.example.com/icons/subscriptions.png"),
    RENT("https://cdn.example.com/icons/rent.png"),
    EMERGENCY("https://cdn.example.com/icons/emergency.png"),
    TRAVEL("https://cdn.example.com/icons/travel.png"),
    GIFTS("https://cdn.example.com/icons/gifts.png"),
    INVESTMENT("https://cdn.example.com/icons/investment.png"),
    LOAN_PAYMENT("https://cdn.example.com/icons/loan_payment.png"),
    OTHER("https://cdn.example.com/icons/other.png");

    private final String iconUrl;

    ExpenseCategory(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

}
