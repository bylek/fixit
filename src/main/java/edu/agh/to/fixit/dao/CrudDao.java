package edu.agh.to.fixit.dao;

import java.util.List;

/**
 * Created by mkuligowski on 03.05.16.
 */
public interface CrudDao<E> {


    void add(E entity);
    void update(E entity);
    void remove(E entity);
    E find(Long key);
    List<E> getAll();

}
