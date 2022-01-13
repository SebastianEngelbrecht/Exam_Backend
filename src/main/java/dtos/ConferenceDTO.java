/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Conference;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author sebastianengelbrecht
 */
public class ConferenceDTO {
    
    private Long id;
    private String name;
    private String location;
    private int capacity;
    private String date;
    private String time;

    public ConferenceDTO() {
    }
   

    public ConferenceDTO(Long id, String name, String location, int capacity) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.date = date;
        this.time = time;
    }
    
    public ConferenceDTO(Conference c){
        this.id = c.getId();
        this.name = c.getName();
        this.location = c.getLocation();
        this.capacity = c.getCapacity();
        this.date = c.getDate();
        this.time = c.getTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ConferenceDTO{" + "id=" + id + ", name=" + name + ", location=" + location + ", capacity=" + capacity + ", date=" + date + ", time=" + time + '}';
    }

  
    
    
}
