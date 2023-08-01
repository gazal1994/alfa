package com.example.demo.dao;

import java.io.Serializable;
import java.util.List;

public interface CrudSupport<T> {
    Serializable save(T object);
    void delete(T object);
    void update(T object);
    T getObjectById(int id);


    List<T> getAllEntitiesFromDb();

}
