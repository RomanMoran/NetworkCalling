package com.example.networkcalling.repository;

import com.example.networkcalling.model.Employee;

import java.util.List;

public interface Repository {

    List<Employee> getEmployees();

    void deleteAllRows();

    void insertEmployee(Employee employee);
}
