/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Role;
import entities.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 45319
 */
public class UserDTO {
    
    private String userName;
    private String userPass;
    private String userAddress;
    private String userCity;
    private String userZip;
    private List<String> roleList = new ArrayList<>();
    
    public UserDTO() {}

    public UserDTO(User user) {
        this.userName = user.getUserName();
        this.userPass = user.getUserPass();
        this.userAddress = user.getUserAddress();
        this.userCity = user.getUserCity();
        this.userZip = user.getUserZip();
        this.roleList = user.getRolesAsStrings();
    }

    public UserDTO(String userName, String userPass, String userAddress, String userCity, String userZip) {
        this.userName = userName;
        this.userPass = userPass;
        this.userAddress = userAddress;
        this.userCity = userCity;
        this.userZip = userZip;
    }
    
    public UserDTO(String userName) {
        this.userName = userName;
    }
    
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
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


    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }
    
    public void addRole(String userRole) {
    roleList.add(userRole);
    }
    
    
    
}
