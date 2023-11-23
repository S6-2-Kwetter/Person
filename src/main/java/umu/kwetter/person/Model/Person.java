package umu.kwetter.person.Model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Table(name= "person")
@Getter
@Setter
@NoArgsConstructor
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "username", nullable = false)
    public String username;
    @Column(name = "password", nullable = false)
    public String password;
    @Column(name = "role", nullable = false)
    public String role;

    public Person(Long id, String username, String password, String role)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
