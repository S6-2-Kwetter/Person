package umu.kwetter.person.Controller;

import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umu.kwetter.person.Dtos.PersonRequestDto;
import umu.kwetter.person.Dtos.PersonResponseDto;
import umu.kwetter.person.Service.PersonService;

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

    @GetMapping
    public ResponseEntity<PersonResponseDto> get(@PathVariable(value = "id") Long id){
        PersonResponseDto personResponseDto = service.get(id);
        return ResponseEntity.ok().body(personResponseDto);
    }

    @PutMapping
    public ResponseEntity put(@PathVariable(value = "id") Long id, @RequestBody PersonRequestDto personRequestDto){
        service.put(id, personRequestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable(value = "id") Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
