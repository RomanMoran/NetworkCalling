package com.example.networkcalling.main;

import com.example.networkcalling.model.Employee;
import com.example.networkcalling.model.EmployeesResponse;
import com.example.networkcalling.network.AppApiClient;
import com.example.networkcalling.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import toothpick.Toothpick;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    @Inject
    Repository repository;

    @Inject
    AppApiClient appApiClient;


    public MainPresenter(MainContract.View view) {
        Toothpick.inject(this, Toothpick.openScope("APP"));
        this.view = view;
    }

    @Override
    public void getDataFromServer() {
        appApiClient.getEmployees().enqueue(new Callback<EmployeesResponse>() {
            @Override
            public void onResponse(Call<EmployeesResponse> call, Response<EmployeesResponse> response) {
                EmployeesResponse employeesResponse = response.body();
                List<Employee> employeeList = employeesResponse.getEmployees();
                repository.deleteAllRows();
                for (Employee employee : employeeList) {
                    repository.insertEmployee(employee);
                }
                view.showEmployees(employeeList);
            }

            @Override
            public void onFailure(Call<EmployeesResponse> call, Throwable t) {
                view.showMessage(t.getMessage());
            }
        });
    }

    @Override
    public void getDataFromDatabase() {
        List<Employee> employees = repository.getEmployees();
        if (employees == null || employees.isEmpty()) {
            view.showMessage("База данных пуста");
        } else {
            view.showEmployees(employees);
        }
    }

}
