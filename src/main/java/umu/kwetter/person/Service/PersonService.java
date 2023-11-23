package umu.kwetter.person.Service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import umu.kwetter.person.Dtos.PersonRequestDto;
import umu.kwetter.person.Dtos.PersonResponseDto;
import umu.kwetter.person.Model.Person;
import umu.kwetter.person.Repo.PersonRepo;

@Service
public class PersonService implements IPersonService{
    @Resource
    PersonRepo repo;

    public void post(PersonRequestDto personRequestDto){
        Person person = new Person(0L, personRequestDto.username, personRequestDto.password, personRequestDto.role);
        repo.save(person);
    }

    public PersonResponseDto get(Long id){
        Person person = repo.findPersonById(id);
        PersonResponseDto personResponseDto = new PersonResponseDto(person.id, person.username, person.role);
        return personResponseDto;
    }

    public void put(Long id, PersonRequestDto personRequestDto){
        Person person = repo.findPersonById(id);
        if(person != null){
            person.setUsername(personRequestDto.username);
            person.setPassword(personRequestDto.password);
            person.setRole(personRequestDto.role);
            repo.save(person);
        }
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
