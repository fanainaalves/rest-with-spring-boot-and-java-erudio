package br.com.erudio.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.model.Person;

@Service
public class PersonMapper {
	
	public PersonVO convertEntityToVo(Person person){
		PersonVO vo = new PersonVO();
		vo.setKey(person.getId());
		vo.setAddress(person.getAddress());
		//vo.setBirthday(new Date());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		return vo;
	}
	
	public Person convertVOToEntity(PersonVO person){
		Person entity = new Person();
		entity.setId(person.getKey());
		entity.setAddress(person.getAddress());
		//vo.setBirthday(new Date());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		return entity;
	}
	

}
