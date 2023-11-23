package umu.kwetter.person.Service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import umu.kwetter.person.Dtos.PersonRequestDto;
import umu.kwetter.person.Model.Person;
import umu.kwetter.person.Repo.PersonRepo;

@Service
public class PersonService implements IPersonService{
    @Resource
    PersonRepo repo;

    public void post(PersonRequestDto personRequestDto){
        Person person = new Person();
    }

    public void get(Long id){

    }

    public void put(PersonRequestDto personRequestDto){

    }

    public void delete(Long id){

    }
}
