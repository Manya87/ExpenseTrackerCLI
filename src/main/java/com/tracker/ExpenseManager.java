package com.tracker;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class ExpenseManager {
    private List<Expense> expenses;
    private final String FILE_NAME = "expenses.dat";

    public ExpenseManager() {
        this.expenses = loadFromFile();
    }

    public void addExpense(Expense e) {
        expenses.add(e);
        saveToFile();
    }

    public List<Expense> getExpenses() { return expenses; }

    public BigDecimal calculateTotal() {
        return expenses.stream()
                       .map(Expense::getAmount)
                       .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(expenses);
        } catch (IOException e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private List<Expense> loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Expense>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}