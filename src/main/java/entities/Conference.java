/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dtos.ConferenceDTO;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author sebastianengelbrecht
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Conference.deleteAllRows", query = "DELETE from Conference")
})
@Table(name = "conferences")
public class Conference implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id")
    private Long id;
    @Column(name = "conference_name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "date")
    private LocalDate date = LocalDate.now();
    @Column(name = "time")
    private LocalTime time = LocalTime.now();
    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL)
    private List<Talk> talkList;

    public Conference() {
    }
    

    public Conference(String name, String location, int capacity, LocalDate date, LocalTime time) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.date = date;
        this.time = time;
        this.talkList = new ArrayList<>();
    }
    
    public Conference(ConferenceDTO cDTO){
        this.id = cDTO.getId();
        this.name = cDTO.getName();
        this.location = cDTO.getLocation();
        this.capacity = cDTO.getCapacity();
        this.date = cDTO.getDate();
        this.time = cDTO.getTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Talk> getTalkList() {
        return talkList;
    }

    public void setTalkList(List<Talk> talkList) {
        this.talkList = talkList;
    }
    
    

    @Override
    public String toString() {
        return "Conference{" + "id=" + id + ", name=" + name + ", location=" + location + ", capacity=" + capacity + ", date=" + date + ", time=" + time + '}';
    }

  

    
}
