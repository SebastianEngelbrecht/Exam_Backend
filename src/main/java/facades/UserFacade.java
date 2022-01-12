package facades;

import dtos.ArrangementsListDTO;
import dtos.RentalArrangementDTO;
import dtos.UserDTO;
import entities.RentalArrangement;
import entities.Role;
import entities.User;
import errorhandling.API_Exception;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import security.errorhandling.AuthenticationException;

/**
 * @author lam@cphbusiness.dk
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
    
    public UserDTO addRentalArrangement(RentalArrangementDTO raDTO) {
        EntityManager em = getEntityManager();
        RentalArrangement ra = null;
        User u = null;
        
        ra = new RentalArrangement(raDTO);
        u = em.find(User.class, raDTO.getUserName());
        if(u != null) {
            u.addArrangement(ra);
            u.setUserBalance(u.getUserBalance() - ra.getPrice());
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        }
        return new UserDTO(u);
    }
    
    public RentalArrangementDTO checkArrangementStatus(RentalArrangementDTO raDTO) {
        EntityManager em = getEntityManager();
        RentalArrangement ra = null;
        
        ra = em.find(RentalArrangement.class, raDTO.getId());
        
        if( ra != null) {
            if(ra.getToDate().isBefore(LocalDate.now())) {
                ra.setStatus(false);
            } else {
                ra.setStatus(true);
            }
            em.getTransaction().begin();
            em.merge(ra);
            em.getTransaction().commit();
        }
        return new RentalArrangementDTO(ra);
    }
    
    public ArrangementsListDTO getAllArrangementsWithGivenUsername(String username) throws Exception {
        EntityManager em = getEntityManager();
        List<RentalArrangement> arrangements;
        TypedQuery<RentalArrangement> query = em.createQuery("SELECT ra FROM RentalArrangement ra WHERE ra.user.userName = :name", RentalArrangement.class);
        query.setParameter("name", username);
        arrangements = query.getResultList();
        return new ArrangementsListDTO(arrangements);
    }
    
    public UserDTO getUser(String username) throws Exception {
        EntityManager em = emf.createEntityManager();
        User u = em.find(User.class, username);
      
            return new UserDTO(u);
        
     
    }
    
    public UserDTO addBalance(UserDTO uDTO) {
        
        
        EntityManager em = emf.createEntityManager();
        User u = em.find(User.class, uDTO.getUserName());
        if(u != null) {
            u.setUserBalance(u.getUserBalance() + uDTO.getUserBalance());
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        }
        
        
        return new UserDTO(u);
    }
    
}