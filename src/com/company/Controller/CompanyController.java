package com.company.Controller;

import com.company.Repository.CrudRepository;
import com.company.domain.Company;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyController {

    private CrudRepository<Company> repository;

    public CompanyController(CrudRepository<Company> companyRepo){
        this.repository = companyRepo;
    }

    public Company findStudentById(Long companyId) throws Exception {
        try{
            return this.repository.findOne(companyId);
        }
        catch (Exception e){
            throw new Exception("Error");
        }
    }

    public List<Company> getFilteredCompany(){
        List<Company> companyList = (List<Company>) this.repository.findAll();
        return companyList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

}
