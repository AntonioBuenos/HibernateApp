package by.smirnov;

import by.smirnov.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            Person person1 = new Person("Blaze", 56);
            Person person2 = new Person("Paul", 62);
            Person person3 = new Person("Bruce", 62);
            session.persist(person1);
            session.persist(person2);
            session.persist(person3);
            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }

    }
}
