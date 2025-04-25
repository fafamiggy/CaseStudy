/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desiderio.dev.casestudy;

import javax.swing.*;

/**
 * This class manages a simple list of employees.
 * You can add, search, view, and analyze employee data.
 * 
 * Created by Codehakai
 */

public class ManageUsersECP02 {

    private final EmployeeECP02[] employees;
    private int employeeCount;

    // Constructor: Creates an empty list with space for 5 employees
    public ManageUsersECP02() {
        employees = new EmployeeECP02[5];
        employeeCount = 0;
    }

    // Adds a new employee to the system if there's space
    public void addEmployee(EmployeeECP02 newEmployee) {
        if (employeeCount < employees.length) {
            employees[employeeCount] = newEmployee;
            employeeCount++;
            JOptionPane.showMessageDialog(null, "🎉 Employee added successfully!");
        } else {
            JOptionPane.showMessageDialog(null,
                "⚠️ Sorry, you can't add more employees. The list is full.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Shows all employees currently stored
    public void displayAllEmployees() {
        if (employeeCount == 0) {
            JOptionPane.showMessageDialog
        (null, "There are no employees to show yet.");
            return;
        }

        StringBuilder allEmployees = 
        new StringBuilder("📋 All Employees:\n\n");
        
        for (int icount = 0; 
                 icount < employeeCount; 
                 icount++) 
        
        {
            allEmployees.append("👤 Employee ")
                        .append(icount + 1)
                        .append(":\n")
                    
                        .append(employees[icount].toString())
                        .append("\n\n");
        }

        JOptionPane.showMessageDialog
        (null, allEmployees.toString());
    }

    // Upper and lower case-insensitive avoid error
    public void searchEmployeeByName(String searchName) {
        StringBuilder results = new StringBuilder();

        for (int ecount = 0; ecount 
                < employeeCount; ecount++) 
        {
            if (employees[ecount].getName().equalsIgnoreCase(searchName)) 
            
            {
                
                results.append(employees[ecount].toString()).append("\n\n");
            }
        }

        if (results.length() > 0) 
        {
            JOptionPane.showMessageDialog(null, "🔍 -Total Search Results-:\n\n" 
            + results.toString());
        } 
        
        else 
        
        {
            JOptionPane.showMessageDialog(null,
                "😕 Sorry, no employee found with the name: " 
                + searchName,
                "Not Found", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Calculates the average salary of all employees
    public double calculateAverageSalary() {
        if (employeeCount == 0) return 0.0;

        double totalSalary = 0;
        for (int esalary = 0; 
                 esalary < employeeCount; 
                 esalary++) 
        {
            
            totalSalary += employees[esalary].getSalary();
            
        }

        return totalSalary / employeeCount;
    }

    // Finds and returns the employee with the highest salary
    public EmployeeECP02 getHighestPaidEmployee() {
        if (employeeCount == 0) return null;

        EmployeeECP02 highestPaid = employees[0];
        for (int hpaid = 1; hpaid < employeeCount; hpaid++) {
            if (employees[hpaid].getSalary() > highestPaid.getSalary()) {
                highestPaid = employees[hpaid];
            }
        }

        return highestPaid;
    }

    // Finds and returns the employee with the lowest salary
    public EmployeeECP02 getLowestPaidEmployee() {
        if (employeeCount == 0) return null;

        EmployeeECP02 lowestPaid = employees[0];
        for (int empcount = 1; 
                 empcount < employeeCount; 
                 empcount++) 
        {
            if (employees[empcount].getSalary() 
                       < lowestPaid.getSalary()) 
            {
                lowestPaid = employees[empcount];
            }
        }

        return lowestPaid;
    }
}
