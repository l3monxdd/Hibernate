package ua.test.mainRunner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ua.test.model.Cars;
import ua.test.model.User;

import java.util.List;

public class Runner {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        sessionFactory = new Configuration().configure().buildSessionFactory();

        Runner runner = new Runner();


        // додавання користувача
//        runner.addUser("Viktor");
//        runner.addUser("Roman");

//        runner.addCar("Audi", "a4", 2016, 15000.0);

        // видалення користувача
//        runner.deleteUser(2);

        //отримання всіх користувачів
//        List<User> users = runner.findAllUser();
//
//        for (User user : users) {
//            System.out.println(user.getId() + "\t" + user.getName());
//        }

        //оновлення юзера
//        runner.updateUser(3, "Ivan");


    }

    public void addUser(String name) {
        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        transaction = session.beginTransaction();

        User user = new User(name);

        session.save(user);

        transaction.commit();

        session.close();

    }

    public void updateUser(int id, String name){
        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        transaction = session.beginTransaction();

        User user = session.get(User.class, id);
        user.setName(name);

        session.save(user);

        transaction.commit();

        session.close();
    }


    public List<User> findAllUser() {
        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        transaction = session.beginTransaction();

        List<User> users = session.createQuery("FROM User").list();

        transaction.commit();

        session.close();

        return users;
    }

    public void deleteUser(int id) {
        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        transaction = session.beginTransaction();

        User user = session.get(User.class, id);

        session.delete(user);

        transaction.commit();

        session.close();

    }

    public void addCar(String brand, String model, int year, double price) {
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
