package edu.agh.to.fixit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseDao<E> implements CrudDao<E> {


    private SessionFactory sessionFactory;


    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    protected Session currentSession(){
        return sessionFactory.openSession();
    }


    @Override
    public void add(E entity){
        currentSession().save(entity);
    }

    @Override
    public void update(E entity) {
    }

    @Override
    public void remove(E entity) {
    }

    @Override
    public E find(Long key) {
        return null;
    }

    @Override
    public List<E> getAll() {
        return null;
    }


}
