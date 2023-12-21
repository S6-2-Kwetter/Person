package umu.kwetter.person.Service;

import umu.kwetter.person.Dtos.PersonRequestDto;
import umu.kwetter.person.Dtos.PersonResponseDto;

import java.util.List;

public interface IPersonService {
    void post(PersonRequestDto personRequestDto);
    List<PersonResponseDto> get();
    PersonResponseDto get(Long id);
    void put(Long id, PersonRequestDto personRequestDto);
    void delete(Long id);
}
