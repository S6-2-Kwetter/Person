package umu.kwetter.person.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umu.kwetter.person.Model.PersonModel;

@Repository
public interface PersonRepo extends JpaRepository<PersonModel, Long> {
    PersonModel findPersonById(Long id);
}

