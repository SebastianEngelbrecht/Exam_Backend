/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.RentalArrangement;
import entities.User;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author 45319
 */
public class RentalArrangementDTO {
    
    private long id;
    private String movieId;
    private LocalDate fromDate = LocalDate.now();
    private LocalDate toDate = LocalDate.now().plusDays(2);
    private int price;
    private boolean status = true;
    private User user;
    private String userName;

    public RentalArrangementDTO (){
    }

    public RentalArrangementDTO(String movieId, String userName){
    
    this.movieId = movieId;
    this.fromDate = fromDate;
    this.toDate = toDate;
    this.price = price;
    this.status = status;
    this.userName = userName;
    
    }
    
    public RentalArrangementDTO(RentalArrangement rA) {
        this.id = rA.getId();
        this.movieId = rA.getMovieId();
        this.fromDate = rA.getFromDate();
        this.toDate = rA.getToDate();
        this.price = rA.getPrice();
        this.status = rA.isStatus();
        this.userName = rA.getUser().getUserName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    

    
    
    
    
    
    
}
