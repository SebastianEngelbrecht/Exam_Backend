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
import javax.persistence.Table;

/**
 *
 * @author sebastianengelbrecht
 */
@Entity
@Table(name = "speakers")
public class Speaker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "speaker_name")
    private String name;
    @Column(name = "profession")
    private String profession;
    @Column(name = "gender")
    private String gender;
    @ManyToMany
    @JoinColumn(name = "talk_name", referencedColumnName = "talk_name")
    private List<Talk> talkList = new ArrayList<>();

    public Speaker() {
    }

    public Speaker(String name, String profession, String gender) {
        this.id = id;
        this.name = name;
        this.profession = profession;
        this.gender = gender;
        this.talkList = new ArrayList<>();
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
        return "Speaker{" + "id=" + id + ", name=" + name + ", profession=" + profession + ", gender=" + gender + '}';
    }

   
}
