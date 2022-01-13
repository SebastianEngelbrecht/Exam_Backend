/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Conference;
import entities.Speaker;
import entities.Talk;
import java.util.ArrayList;
import java.util.List;
import jdk.internal.joptsimple.internal.Strings;

/**
 *
 * @author sebastianengelbrecht
 */
public class TalkDTO {
    private Long id;
    private String topic;
    private int duration;
    private List<String> propsList;
    private Conference conference;
    private List<Speaker> speakerList = new ArrayList<>();

    public TalkDTO() {
    }

    public TalkDTO(String topic, int duration) {
        this.id = id;
        this.topic = topic;
        this.duration = duration;
        this.propsList = new ArrayList<>();
          
    }
    
    public TalkDTO(Talk t){
        this.id = t.getId();
        this.topic =t.getTopic();
        this.duration = t.getDuration();
        this.propsList = t.getPropsList();
        this.conference = t.getConference();
        this.speakerList = t.getSpeakerList();
        
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<String> getPropsList() {
        return propsList;
    }

    public void setPropsList(List<String> propsList) {
        this.propsList = propsList;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public List<Speaker> getSpeakerList() {
        return speakerList;
    }

    public void setSpeakerList(List<Speaker> speakerList) {
        this.speakerList = speakerList;
    }
    
    
    
   
}
