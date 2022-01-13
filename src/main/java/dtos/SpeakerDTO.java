/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Talk;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebastianengelbrecht
 */
public class SpeakerDTO {
    
    private String name;
    private String profession;
    private String gender;
    private List<Talk> talkList = new ArrayList<>();

    public SpeakerDTO() {
    }

    public SpeakerDTO(String name, String profession, String gender) {
        this.name = name;
        this.profession = profession;
        this.gender = gender;
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
    
   
    
}
