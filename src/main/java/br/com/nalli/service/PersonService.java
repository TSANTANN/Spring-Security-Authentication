package br.com.nalli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nalli.converter.DozerConverter;
import br.com.nalli.data.model.Person;
import br.com.nalli.data.dto.PersonDTO;
import br.com.nalli.exception.ResourceNotFoundException;
import br.com.nalli.repository.PersonRepository;


@Service
public class PersonService {

	@Autowired
	PersonRepository repository;
	
	public PersonDTO crate(PersonDTO person) {
		Person entity = DozerConverter.parseObject(person, Person.class);
		PersonDTO vo = DozerConverter.parseObject(repository.save(entity), PersonDTO.class);
		return vo;
	}
	
	public List<PersonDTO> findAll() {
		
		return DozerConverter.parseListObjects(repository.findAll(), PersonDTO.class);
	}
	
	public PersonDTO findById(Long id) {
		
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID") );
		return DozerConverter.parseObject(entity, PersonDTO.class);
	}
		
	public PersonDTO update(PersonDTO person) {
		Person entity = repository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));		
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		PersonDTO vo = DozerConverter.parseObject(repository.save(entity), PersonDTO.class);
		return vo;		
		
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));	
		
		repository.delete(entity);
	}	
	
	
}
