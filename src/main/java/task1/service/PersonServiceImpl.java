package task1.service;

import task1.dao.PersonDao;
import task1.model.Person;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    private PersonDao dao;

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    @Override
    public void add(Person person) {
        dao.add(person);
    }

    @Override
    public void removeById(long id) {
        dao.removeById(id);

    }

    @Override
    public List<Person> getAll() {
        return dao.getAll();
    }

    @Override
    public List<Person> findByDocumentNum(String num, Boolean isActive) {
        return dao.findByDocumentNum(num, isActive);
    }
}
