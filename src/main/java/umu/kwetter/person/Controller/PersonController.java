package umu.kwetter.person.Controller;

import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umu.kwetter.person.Dtos.PersonRequestDto;
import umu.kwetter.person.Dtos.PersonResponseDto;
import umu.kwetter.person.Service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Resource
    PersonService service;

    @PostMapping
    public ResponseEntity post(@RequestBody PersonRequestDto personRequestDto){
        service.post(personRequestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<PersonResponseDto>> get(){
        List<PersonResponseDto> personResponseDtoList = service.get();
        return ResponseEntity.ok().body(personResponseDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDto> get(@PathVariable(value = "id") Long id){
        PersonResponseDto personResponseDto = service.get(id);
        return ResponseEntity.ok().body(personResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable(value = "id") Long id, @RequestBody PersonRequestDto personRequestDto){
        service.put(id, personRequestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
