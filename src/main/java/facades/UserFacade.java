package facades;


import dtos.ConferenceDTO;
import dtos.ConferenceListDTO;
import dtos.TalkListDTO;
import dtos.UserDTO;
import entities.Conference;
import entities.Role;
import entities.Speaker;
import entities.Talk;
import entities.User;
import errorhandling.API_Exception;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import security.errorhandling.AuthenticationException;

/**
 
 */
public class UserFacade {

    private static EntityManagerFactory emf;
    private static UserFacade instance;

    private UserFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }

    public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    /*
    public UserDTO create(UserDTO u) throws Exception {
        EntityManager em = getEntityManager();
        User user = null;
        try {
            user = new User(u);
            em.getTransaction().begin();
            if(em.find( User.class, u.getUserName())!=null) {
                throw new API_Exception("Username already exists");
            }
            Role role = em.find(Role.class, "user");
            user.addRole(role);
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new UserDTO(user);
    }
    
    
    public UserDTO getUser(String username) throws Exception {
        EntityManager em = emf.createEntityManager();
        User u = em.find(User.class, username);
      
            return new UserDTO(u);
        
     
    }
   
    */
    // Get All Conferences Method.
     public ConferenceListDTO getAllConferences() throws Exception{
        EntityManager em = emf.createEntityManager();
        List<Conference> cList;
        TypedQuery<Conference> query = em.createQuery("SELECT c FROM Conference c", Conference.class);
        cList = query.getResultList();
        return new ConferenceListDTO(cList);
    }
     
     // See all talks by a specific speaker.
     public TalkListDTO getAllTalksByGivenSpeaker(Long id) throws Exception {
        EntityManager em = getEntityManager();
        List<Talk> tList;
        TypedQuery<Talk> query = em.createQuery("SELECT t FROM Talk t JOIN t.speakerList s WHERE s.id = :id", Talk.class);
        query.setParameter("id", id);
        tList = query.getResultList();
        return new TalkListDTO(tList);
     }
     
     //See all talks by a specific Conference
     public TalkListDTO getAllTalksByGivenConference(Long id) throws Exception {
         EntityManager em = getEntityManager();
         List<Talk> t2List;
         TypedQuery<Talk> query = em.createQuery("SELECT t FROM Talk t JOIN t.conference c WHERE c.id = :id",Talk.class);
         query.setParameter("id", id);
         t2List = query.getResultList();
         return new TalkListDTO(t2List);
     }
     
     //Delete a talk
     public void deleteTalk(int id) throws Exception {
        EntityManager em = getEntityManager();
        Talk talk;
        try {
            em.getTransaction().begin();
                talk = em.find(Talk.class, id);
                if(talk == null){
                    throw new Exception("could not delete, no id found");
                }
                em.remove(talk);
                em.getTransaction().commit();
            
        } finally {
            em.close();
        }
        
    }
     
     //Create new conference
    /* public ConferenceDTO createConference(ConferenceDTO confDTO){
         Conference conf = null;
         EntityManager em = emf.createEntityManager();
         try{
             conf = new Conference(confDTO);
             em.getTransaction().begin();
             em.persist(conf);
             em.getTransaction().commit();
         } finally {
             em.close();
         }
        return new ConferenceDTO(conf);

    }
  */

    
}