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

import br.com.nalli.data.dto.BookDTO;
import br.com.nalli.service.BookService;


@RestController
@RequestMapping("/api/book/v1")
public class BookController {
	@Autowired
	private BookService services;
    
    
	@GetMapping
    public List<BookDTO> findAll() {
     
        return services.findAll();
    }	
	
    @GetMapping("/{id}")
    public BookDTO findByid(@PathVariable("id") Long id) {
     
        return services.findById(id);
    }
    
    @PostMapping
    public BookDTO create(@RequestBody BookDTO person) {
     
        return services.crate(person);
    }
    
    @PutMapping
    public BookDTO update(@RequestBody BookDTO person) {
     
        return services.update(person);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {      
        services.delete(id);
        
        return ResponseEntity.ok().build();
    }
    
}

