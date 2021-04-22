/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmvc.springmongodbweb.controllers;

import com.springmvc.springmongodbweb.models.Person;
import com.springmvc.springmongodbweb.repositories.PersonRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author didin
 */
@Controller
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/person")
    public String person(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        return "person";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        return "create";
    }

    @RequestMapping("/save")
    public String save(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String affiliation) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmail(email);
        person.setAffiliation(affiliation);
        personRepository.save(person);

        return "redirect:/show/" + person.getId();
    }

    @RequestMapping("/show/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("person", personRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String id) {
        Optional<Person> person = personRepository.findById(id);
        personRepository.delete(person.get());

        return "redirect:/person";
    }
    
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("person", personRepository.findById(id).get());
        return "edit";
    }
    
    @RequestMapping("/update")
    public String update(@RequestParam String id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String affiliation) {
        Optional<Person> person = personRepository.findById(id);
        person.get().setFirstName(firstName);
        person.get().setLastName(lastName);
        person.get().setEmail(email);
        person.get().setAffiliation(affiliation);
        personRepository.save(person.get());

        return "redirect:/show/" + person.get().getId();
    }
}
