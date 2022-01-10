package com.company;

import com.company.Controller.CompanyController;
import com.company.Controller.MainController;
import com.company.Repository.CompanyInFileRepo;
import com.company.Repository.CrudRepository;
import com.company.domain.Company;

public class Main {

    public static void main(String[] args) {
        CrudRepository<Company> CompanyRepo = (CrudRepository<Company>) new CompanyInFileRepo("D:\\University\\Info\\materii\\MAP\\ExamenLab2\\src\\com\\company\\RepoData\\offerten.txt");

        MainController mainController = new MainController(CompanyController());

        RegistrationSystem registrationSystem = new RegistrationSystem(mainController);
        registrationSystem.startApplication();
    }
}
