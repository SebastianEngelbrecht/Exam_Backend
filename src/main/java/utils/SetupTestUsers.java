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
    
    //User user = new User("userTest", "test123", "TestVej", "TestCity", "1000");
    //User admin = new User("admin", "test321123", "", "", "");
    Conference conf = new Conference("CES","Las Vegas",100,"Mandag","morgen");
    Conference conf2 = new Conference("E3","New York",200,"onsdag","formiddag");
    Conference conf3 = new Conference("Comic con","Los Angelos",300,"fredag","eftermiddag");
    Speaker speaker1 = new Speaker("Tobias","GameDEV","Boy");
    Talk talk1 = new Talk("Games",10);
    //if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
    //  throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
    //Role userRole = new Role("user");
    //Role adminRole = new Role("admin");
    //user.addRole(userRole);
    //admin.addRole(adminRole);
    conf.addTalk(talk1);
    speaker1.addTalk(talk1);
    em.persist(conf);
    em.persist(conf2);
    em.persist(conf3);
    
    

    em.getTransaction().commit();
    
   
  }

}
