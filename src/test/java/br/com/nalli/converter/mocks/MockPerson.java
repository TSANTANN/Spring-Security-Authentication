package br.com.nalli.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.nalli.data.model.Person;
import br.com.nalli.data.dto.PersonDTO;

public class MockPerson {
	
	public Person mockEntity() {
		return mockEntity(0);
	}

	public PersonDTO mockVO() {
		return mockVO(0);
	}
	
	public List<Person> mockEntityList(){
		
		List<Person> persons = new ArrayList<Person>();
		
		for (int i = 0; i<14; i++) {
			persons.add(mockEntity(i));
		}
		
		return persons;
	}

	public List<PersonDTO> mockVOList(){
		
		List<PersonDTO> persons = new ArrayList<PersonDTO>();
		
		for (int i = 0; i<14; i++) {
			persons.add(mockVO(i));
		}
		
		return persons;
	}
	
	private Person mockEntity(Integer number) {
		
		Person person = new Person();
		
		person.setAddress("Address Test" + number);
		person.setFirstName("First Name Test" + number);
		person.setLastName("Last Name Test" + number);
		person.setGender((number % 2)==0 ? "Male":"Female");
		person.setId(number.longValue());
			
		return person;
	}
	
	private PersonDTO mockVO(Integer number) {

		PersonDTO person = new PersonDTO();
		
		person.setAddress("Address Test" + number);
		person.setFirstName("First Name Test" + number);
		person.setLastName("Last Name Test" + number);
		person.setGender((number % 2)==0 ? "Male":"Female");
		person.setKey(number.longValue());
		
	return person;
	}
	
	
	
}
