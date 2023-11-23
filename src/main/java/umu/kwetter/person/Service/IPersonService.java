package umu.kwetter.person.Service;

import umu.kwetter.person.Dtos.PersonRequestDto;

public interface IPersonService {
    void post(PersonRequestDto personRequestDto);
    void get(Long id);
    void put(PersonRequestDto personRequestDto);
    void delete(Long id);
}
