package com.nopparuj.first_springboot_app.controllers;

import com.nopparuj.first_springboot_app.entity.Person;
import com.nopparuj.first_springboot_app.repository.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouteController {
    private final PersonDAO dao;

    public RouteController(PersonDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/")
    public String display() {
        return "Hello Spring Boot";
    }

    @GetMapping("/about")
    public String about() {
        return "About me";
    }

    @GetMapping("/my-profile")
    public String myProfile() {
        return "I'm quite in love with Spring Boot";
    }

    @GetMapping("/person/{id}")
    public String getPerson(@PathVariable int id) {
        return getData(id).toString();
    }

    @GetMapping("/people")
    public String getPersonList() {
        List<Person> people = dao.getAll();
        StringBuilder sb = new StringBuilder();

        for (Person person : people) {
            sb.append(person.toString()).append("\n");
        }

        return sb.toString();
    }

    public Person getData(int id) {
        return dao.get(id);
    }
}
