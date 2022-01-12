/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dtos.RentalArrangementDTO;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author 45319
 * 
 * @Entity
@NamedQueries({
    @NamedQuery(name = "RentedMovies.deleteAllRows", query = "DELETE from RentedMovies")
})
@Table(name = "rented_movies")
public class RentedMovies implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
 * 
 * 
 * 
 */

@Entity
@NamedQueries({
    @NamedQuery(name = "RentalArrangement.deleteAllRows", query = "DELETE from RentalArrangement")
})
@Table(name = "rental_arrangement")

public class RentalArrangement implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "movie_id")
    private String movieId;
    @Column(name = "from_date")
    private LocalDate fromDate = LocalDate.now();
    @Column(name = "to_date")
    private LocalDate toDate = LocalDate.now().plusDays(2);
    @Column(name = "total")
    private int price = 49;
    @Column(name = "status")
    private boolean status = true;
    @ManyToOne
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")
    private User user;
    

    public RentalArrangement (){
    }

    public RentalArrangement(String movieId){
    this.movieId = movieId;
    this.fromDate = fromDate;
    this.toDate = toDate;
    this.price = price;
    this.status = status;
    }
    
    public RentalArrangement(RentalArrangementDTO rADTO) {
        this.id = rADTO.getId();
        this.movieId = rADTO.getMovieId();
        this.fromDate = rADTO.getFromDate();
        this.toDate = rADTO.getToDate();
        this.price = price;
        this.status = rADTO.isStatus();
        this.user = rADTO.getUser();
    }
    
    public RentalArrangement(Long id, String movieId, LocalDate fromDate, LocalDate toDate, boolean status, User user) {
        this.id = id;
        this.movieId = movieId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.price = price;
        this.status = status;
        this.user = user;
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

    
    

    @Override
    public String toString() {
        return "RentalArrangement{" + "id=" + id + ", fromDate=" + fromDate + ", toDate=" + toDate + ", total=" + price + ", status=" + status + ", user=" + user + '}';
    }
    
    
    
    
}
