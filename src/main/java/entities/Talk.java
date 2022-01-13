/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dtos.TalkDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author sebastianengelbrecht
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Talk.deleteAllRows", query = "DELETE from Talk")
})
@Table(name = "talks")
public class Talk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "talk_name")
    private String topic;
    @Column(name = "duration")
    private int duration;
    @Column(name = "props_list")
    private List <String> propsList;
    @ManyToOne
    @JoinColumn(name = "conference_name", referencedColumnName = "conference_name")
    private Conference conference;
    @ManyToMany (cascade = { CascadeType.ALL })
    @JoinColumn(name = "speaker_name", referencedColumnName = "speaker_name")
    private List<Speaker> speakerList = new ArrayList<>();

    public Talk() {
    }

    public Talk(String topic, int duration) {
        this.id = id;
        this.topic = topic;
        this.duration = duration;
        this.propsList = new ArrayList<>();
        this.conference = conference;
        this.speakerList = new ArrayList<>();
    }
    
    public Talk(TalkDTO tDTO){
        this.id = tDTO.getId();
        this.topic = tDTO.getTopic();
        this.duration = tDTO.getDuration();
        this.propsList = tDTO.getPropsList();
        this.conference = tDTO.getConference();
        this.speakerList = tDTO.getSpeakerList();
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
    
    public void addSpeaker(Speaker speaker){
        if(speaker != null){
            this.speakerList.add(speaker);
            //Bi-directional
            speaker.getTalkList().add(this);
        }
        
    }
    
    

    @Override
    public String toString() {
        return "Talk{" + "id=" + id + ", talk=" + topic + ", duration=" + duration + ", propsList=" + propsList + '}';
    }

    
    
}
