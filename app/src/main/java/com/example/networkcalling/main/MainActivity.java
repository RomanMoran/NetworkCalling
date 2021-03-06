package com.example.networkcalling.main;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.networkcalling.ProfileActivity;
import com.example.networkcalling.adapter.EmployeesAdapter;
import com.example.networkcalling.databinding.ActivityMainBinding;
import com.example.networkcalling.model.Employee;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    public static final String EMPLOYEE_ID = "MainActivity.EMPLOYEE_ID";
    private ActivityMainBinding binding;
    private EmployeesAdapter adapter;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainPresenter(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter = new EmployeesAdapter();
        binding.rvEmployees.setAdapter(adapter);
        adapter.setOnItemClickListener(this::showConcreteEmployee);
        if (isNetworkConnected()) {
            presenter.getDataFromServer();
        } else {
            presenter.getDataFromDatabase();
        }
    }

    @Override
    public void showEmployees(List<Employee> employees) {
        adapter.setEmployeeList(employees);
    }


    @Override
    public void showConcreteEmployee(Employee employee) {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra(EMPLOYEE_ID, employee.getId());
        startActivity(intent);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

}