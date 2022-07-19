package task1.dao;

import task1.model.Person;

import java.util.List;

public interface PersonDao {

    void add(Person person);

    void removeById(long id);

    List<Person> getAll();

    List<Person> findByDocumentNum(String num, Boolean isActive);
}
