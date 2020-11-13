package br.com.nalli.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.nalli.converter.mocks.MockPerson;
import br.com.nalli.data.model.Person;
import br.com.nalli.data.dto.PersonDTO;

public class DozerConverterTest {

	MockPerson inputObject;
	
	@Before
	public void setUp() {
		inputObject = new MockPerson();
	}
	
	@Test
	public void parseEntitytoVOTest() {
		PersonDTO output = DozerConverter.parseObject(inputObject.mockEntity(), PersonDTO.class);
		
		Assert.assertEquals(0L, output.getKey());
		Assert.assertEquals("First Name Test0", output.getFirstName());
		Assert.assertEquals("Last Name Test0", output.getLastName());
		Assert.assertEquals("Address Test0", output.getAddress());
		Assert.assertEquals("Male", output.getGender());	
		
	
	}
	
	
	@Test
	public void parseEntityToVOListTest() {
		
		List<PersonDTO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), PersonDTO.class);
		
		PersonDTO outputZero= outputList.get(0);
		Assert.assertEquals(0L, outputZero.getKey());
		Assert.assertEquals("First Name Test0", outputZero.getFirstName());
		Assert.assertEquals("Last Name Test0", outputZero.getLastName());
		Assert.assertEquals("Address Test0", outputZero.getAddress());
		Assert.assertEquals("Male", outputZero.getGender());	
		
		
		PersonDTO outputSeven = outputList.get(7);
		Assert.assertEquals(7L, outputSeven.getKey());
		Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
		Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
		Assert.assertEquals("Address Test7", outputSeven.getAddress());
		Assert.assertEquals("Female", outputSeven.getGender());	
		
		
		PersonDTO outputTwelve = outputList.get(12);
		Assert.assertEquals(12L, outputTwelve.getKey());
		Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
		Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
		Assert.assertEquals("Address Test12", outputTwelve.getAddress());
		Assert.assertEquals("Male", outputTwelve.getGender());	
	}
	
	
	
	
	@Test
	public void parserVOToEntityTest() {
		Person output = DozerConverter.parseObject(inputObject.mockVO(), Person.class);
		
		Assert.assertEquals(0L, output.getId());
		Assert.assertEquals("First Name Test0", output.getFirstName());
		Assert.assertEquals("Last Name Test0", output.getLastName());
		Assert.assertEquals("Address Test0", output.getAddress());
		Assert.assertEquals("Male", output.getGender());	
	}
	
	@Test
	public void parseVOToEntityListTes() {
		
		List<Person> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Person.class);
		
		Person outputZero= outputList.get(0);
		Assert.assertEquals(0L, outputZero.getId());
		Assert.assertEquals("First Name Test0", outputZero.getFirstName());
		Assert.assertEquals("Last Name Test0", outputZero.getLastName());
		Assert.assertEquals("Address Test0", outputZero.getAddress());
		Assert.assertEquals("Male", outputZero.getGender());	
		
		
		Person outputSeven = outputList.get(7);
		Assert.assertEquals(7L, outputSeven.getId());
		Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
		Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
		Assert.assertEquals("Address Test7", outputSeven.getAddress());
		Assert.assertEquals("Female", outputSeven.getGender());	
		
		
		Person outputTwelve = outputList.get(12);
		Assert.assertEquals(12L, outputTwelve.getId());
		Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
		Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
		Assert.assertEquals("Address Test12", outputTwelve.getAddress());
		Assert.assertEquals("Male", outputTwelve.getGender());	
	}
	
}
