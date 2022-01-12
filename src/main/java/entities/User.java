package entities;

import dtos.UserDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.mindrot.jbcrypt.BCrypt;


@Entity
@NamedQueries({
    @NamedQuery(name = "User.deleteAllRows", query = "DELETE from User")
})
@Table(name = "users")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "user_name", length = 25)
  private String userName;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "user_pass")
  private String userPass;
  @JoinTable(name = "user_roles", joinColumns = {
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")}, inverseJoinColumns = {
    @JoinColumn(name = "role_name", referencedColumnName = "role_name")})
  @Column(name = "user_address")
  private String userAddress;
  @Column(name = "user_city")
  private String userCity;
  @Column(name = "user_zip")
  private String userZip;
  @Column(name = "user_balance")
  private int userBalance;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<RentalArrangement> RentalArrangement; 
  
  @ManyToMany
  private List<Role> roleList = new ArrayList<>();
 
  public List<String> getRolesAsStrings() {
    if (roleList.isEmpty()) {
      return null;
    }
    List<String> rolesAsStrings = new ArrayList<>();
    roleList.forEach((role) -> {
        rolesAsStrings.add(role.getRoleName());
      });
    return rolesAsStrings;
  }

  public User() {}

  //TODO Change when password is hashed
   public boolean verifyPassword(String pw){
        return(BCrypt.checkpw(pw, userPass));
    }

  public User(String userName, String userPass, String userAddress, String userCity, String userZip, int userBalance) {
    this.userName = userName;
    this.userAddress = userAddress;
    this.userCity = userCity;
    this.userZip = userZip;
    this.userBalance = userBalance;
    this.userPass = BCrypt.hashpw(userPass, BCrypt.gensalt());
    this.RentalArrangement = new ArrayList<>();    
  }
  
  public User(UserDTO u) {
    this.userName = u.getUserName();
    this.userAddress = u.getUserAddress();
    this.userCity = u.getUserCity();
    this.userZip = u.getUserZip();
    this.userBalance = u.getUserBalance();
    this.userPass = BCrypt.hashpw(u.getUserPass(), BCrypt.gensalt());
    this.RentalArrangement = new ArrayList<>();
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPass() {
    return this.userPass;
  }

  public void setUserPass(String userPass) {
    this.userPass = userPass;
  }

  public List<Role> getRoleList() {
    return roleList;
  }

  public void setRoleList(List<Role> roleList) {
    this.roleList = roleList;
  }

  public void addRole(Role userRole) {
    roleList.add(userRole);
  }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserZip() {
        return userZip;
    }

    public void setUserZip(String userZip) {
        this.userZip = userZip;
    }

    public int getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(int userBalance) {
        this.userBalance = userBalance;
    }

    public List<RentalArrangement> getRentalArrangement() {
        return RentalArrangement;
    }

   /* public void setRentalArrangement(List<RentalArrangement> rentalArrangement) {
        this.RentalArrangement = rentalArrangement;
    }*/
    
    public void addArrangement(RentalArrangement ra) {
        if ( ra != null) {
           this.RentalArrangement.add(ra);
           ra.setUser(this);
        }
        
    }

}
