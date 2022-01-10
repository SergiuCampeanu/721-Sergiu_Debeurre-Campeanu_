package com.company.Controller;

import com.company.Repository.CompanyInFileRepo;
import com.company.domain.Company;

public class MainController {
    private CompanyController companyController;

    public MainController(CompanyController companyController) {
        this.companyController = companyController;
    }


    public Iterable<Company> getSortedCompany() throws Exception {
        return this.companyController.getSortedCompany();
    }
}
