package com.tracker;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- EXPENSE TRACKER ---");
            System.out.println("1. Add Expense | 2. View All | 3. Exit");
            System.out.print("Select: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                System.out.print("Category: ");
                String cat = sc.nextLine();
                System.out.print("Amount: ");
                BigDecimal amt = new BigDecimal(sc.nextLine());
                manager.addExpense(new Expense(LocalDate.now(), cat, amt));
                System.out.println("Saved!");
            } else if (choice.equals("2")) {
                manager.getExpenses().forEach(System.out::println);
            } else if (choice.equals("3")) {
                System.out.println("Total Expenses: $" + manager.calculateTotal());
                break;
            }
        }
        sc.close();
    }
}