package task1.service;

import task1.model.Person;

import java.util.List;

public interface PersonService {

    void add(Person person);

    void removeById(long id);

    List<Person> getAll();
    List<Person> findByDocumentNum(String num, Boolean isActive);

    List<Person> getLastNameAndDocNumber(String lastName);
}
