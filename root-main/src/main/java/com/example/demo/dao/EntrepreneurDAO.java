package com.example.demo.dao;

import com.example.demo.models.human_resources_independent.Entrepreneur;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
    public class EntrepreneurDAO implements BaseDAOSupport<Entrepreneur>{
        @Autowired
        private SessionFactory sessionFactory;
        @Override
        public Class<Entrepreneur> getEntityType() {
            return Entrepreneur.class;
        }

        @Override
        public SessionFactory getSessionFactory() {
            return sessionFactory;
        }
    }
