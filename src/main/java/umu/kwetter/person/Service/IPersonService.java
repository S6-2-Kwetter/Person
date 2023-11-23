package umu.kwetter.person.Service;

import umu.kwetter.person.Dtos.PersonRequestDto;
import umu.kwetter.person.Dtos.PersonResponseDto;

public interface IPersonService {
    void post(PersonRequestDto personRequestDto);
    PersonResponseDto get(Long id);
    void put(Long id, PersonRequestDto personRequestDto);
    void delete(Long id);
}
