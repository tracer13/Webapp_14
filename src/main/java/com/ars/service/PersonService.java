package com.ars.service;


import com.ars.model.Person;

import java.util.List;


public interface PersonService {

    boolean personVerification(String firstName, String lastName);

    void addNewPerson(String firstName, String lastName, int age);

    List<Person> getPersonList();
}
