package ru.kenan.spring.RestApp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import ru.kenan.spring.RestApp.modals.Person;
import ru.kenan.spring.RestApp.services.PeopleService;
import ru.kenan.spring.RestApp.util.PeopleErrorResponse;
import ru.kenan.spring.RestApp.util.PersonNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PeopleController {
    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }
    @GetMapping()
    public List<Person> getPeople(){
        return peopleService.findAll();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id){
        return peopleService.findOne(id);

    }
    @ExceptionHandler
    private ResponseEntity<PeopleErrorResponse> handleException(PersonNotFoundException e){
        PeopleErrorResponse response = new PeopleErrorResponse(
                "Person with this id wasn't found",
                System.currentTimeMillis()
                );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
