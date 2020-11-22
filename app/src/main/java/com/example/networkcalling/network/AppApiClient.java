package com.example.networkcalling.network;

import com.example.networkcalling.model.EmployeeResponse;
import com.example.networkcalling.model.EmployeesResponse;

import javax.inject.Inject;

import retrofit2.Call;
import toothpick.InjectConstructor;

public class AppApiClient {

    @Inject
    ApiService serviceGenerator;

    public Call<EmployeesResponse> getEmployees() {
        return serviceGenerator
                .getEmployees();
    }

    public Call<EmployeeResponse> getEmployee(long id) {
        return serviceGenerator
                .getEmployee(id);
    }

}
