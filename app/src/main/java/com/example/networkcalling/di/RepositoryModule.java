package com.example.networkcalling.di;

import android.content.Context;

import com.example.networkcalling.repository.EmployeesRepository;
import com.example.networkcalling.repository.Repository;

import toothpick.config.Module;

public class RepositoryModule extends Module {

    public RepositoryModule() {
        //bind(Repository.class)/*.toInstance(new EmployeesRepository(context))*/;
        bind(Repository.class).to(EmployeesRepository.class).singleton();
    }

}
