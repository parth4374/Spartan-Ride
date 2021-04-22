/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springmvc.springmongodbweb.repositories;

import com.springmvc.springmongodbweb.models.Person;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author didin
 */
public interface PersonRepository extends CrudRepository<Person, String> {
    
}
