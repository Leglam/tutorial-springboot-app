package com.nopparuj.first_springboot_app.repository;

import com.nopparuj.first_springboot_app.entity.Person;

import java.util.List;

public interface PersonDAO {
    void save(Person person);
    void delete(Integer id);
    Person get(Integer id);
    List<Person> getAll();
    void update(Person person);
}
