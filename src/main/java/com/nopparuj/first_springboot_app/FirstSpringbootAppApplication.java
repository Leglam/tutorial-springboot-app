package com.nopparuj.first_springboot_app;

import com.nopparuj.first_springboot_app.entity.Person;
import com.nopparuj.first_springboot_app.repository.PersonDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstSpringbootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringbootAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PersonDAO dao) {
		return runner->{
//			saveData(dao);
//			deleteData(dao);
			updateData(dao);
		};
	}

	public void saveData(PersonDAO dao) {
		Person obj1 = new Person("Nai", "Krirk");
		dao.save(obj1);
		System.out.println("Insert Completed");
	}

	public void deleteData(PersonDAO dao) {
		try {
			int id = 4;
			dao.delete(id);
			System.out.println("Delete Complete");
		} catch (Exception e) {
			System.out.println("Delete Incomplete: " + e);
		}
	}

	public void updateData(PersonDAO dao) {
		int id = 7;
		Person myPerson = dao.get(id);
		myPerson.setFname("Fluke");
		myPerson.setLname("Wary");
		dao.update(myPerson);
		System.out.println("Update Completed");
	}
}
