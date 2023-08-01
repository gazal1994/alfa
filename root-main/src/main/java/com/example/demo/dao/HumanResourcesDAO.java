package com.example.demo.dao;

import com.example.demo.models.companies.HumanResources;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class HumanResourcesDAO implements BaseDAOSupport<HumanResources>{

    @Autowired
    private  SessionFactory sessionFactory;


    @Override
    public Class<HumanResources> getEntityType() {
        return HumanResources.class;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
