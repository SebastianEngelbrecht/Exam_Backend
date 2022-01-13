/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Speaker;
import entities.Talk;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebastianengelbrecht
 */
public class SpeakerDTO {
    
    private Long id;
    private String name;
    private String profession;
    private String gender;
    private List<Talk> talkList = new ArrayList<>();

    public SpeakerDTO() {
    }

    public SpeakerDTO(String name, String profession, String gender) {
        this.id = id;
        this.name = name;
        this.profession = profession;
        this.gender = gender;
        this.talkList = talkList;
    }
    
    public SpeakerDTO(Speaker s){
        this.id = s.getId();
        this.name = s.getName();
        this.profession = s.getProfession();
        this.gender = s.getGender();
        this.talkList = s.getTalkList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Talk> getTalkList() {
        return talkList;
    }

    public void setTalkList(List<Talk> talkList) {
        this.talkList = talkList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
   
    
}
