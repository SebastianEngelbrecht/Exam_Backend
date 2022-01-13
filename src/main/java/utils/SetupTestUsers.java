package utils;


import entities.Conference;
import entities.Role;
import entities.Speaker;
import entities.Talk;
import entities.User;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    
    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords
    
    User user = new User("userTest", "test123", "TestVej", "TestCity", "1000", 100);
    User admin = new User("admin", "test321123", "", "", "", 0);
    Conference conf = new Conference("CES","Las Vegas",100,LocalDate.now(), LocalTime.now());
    Speaker speaker1 = new Speaker("Tobias Linge","GameDEV","Boy");
    Talk talk1 = new Talk("Games",10,conf);
    //if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
    //  throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user.addRole(userRole);
    admin.addRole(adminRole);
    em.persist(conf);
    em.persist(speaker1);
    em.persist(speaker1);
    //user.addMovie(movie1);
    //both.addRole(userRole);
    //both.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    //em.persist(both);
    em.getTransaction().commit();
    
   
  }

}
