/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.desiderio.dev.casestudy;
import java.awt.HeadlessException;
import javax.swing.*;

/**
 *
 * @author Codehakai
 */

public class ECP02 {
    public static void main(String[] args) {
        ManageUsersECP02 manager = new ManageUsersECP02();
        
        // Menu system - no initial test data added
        while (true) {
            String menu = "==== Employee Management System ====\n" +
                       "1. Add New Employee\n" +
                       "2. Show All Employees\n" +
                       "3. Search by Name\n" +
                       "4. Calculate Average Salary\n" +
                       "5. Show Highest Paid Employee\n" +
                       "6. Show Lowest Paid Employee\n" +
                       "7. Run Test Cases\n" +
                       "8. Exit\n\n" +
                       "Enter your choice (1-8):";
            
            String choice = JOptionPane.showInputDialog(menu);
            
            if (choice == null || choice.equals("8")) {
                JOptionPane.showMessageDialog
                (null, "Exit Application...Byeeee...");
                break;
            }
            
            try {
                switch (choice) {
                    case "1" -> addNewEmployee(manager);
                    case "2" -> manager.displayAllEmployees();
                    case "3" -> searchEmployee(manager);
                    case "4" -> showAverageSalary(manager);
                    case "5" -> showHighestPaid(manager);
                    case "6" -> showLowestPaid(manager);
                    case "7" -> runTestCases();
                    default -> System.out.println("1-8 no other number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Just enter valid numbers 1 - 8 dude............");
            } catch (HeadlessException e) {
                System.out.println("An error occurred:");
                JOptionPane.showMessageDialog(null, 
                    "An error occurred: " + e.getMessage(),
                    "-_- ERROOORR -_- ", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private static void addNewEmployee(ManageUsersECP02 manager) {
        
        String name = JOptionPane.showInputDialog("Put employee name:");
        
        if (name == null || name.trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Put field cannot be empty!");
            
            return;
            
        }
        
        String ageStr = JOptionPane.showInputDialog("Put employee age:");
        
        int age = Integer.parseInt(ageStr);
        
        String department = JOptionPane.showInputDialog("Put department:");
        
        if (department == null || department.trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "This field cannot be empty!");
            
            return;
        }
        
        String salaryStr = JOptionPane.showInputDialog("Put salary:");
        
        double salary = Double.parseDouble(salaryStr);
        
        manager.addEmployee(new EmployeeECP02(name, age, department, salary));
    }
    
    private static void searchEmployee(ManageUsersECP02 manager) {
        
        String searchName = JOptionPane.showInputDialog("Put name to search:");
        
        if (searchName != null && !searchName.trim().isEmpty()) {
            
            manager.searchEmployeeByName(searchName);
            
        }
        
    }
    
    private static void showAverageSalary(ManageUsersECP02 manager) {
        double avg = manager.calculateAverageSalary();
        JOptionPane.showMessageDialog(null, 
            String.format("Average Salary: $%.2f", avg),
            "Average Salary", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private static void showHighestPaid(ManageUsersECP02 manager) {
        EmployeeECP02 highest = manager.getHighestPaidEmployee();
        if (highest != null) {
            JOptionPane.showMessageDialog(null, 
                "Highest Paid Employee:\n\n" + highest.toString(),
                "Highest Paid", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, 
                "No employees in system",
                "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private static void showLowestPaid(ManageUsersECP02 manager) {
        EmployeeECP02 lowest = manager.getLowestPaidEmployee();
        if (lowest != null) {
            JOptionPane.showMessageDialog(null, 
                "Lowest Paid Employee:\n\n" + lowest.toString(),
                "Lowest Paid", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, 
                "No employees in system",
                "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private static void runTestCases() {
        // Create temporary manager just for tests
        ManageUsersECP02 testManager = new ManageUsersECP02();
        
        // Add test employees
        testManager.addEmployee(new EmployeeECP02("Test User", 30, "IT", 4500.0));
        testManager.addEmployee(new EmployeeECP02("Test User", 28, "HR", 3800.0));
        testManager.addEmployee(new EmployeeECP02("Test User", 35, "Finance", 5200.0));
        
        JOptionPane.showMessageDialog(null, 
            "=== Starting Test Cases ===",
            "Test Mode", JOptionPane.INFORMATION_MESSAGE);
        
        // Test 1: Display all
        testManager.displayAllEmployees();
        
        // Test 2: Successful search
        testManager.searchEmployeeByName("Test User");
        
        // Test 3: Failed search
        testManager.searchEmployeeByName("Non Existing");
        
        // Test 4: Average salary
        double avg = testManager.calculateAverageSalary();
        JOptionPane.showMessageDialog(null,
            String.format("Test Average Salary: $%.2f", avg),
            "Test Result", JOptionPane.INFORMATION_MESSAGE);
        
        // Test 5: Highest paid
        EmployeeECP02 highest = testManager.getHighestPaidEmployee();
        JOptionPane.showMessageDialog(null,
            "Test Highest Paid:\n" + highest.toString(),
            "Test Result", JOptionPane.INFORMATION_MESSAGE);
        
        // Test 6: Lowest paid
        EmployeeECP02 lowest = testManager.getLowestPaidEmployee();
        JOptionPane.showMessageDialog(null,
            "Test Lowest Paid:\n" + lowest.toString(),
            "Test Result", JOptionPane.INFORMATION_MESSAGE);
        
        JOptionPane.showMessageDialog(null,
            "=== All Test Cases Completed ===",
            "Test Mode", JOptionPane.INFORMATION_MESSAGE);
    }
}