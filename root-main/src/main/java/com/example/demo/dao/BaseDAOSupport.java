package com.example.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

//@Log4j2
public interface BaseDAOSupport<ST extends Serializable> extends CrudSupport<ST> {

    //Logger
    Logger log = LoggerFactory.getLogger(BaseDAOSupport.class);
    //@Autowired
    //
    Class<ST> getEntityType();
    SessionFactory getSessionFactory();


    @PostConstruct
    public default void init(){
        System.out.println("sessionFactory"  + getSessionFactory().getClass());
    }


    @Override
    public  default Serializable save(ST object) {
        try {
            Session session = getCurrentSession();
            return session.save(object);
        } catch (Exception e) {
            log.error("Error occurred while saving " + object, e);
            return null;
        }
    }

    @Override
    public  default  void delete(ST object) {
        try {
            Session session = getCurrentSession();
            session.delete(object);

        } catch (Exception e) {
            log.error("Error occurred while deleting " + object, e);
        }
    }

    @Override
    public  default  void update(ST object) {
        try {
            Session session = getCurrentSession();

            session.update(object);

        } catch (Exception e) {
            log.error("Error occurred while updating " + object, e);
        }
    }



    @Override
    public default ST getObjectById(int id) {
        Class<ST>  entityType = getEntityType();
        try {
            Session session = getCurrentSession();


            ST result =  session.get(entityType, id);

            return result;
        } catch (Exception e) {
            log.error("Error occurred while getting " + entityType, e);
            return null;
        }

    }


    @Override
    public default List<ST> getAllEntitiesFromDb() {
        try {
            return  (List<ST>)getCurrentSession().createQuery("SELECT a FROM " + getEntityType().getClass().getName() +" a").list();

        } catch (Exception e) {
            log.error("Error occurred while getting all " + getEntityType().getClass().getName(), e);
            return null;
        }
    }
    public default Session getCurrentSession(){
        return getSessionFactory().getCurrentSession();
    }
}
