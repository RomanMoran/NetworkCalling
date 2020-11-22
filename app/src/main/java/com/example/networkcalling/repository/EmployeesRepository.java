package com.example.networkcalling.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.networkcalling.model.Employee;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class EmployeesRepository implements Repository {


    private final String EMPLOYEE_NAME = "employeeName";
    private final String EMPLOYEE_SALARY = "employeeSalary";
    private final String EMPLOYEE_AGE = "employeeAge";

    private DBHelper dbHelper;
    SQLiteDatabase db;

    @Inject
    public EmployeesRepository(Context context) {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    @Override
    public List<Employee> getEmployees() {
        Cursor cursor = db.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            ArrayList<Employee> employees = new ArrayList<>();
            int idColIndex = cursor.getColumnIndex("id");
            int employeeNameIndex = cursor.getColumnIndex("employeeName");
            int employeeSalaryIndex = cursor.getColumnIndex("employeeSalary");
            int employeeAgeIndex = cursor.getColumnIndex("employeeAge");
            do {
                /*  StringBuilder stringBuilder = new StringBuilder();*/
                long id = cursor.getLong(idColIndex);
                String employeeName = cursor.getString(employeeNameIndex);
                String employeeSalary = cursor.getString(employeeSalaryIndex);
                String employeeAge = cursor.getString(employeeAgeIndex);
                Employee employee = new Employee(id, employeeName, employeeSalary, employeeAge);
                employees.add(employee);
            } while (cursor.moveToNext());
            cursor.close();
            return employees;
        } else {
            return null;
        }
    }

    @Override
    public void deleteAllRows() {
        db.delete(DBHelper.TABLE_NAME, null, null);
    }

    @Override
    public void insertEmployee(Employee employee) {
        ContentValues cv = new ContentValues();
        cv.put(EMPLOYEE_NAME, employee.getEmployeeName());
        cv.put(EMPLOYEE_SALARY, employee.getEmployeeSalary());
        cv.put(EMPLOYEE_AGE, employee.getEmployeeAge());
        db.insert(DBHelper.TABLE_NAME, null, cv);
    }
}
