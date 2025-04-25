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

public class EmployeeECP02 {
    private String name;
    private int age;
    private String department;
    private double salary;
    
    public EmployeeECP02(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    
    @Override
    public String toString() {
        return String.format("Name: %s\nAge: %d\nDepartment: %s\nSalary: $%.2f", 
                           name, age, department, salary);
    }
}