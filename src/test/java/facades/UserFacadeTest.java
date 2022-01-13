/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.ConferenceDTO;
import dtos.ConferenceListDTO;
import dtos.RentalArrangementDTO;
import dtos.TalkListDTO;
import dtos.UserDTO;
import entities.Conference;
import entities.RentalArrangement;
import entities.Role;
import entities.Speaker;
import entities.Talk;
import entities.User;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author SebastianEngelbrecht
 */





public class UserFacadeTest {
    
    private static EntityManagerFactory emf;
    private static UserFacade facade; 
    
    User u1,u2,u3;
    RentalArrangement ra1,ra2,ra3;
    Conference c1,c2,c3;
    Talk t1,t2;
    Speaker s1;
    
    public UserFacadeTest() {}
    
    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = UserFacade.getUserFacade(emf);
    }
    
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
            Role userRole = new Role("user");
            Role adminRole = new Role("admin");
            u2 = new User("user2", "test321", "testvej2", "testby2", "1234", 55);
            u3 = new User("user3", "test3", "testvej3", "testby3", "1234", 100);
            c1 = new Conference("CES","Las Vegas",100,"søndag","eftermiddag");
            c2 = new Conference("E3","california",200,"fredag","aften");
            c3 = new Conference("Apple","Dubai",300,"lørdag","formiddag");
            t1 = new Talk("spil",10);
            t2 = new Talk("Sport",20);
            s1 = new Speaker("Sebastian","programmer","male");
        
         
           
        try {
            em.getTransaction().begin();
           // em.createNamedQuery("Talk.deleteAllRows").executeUpdate();
            em.createNamedQuery("RentalArrangement.deleteAllRows").executeUpdate();
            em.createNamedQuery("User.deleteAllRows").executeUpdate();
            em.createNamedQuery("Role.deleteAllRows").executeUpdate();
            em.createNamedQuery("Conference.deleteAllRows").executeUpdate();
            
           
           
            em.persist(userRole);
            em.persist(adminRole);
            s1.addTalk(t1);
            c1.addTalk(t1);
            em.persist(s1);
            em.persist(u2);
            em.persist(u3);
            
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }  
    }
    
    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
//        emf.close();
    }
    
    
    @Test
    void getAllConferencesTest() throws Exception {
        System.out.println("Testing getAllConferences(ConferenceDTO uDTO");
        int expected = 3;
        ConferenceListDTO result = facade.getAllConferences();
        assertEquals(expected,result.getAll().size());
        System.out.println(result.getAll());
    }
    
    @Test
    void getAllTalksByGivenSpeaker() throws Exception {
        System.out.println("Get all talks by given speaker");
        TalkListDTO result = facade.getAllTalksByGivenSpeaker(s1.getId());
        int expected = 1;
        assertEquals(expected,result.getAll().size());
        System.out.println(s1.getId());
    }
    
    @Test
    void getAllTalksByGivenConference() throws Exception {
        System.out.println("Get all talks by given conference");
        TalkListDTO result = facade.getAllTalksByGivenConference(c1.getId());
        int expected = 3;
        assertEquals(expected,result.getAll().size());
        System.out.println(c1.getId());
    }
    
    }
    
    
    

