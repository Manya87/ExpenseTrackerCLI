package com.tracker;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Expense implements Serializable {
    private static final long serialVersionUID = 1L;
    private LocalDate date;
    private String category;
    private BigDecimal amount;

    public Expense(LocalDate date, String category, BigDecimal amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    public BigDecimal getAmount() { return amount; }

    @Override
    public String toString() {
        return String.format("%s | %-12s | $%s", date, category, amount);
    }
}
