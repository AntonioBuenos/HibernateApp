package by.smirnov;

import by.smirnov.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Passport.class)
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

/*            Movie movie = new Movie("Pulp Fiction", 1994);
            Actor actor1 = new Actor("Harvey Keitel", 81);
            Actor actor2 = new Actor("Samuel L. Jackson", 72);

            movie.setActors(new ArrayList<>(List.of(actor1, actor2)));
            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));

            session.persist(movie);
            session.persist(actor1);
            session.persist(actor2);

            Movie movie2 = new Movie("Reservoir Dogs", 1992);
            Actor actor3 = session.get(Actor.class, 1);

            movie2.setActors(new ArrayList<>(Collections.singletonList(actor3)));
            actor3.getMovies().add(movie2);

            session.persist(movie2);
            session.persist(actor3);*/

            Actor actor = session.get(Actor.class, 2);
            System.out.println(actor.getMovies());

            Movie movieToRemove = actor.getMovies().get(0);
            actor.getMovies().remove(0);
            movieToRemove.getActors().remove(actor);

            session.getTransaction().commit();
        }


/*        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Passport.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

*//*            Person person = session.get(Person.class, 3);
            System.out.println(person);
            List<Item> items = person.getItems();
            System.out.println(items);*//*

         *//*            Item item = session.get(Item.class, 7);
            System.out.println(item);
            Person person1 = item.getOwner();
            System.out.println(person1);*//*

         *//*            Person person = session.get(Person.class, 2);
            Item newItem = new Item("Item from Hibernate", person);
            person.getItems().add(newItem);
            session.persist(newItem);

/*            Person person = new Person("Sinyaya Boroda", 30);
            Item newItem = new Item("Superitem", person);
            person.setItems(new ArrayList<Item>(Collections.singletonList(newItem)));
            session.persist(person);
            session.persist(newItem);*//*

         *//*            Person person = session.get(Person.class, 3);
            List<Item> items = person.getItems();
            for (Item item : items) {
                session.remove(item);
            }
            person.getItems().clear();*//*

         *//*            Person person = session.get(Person.class, 2);
            session.remove(person); //SQL
            person.getItems().forEach(i -> i.setOwner(null)); //для правильного состояния кэша*//*

         *//*            Person person = session.get(Person.class, 4);
            Item item = session.get(Item.class, 1);
            item.getOwner().getItems().remove(item);
            item.setOwner(person);
            person.getItems().add(item);

            session.refresh(person);*//*

         *//*            Person person = new Person("Cascading Person", 36);
            person.addItem(new Item("SuperGood1"));
            person.addItem(new Item("SuperGood2"));
            person.addItem(new Item("SuperGood3"));*//*

            Person person = new Person("Brand New Person", 1);
            Passport passport = new Passport(1234567);
            person.setPassport(passport);
            session.persist(person);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }*/

    }
}
