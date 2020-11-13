package br.com.nalli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nalli.data.dto.PersonDTO;
import br.com.nalli.service.PersonService;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
	@Autowired
	private PersonService services;
    
    
	@GetMapping
    public List<PersonDTO> findAll() {
     
        return services.findAll();
    }	
	
    @GetMapping("/{id}")
    public PersonDTO findByid(@PathVariable("id") Long id) {
     
        return services.findById(id);
    }
    
    @PostMapping
    public PersonDTO create(@RequestBody PersonDTO person) {
     
        return services.crate(person);
    }
    
    @PutMapping
    public PersonDTO update(@RequestBody PersonDTO person) {
     
        return services.update(person);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {      
        services.delete(id);
        
        return ResponseEntity.ok().build();
    }
    
}
