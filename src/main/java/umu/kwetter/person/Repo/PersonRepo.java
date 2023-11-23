package umu.kwetter.person.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umu.kwetter.person.Model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
    Person findPersonById(Long id);
}

