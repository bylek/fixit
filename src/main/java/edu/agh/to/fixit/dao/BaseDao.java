package edu.agh.to.fixit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
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

        Session session = currentSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(E entity) {
        Session session = currentSession();
        session.beginTransaction();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(E entity) {
        Session session = currentSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public E find(Long key) {
        Class<E> currentClass = (Class<E>)
                ((ParameterizedType)getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];

      return  (E)currentSession().get(currentClass,key);
    }

    @Override
    public List<E> getAll() {
        return null;
    }


}
