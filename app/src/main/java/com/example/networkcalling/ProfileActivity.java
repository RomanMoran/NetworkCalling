package com.example.networkcalling;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.networkcalling.databinding.ActivityProfileBinding;
import com.example.networkcalling.main.MainActivity;
import com.example.networkcalling.model.Employee;
import com.example.networkcalling.model.EmployeeResponse;
import com.example.networkcalling.network.AppApiClient;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {



    @Inject
    AppApiClient appApiClient;

    private ActivityProfileBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            long id = extras.getLong(MainActivity.EMPLOYEE_ID);
            getEmployeeData(id);

        }
    }

    private void getEmployeeData(long id) {
        appApiClient.getEmployee(id).enqueue(new Callback<EmployeeResponse>() {
            @Override
            public void onResponse(Call<EmployeeResponse> call, Response<EmployeeResponse> response) {
                EmployeeResponse employeeResponse = response.body();
                showEmployeeProfile(employeeResponse.getEmployee());
            }

            @Override
            public void onFailure(Call<EmployeeResponse> call, Throwable t) {

            }
        });
    }

    private void showEmployeeProfile(Employee employee) {
        binding.tvName.setText(employee.getEmployeeName());
        binding.tvSalary.setText(employee.getEmployeeSalary());
        binding.tvAge.setText(employee.getEmployeeAge());
        // visibility flags
        // VISIBLE - view видимо
        // INVISIBLE - view не видимо, но контент остается на макете
        // GONE - view не видимо, контент исчезает из макета

        binding.progressView.setVisibility(View.GONE);
    }

}
