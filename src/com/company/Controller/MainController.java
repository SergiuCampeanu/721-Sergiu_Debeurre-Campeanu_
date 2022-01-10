package com.company.Controller;

import com.company.domain.Company;

public class MainController {
    private CompanyController companyController;

    public MainController(CompanyController companyController) {
        this.companyController = companyController;
    }

    /**
     *
     * @return company sorted by price
     * @throws Exception
     */
    public Iterable<Company> getSortedCompany() throws Exception {
        return this.companyController.getSortedCompany();
    }

    public String getTopPlace() throws Exception {
        return this.companyController.getTopPlace();
    }
}
