package task1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import task1.model.Person;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

public class PersonDaoImpl implements PersonDao {

    private SessionFactory sessionFactory;

    public PersonDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Person person) {
        Transaction tx = null;

        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.save(person);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void removeById(long id) {
        Transaction tx = null;

        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            Person person = session.get(Person.class, id);
            session.delete(person);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> getAll() {
        Transaction tx = null;
        List<Person> persons = null;
        String hql = "FROM Person";

        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            persons = session.createQuery(hql).list();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public List<Person> findByDocumentNum(String num, Boolean isActive) {
        Transaction tx = null;
        List<Person> persons = null;

        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            String hqlQuery = "select p " +
                    "FROM Person p left join Document d on p.document = d" +
                    "  where number like : num and is_active = : isActive";

            TypedQuery<Person> query = session.createQuery(hqlQuery);
            query.setParameter("num", "%" + num + "%");
            query.setParameter("isActive", isActive);
            persons = query.getResultList();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return persons;
    }


    public List<Person> getLastNameAndDocNumber(String lastName){
        Transaction tx = null;
        List<Person> persons = null;

        try(Session session = sessionFactory.openSession()){
            String hqlQuery = "select * from persons p left join " +
            "(select * from my_db.documents d " +
            "where  d.is_active  = :isActive ) actd  on p.document_id = actd.id";

            TypedQuery<Person> query = session.createSQLQuery(hqlQuery);
               query.setParameter("isActive", true);
            persons = query.getResultList();
        }
        return persons;
    }
}
