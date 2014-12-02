package com.ars.service;

import com.ars.model.Person;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PersonServiceImpl implements PersonService{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean personVerification(String firstName, String lastName){
        boolean verificator;
        Query query = sessionFactory.getCurrentSession()
                .createSQLQuery("SELECT * FROM Person " +
                        "WHERE first_name = :firstName and last_name = :lastName");
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        if (query.list().isEmpty()){
            verificator = true;
        }else{
            verificator = false;
        }
        return verificator;
    }

    @Override
    public void addNewPerson(String firstName, String lastName, int age){
        Query query = sessionFactory.getCurrentSession()
                .createSQLQuery("INSERT INTO Person (FIRST_NAME, LAST_NAME, AGE)" +
                        "VALUES (:firstName, :lastName, :age)");
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        query.setParameter("age", age);
        query.executeUpdate();
    }

    @Override
    public List<Person> getPersonList() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Person").list();
    }
}
