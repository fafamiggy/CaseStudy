/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desiderio.dev.casestudy;
import javax.swing.*;
/**
 *
 * @author Codehakai
 */

public class EmployeeECP02 {

    private String name ;
    private int age ;
    private String department ;
    private double salary ;

    // Constructor to initialize an employee object
    public EmployeeECP02(String name, int age, String department, double salary) {
        this.name = name ;
        this.age = age ;
        this.department = department ;
        this.salary = salary ;
    }

    // Getters and setters
    public String 
        getName() {
        return name ;
    }

    public void 
        setName(String name) {
        this.name = name ;
    }

    public int 
        getAge() {
        return age ;
    }

    public void 
        setAge(int age) {
        this.age = age ;
    }

    public String 
        getDepartment() {
        return department ;
    }

    public void 
        setDepartment(String department) {
        this.department = department ;
    }

    public double 
        getSalary() {
        return salary ;
    }

    public void 
        setSalary(double salary) {
        this.salary = salary ;
    }

    // Display employee details in a readable format
    @Override
    public String toString() {
        return String.format(
            "👤 Employee Profile\n" +
            "------------------------\n" +
            "Name       : %s\n" +
            "Age        : %d\n" +
            "Department : %s\n" +
            "Salary     : $%.2f",
            name, age, department, salary
        ) ;
    }
}
