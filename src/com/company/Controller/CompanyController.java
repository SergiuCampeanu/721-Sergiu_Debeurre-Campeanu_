package com.company.Controller;

import com.company.Repository.CrudRepository;
import com.company.domain.Company;

import java.util.List;

public class CompanyController {

    private CrudRepository<Company> repository;

    public CompanyController(CrudRepository<Company> companyRepo){
        this.repository = companyRepo;
    }


    /**
     *
     * @param companyId id of the student
     * @return the student with the same id
     */
    public Company findStudentById(Long companyId) throws Exception {
        try{
            return this.repository.findOne(companyId);
        }
        catch (Exception e){
            throw new Exception("Error");
        }
    }

    /**
     *
     * @param maxCredit maximum number of credits that a student can have
     * @return the filtered list of student
     */
    public List<Company> getFilteredCompany(int maxCredit){
        List<Company> companyList = (List<Company>) this.repository.findAll();
        return companyList.stream().filter(s1->s1.getTotalCredit()<maxCredit).toList();
    }

}
