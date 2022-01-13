/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author sebastianengelbrecht
 */
@Entity
@Table(name = "talks")
public class Talk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "talk_name")
    private String talk;
    @Column(name = "duration")
    private int duration;
    @Column(name = "props_list")
    private List <String> propsList;
    @ManyToOne
    @JoinColumn(name = "conference_name", referencedColumnName = "conference_name")
    private Conference conference;
    @ManyToMany
    @JoinColumn(name = "speaker_name", referencedColumnName = "speaker_name")
    private List<Speaker> speakerList = new ArrayList<>();

    public Talk() {
    }

    public Talk(String talk, int duration, Conference conference) {
        this.id = id;
        this.talk = talk;
        this.duration = duration;
        this.propsList = new ArrayList<>();
        this.conference = conference;
        this.speakerList = new ArrayList<>();
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
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
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    
    

    @Override
    public String toString() {
        return "Talk{" + "id=" + id + ", talk=" + talk + ", duration=" + duration + ", propsList=" + propsList + '}';
    }

    
    
}
