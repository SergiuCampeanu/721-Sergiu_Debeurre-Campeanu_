package com.company.Controller;

import com.company.Repository.CrudRepository;
import com.company.domain.Company;
import com.company.domain.Place;

import java.util.*;
import java.util.stream.Collectors;

public class CompanyController {

    private CrudRepository<Company> repository;

    public CompanyController(CrudRepository<Company> companyRepo){
        this.repository = companyRepo;
    }

    /**
     *
     * @param companyId id of the company
     * @return a company Id
     * @throws Exception
     */
    public Company findCompanyById(Long companyId) throws Exception {
        try{
            return this.repository.findOne(companyId);
        }
        catch (Exception e){
            throw new Exception("Error");
        }
    }

    /**
     *
     * @return company sorted by price
     * @throws Exception
     */
    public List<Company> getSortedCompany() throws Exception {
        List<Company> companyList = (List<Company>) this.repository.findAll();

        return companyList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

    /**
     *
     * @return a map cu frecventa si orasul
     * @throws Exception
     * nu am mai apucat sa fac
     */
    public String getTopPlace() throws Exception {
        List<Company> companyList = (List<Company>) this.repository.findAll();

        Map.Entry<Place, Integer> topPlace = companyList.stream().sorted(Comparator.comparing())
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(NullPointerException::new);

        return topPlace.getKey() + ":" + topPlace.getValue();
    }


}
