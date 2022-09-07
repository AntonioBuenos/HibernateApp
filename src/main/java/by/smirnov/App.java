package by.smirnov;

import by.smirnov.model.Item;
import by.smirnov.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

/*            Person person = session.get(Person.class, 3);
            System.out.println(person);
            List<Item> items = person.getItems();
            System.out.println(items);*/

/*            Item item = session.get(Item.class, 7);
            System.out.println(item);
            Person person1 = item.getOwner();
            System.out.println(person1);*/

            Person person = session.get(Person.class, 2);
            Item newItem = new Item("Item from Hibernate", person);
            person.getItems().add(newItem);
            session.persist(newItem);

            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }

    }
}
