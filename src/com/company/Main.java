package com.company;

import com.company.Controller.MainController;
import com.company.Repository.CompanyInFileRepo;
import com.company.view.RegistrationSystem;

public class Main {

    public static void main(String[] args) {
        CompanyInFileRepo companyRepo = new CompanyInFileRepo("D:\\University\\Info\\materii\\MAP\\ExamenLab2\\src\\com\\company\\RepoData\\offerten.txt");

        MainController mainController = new MainController(companyRepo);

        RegistrationSystem registrationSystem = new RegistrationSystem(mainController);
        registrationSystem.startApplication();
    }
}
