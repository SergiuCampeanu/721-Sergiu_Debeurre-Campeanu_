package com.company.Repository;

import com.company.domain.Company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CompanyInFileRepo implements CrudRepository<Company>{

    private String fileName;

    public CompanyInFileRepo(String fileName) {
        this.fileName = fileName;
    }

    /**
     *
     * @param id -the id of the entity to be returned id must not be null
     * @return a list of id
     * @throws Exception
     */
    public Company findOne(Long id) throws Exception {
        List<Company> companyList = new ArrayList<>();
        this.findAll().forEach(companyList::add);
        return companyList.stream().filter(course -> course.getId() == id).collect(Collectors.toList()).get(0);
    }

    /**
     * @return a list of entity
     */
    public Iterable<Company> findAll() throws Exception {
        File companyFile = new File(fileName);
        FileReader companyFileReader;
        try {
            companyFileReader = new FileReader(companyFile);
        } catch (Exception e) {
            throw new Exception("file not found");
        }

        BufferedReader companyBufferReader = new BufferedReader(companyFileReader);
        Scanner companyScanner = new Scanner(companyBufferReader);
        List<Company> companyList = new ArrayList<>();
        while (companyScanner.hasNextLine()) {
            String companyLine = companyScanner.nextLine();
            List<String> stringList = List.of(companyLine.split("&"));

            Company c1 = new Company(Long.parseLong(stringList.get(0)), stringList.get(1), Integer.parseInt(stringList.get(2)), Integer.parseInt(stringList.get(3)), stringList.get(4), stringList.get(5));
            companyList.add(c1);
        }
        return companyList;
    }

    /**
     * @param entity entity must be not null
     * @return the saved entity
     */
    public Company save(Company entity) throws Exception {
        File companyFile = new File(fileName);
        FileWriter companyFileWriter;
        try {
            companyFileWriter = new FileWriter(companyFile, true);
            BufferedWriter companyBufferWriter = new BufferedWriter(companyFileWriter);
            companyBufferWriter.write(entity.getId() + "&" + entity.getName() + "&" + entity.getPrice() + "&" + entity.getProcent() + "&" + entity.getAddress() + "&" + entity.getPlace() + "&" + "\n");
        } catch (Exception e) {
            throw new Exception("file not found");
        }
        return entity;
    }

}