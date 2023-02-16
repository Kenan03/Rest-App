package ru.kenan.spring.RestApp.repositores;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kenan.spring.RestApp.modals.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
