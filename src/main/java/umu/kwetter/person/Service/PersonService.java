package umu.kwetter.person.Service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import umu.kwetter.person.Dtos.PersonRequestDto;
import umu.kwetter.person.Dtos.PersonResponseDto;
import umu.kwetter.person.Model.Person;
import umu.kwetter.person.RabbitMQ.Runner;
import umu.kwetter.person.Repo.PersonRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements IPersonService{
    @Resource
    PersonRepo repo;

    @Resource
    Runner runner;

    public void post(PersonRequestDto personRequestDto){
        Person person = new Person(0L, personRequestDto.username, personRequestDto.password, personRequestDto.role);
        repo.save(person);
    }

    public List<PersonResponseDto> get(){
        List<Person> persons = repo.findAll();
        List<PersonResponseDto> personResponseDtoList = new ArrayList<>();
        for(Person person : persons){
            PersonResponseDto personResponseDto = new PersonResponseDto(person.id, person.username, person.role);
            personResponseDtoList.add(personResponseDto);
        }
        return personResponseDtoList;
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
        runner.send(id);
        repo.deleteById(id);
    }
}
