package com.example.demo.dao;

import com.example.demo.application.DemoApplication;
import com.example.demo.application.config.ApplicationConfig;
import com.example.demo.application.config.DAOConfig;
import com.example.demo.models.companies.HumanResources;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest(classes = DemoApplication.class)
//@ContextConfiguration(classes = {ApplicationConfig.class})
//@SpringJUnitConfig

@Transactional
public class HumanResourcesDAOTest {
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    private CrudSupport<HumanResources> humanResourcesDAO;

    //@Test
    public void testGetAllEntitiesFromDb() {
        humanResourcesDAO.getAllEntitiesFromDb();
    }
    @Test
    public void testSave(){
        HumanResources obj1 = new HumanResources();
        obj1.setBusinessType(1);
        obj1.setName("ELiahu");
        obj1.setCompanyType(1);
        obj1.setYearsOfExperience(10);
        obj1.setIsActive(1);
        Serializable objId = humanResourcesDAO.save(obj1);
        Assert.assertNotNull(objId);
        List<HumanResources> result = humanResourcesDAO.getAllEntitiesFromDb();
       System.out.println("size = " + result.size());
    }
}