package ua.test.mainRunner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ua.test.model.User;

public class Runner {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        sessionFactory = new Configuration().configure().buildSessionFactory();

        Runner runner = new Runner();

        runner.addUser("Viktor");

    }

    public void addUser(String name){
        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        transaction = session.beginTransaction();

        User user = new User(name);

        session.save(user);

        transaction.commit();

        session.close();


    }
}
