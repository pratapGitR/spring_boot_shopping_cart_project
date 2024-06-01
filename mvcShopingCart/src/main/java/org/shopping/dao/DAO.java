package org.shopping.dao;

import java.util.List;

public interface DAO<T> {
    String save(T obj);
    List<T> list();

    T getById(Integer id);

}
