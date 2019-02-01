package ua.test.mainRunner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ua.test.model.Cars;
import ua.test.model.User;

public class Runner {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        sessionFactory = new Configuration().configure().buildSessionFactory();

        Runner runner = new Runner();

//        runner.addUser("Viktor");

        runner.addCar("Audi","a4",2016,15000.0);



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

    public void addCar(String brand,String model, int year, double price){
        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        transaction = session.beginTransaction();

        Cars cars = new Cars();
        cars.setBrand(brand);
        cars.setModel(model);
        cars.setYear(year);
        cars.setPrice(price);

        session.save(cars);

        transaction.commit();

        session.close();
    }
}
