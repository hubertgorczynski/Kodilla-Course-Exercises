package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyEmployeeSearchFacadeTestSuite {

    @Autowired
    private CompanyEmployeeSearchFacade companyEmployeeSearchFacade;
    @Autowired
    private CompanyDao companyDao;

    private final ArrayList<Company> resultCompanyList = new ArrayList<>();
    private final ArrayList<Employee> resultEmployeeList = new ArrayList<>();

    private Employee johnSmith;
    private Employee stephanieClarckson;
    private Employee lindaSmith;
    private Company softwareMachine;
    private Company softDataMasters;
    private Company greyMatter;

    @Before
    public void prepareData() {
        johnSmith = new Employee("John", "Smith");
        stephanieClarckson = new Employee("Stephanie", "Clarckson");
        lindaSmith = new Employee("Linda", "Smith");

        softwareMachine = new Company("Software Machine");
        softDataMasters = new Company("Soft Data Masters");
        greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        softDataMasters.getEmployees().add(stephanieClarckson);
        softDataMasters.getEmployees().add(lindaSmith);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaSmith);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(softDataMasters);
        lindaSmith.getCompanies().add(softDataMasters);
        lindaSmith.getCompanies().add(greyMatter);

        companyDao.save(softwareMachine);
        companyDao.save(softDataMasters);
        companyDao.save(greyMatter);
    }

    @After
    public void cleanUp() {
        try {
            companyDao.delete(softwareMachine);
            companyDao.delete(softDataMasters);
            companyDao.delete(greyMatter);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void retrieveCompanyLikeTest() {
        //Given
        resultCompanyList.add(softwareMachine);
        resultCompanyList.add(softDataMasters);

        //When
        List<Company> queryResult = companyEmployeeSearchFacade.retrieveCompanyLike("oft");

        //Then
        Assert.assertEquals(resultCompanyList.size(), queryResult.size());
    }

    @Test
    public void retrieveEmployeeLikeTest() {
        //Given
        resultEmployeeList.add(johnSmith);
        resultEmployeeList.add(lindaSmith);

        //When
        List<Employee> queryResult = companyEmployeeSearchFacade.retrieveEmployeeLike("mit");

        //Then
        Assert.assertEquals(resultEmployeeList.size(), queryResult.size());
    }
}
