package task1;

import task1.dao.PersonDao;
import task1.dao.PersonDaoImpl;
import task1.model.Document;
import task1.model.Person;
import task1.service.PersonService;
import task1.service.PersonServiceImpl;
import task1.util.Util;

public class Main {
    public static void main(String[] args) {
        Document document1 = new Document("473777", "паспорт", true);
        Document document2 = new Document("473001", "паспорт", true);
        Document document3 = new Document("473777", "паспорт", false);

        Person person1 = new Person("Руслан", "Манасипов", document1);
        Person person2 = new Person("Илья", "Комар", document2);
        Person person3 = new Person("Иван", "Иванов", document3);

        PersonDao personDao = new PersonDaoImpl(Util.getInstance().getSessionFactory());
        PersonService personService = new PersonServiceImpl(personDao);

        personService.add(person1);
        personService.add(person2);
        personService.add(person3);

        System.out.println(personDao.findByDocumentNum("777", true));
    }
}
