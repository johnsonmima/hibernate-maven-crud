package org.mima;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mima.entity.Users;

/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) {
        SessionFactory factory =
                new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class).buildSessionFactory();
        Session session = factory.getCurrentSession();



        try {

            // create new user
            Users user = new Users("James", "James Now Jack");

            //other operation
            //Users user = new Users();

            // begin transaction
            session.beginTransaction();
            // ------ SAVE
            // persist
            session.persist(user);
            System.out.println(user);
            // ----------- READ
            //user = session.get(Users.class, 1);
            //System.out.println(user.toString());
            // -- update
//        user = session.get(Users.class, 1);
//        user.setFullName("James Micah");
//        user.setUsername("james_micah");
//        System.out.println(user.toString());

            // -------------- delete
//        user = session.get(Users.class, 2);
//        session.remove(user);


            // get transaction . commit
            session.getTransaction().commit();
            //
            //System.out.println("new row added");

        } finally {
            factory.close();
            session.close();
        }

    }
}
