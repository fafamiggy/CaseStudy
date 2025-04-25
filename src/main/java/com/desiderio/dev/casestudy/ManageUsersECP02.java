/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desiderio.dev.casestudy;
import javax.swing.JOptionPane;


/**
 *
 * @author Codehakai
 */

public class ManageUsersECP02 {
    private EmployeeECP02[] employees;
    private int employeeCount;

    public ManageUsersECP02() {
        employees = new EmployeeECP02[5];
        employeeCount = 0;
    }

    public void addEmployee(EmployeeECP02 newEmployee) {
        if (employeeCount < employees.length) {
            employees[employeeCount] = newEmployee;
            employeeCount++;
            JOptionPane.showMessageDialog(null, "Employee added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Cannot add more employees. Array is full.", 
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void displayAllEmployees() {
        if (employeeCount == 0) {
            JOptionPane.showMessageDialog(null, "No employees in the system.");
            return;
        }

        String allEmployees = "=== All Employees ===\n\n";
        for (int eachEmployee = 0; eachEmployee < employeeCount; eachEmployee++) {
            allEmployees += "Employee " + (eachEmployee + 1) + ":\n" + employees[eachEmployee].toString() + "\n\n";
        }
        JOptionPane.showMessageDialog(null, allEmployees);
    }

    public void searchEmployeeByName(String searchName) {
        String results = "";
        for (int eachEmployee = 0; eachEmployee < employeeCount; eachEmployee++) {
            if (employees[eachEmployee].getName().equalsIgnoreCase(searchName)) {
                results += employees[eachEmployee].toString() + "\n\n";
            }
        }

        if (!results.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Search Results:\n\n" + results);
        } else {
            JOptionPane.showMessageDialog(null, "No employee found with name: " + searchName,
                                          "Not Found", JOptionPane.WARNING_MESSAGE);
        }
    }

    public double calculateAverageSalary() {
        if (employeeCount == 0) return 0.0;

        double totalSalary = 0;
        for (int eachEmployee = 0; eachEmployee < employeeCount; eachEmployee++) {
            totalSalary += employees[eachEmployee].getSalary();
        }
        return totalSalary / employeeCount;
    }

    public EmployeeECP02 getHighestPaidEmployee() {
        if (employeeCount == 0) return null;

        EmployeeECP02 highestPaid = employees[0];
        for (int eachEmployee = 1; eachEmployee < employeeCount; eachEmployee++) {
            if (employees[eachEmployee].getSalary() > highestPaid.getSalary()) {
                highestPaid = employees[eachEmployee];
            }
        }
        return highestPaid;
    }

    public EmployeeECP02 getLowestPaidEmployee() {
        if (employeeCount == 0) return null;

        EmployeeECP02 lowestPaid = employees[0];
        for (int eachEmployee = 1; eachEmployee < employeeCount; eachEmployee++) {
            if (employees[eachEmployee].getSalary() < lowestPaid.getSalary()) {
                lowestPaid = employees[eachEmployee];
            }
        }
        return lowestPaid;
    }
}