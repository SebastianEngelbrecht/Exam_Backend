/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Conference;
import entities.Speaker;
import java.util.ArrayList;
import java.util.List;
import jdk.internal.joptsimple.internal.Strings;

/**
 *
 * @author sebastianengelbrecht
 */
public class TalkDTO {
    private String topic;
    private int duration;
    private List<Strings> propsList;
    private Conference conference;
    private List<Speaker> speakerList = new ArrayList<>();

    public TalkDTO() {
    }

    public TalkDTO(String topic, int duration) {
        this.topic = topic;
        this.duration = duration;
        this.propsList = new ArrayList<>();
          
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

    public List<Strings> getPropsList() {
        return propsList;
    }

    public void setPropsList(List<Strings> propsList) {
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
