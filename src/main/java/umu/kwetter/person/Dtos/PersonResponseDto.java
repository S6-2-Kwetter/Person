package umu.kwetter.person.Dtos;

public class PersonResponseDto {
    public Long id;
    public String username;
    public String role;

    public PersonResponseDto(Long id, String username, String role){
        this.id = id;
        this.username = username;
        this.role = role;
    }
}
