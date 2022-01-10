package com.company.Controller;

import com.company.Repository.CompanyInFileRepo;
import com.company.domain.Company;

public class MainController {
    private CompanyController companyController;

    public MainController(CompanyInFileRepo companyController) {
        this.companyController = companyController;
    }


    public Iterable<Company> getSortedCompany(){
        return this.companyController.getSortedCompany();
    }
}
