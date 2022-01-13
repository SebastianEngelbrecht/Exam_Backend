/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Conference;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebastianengelbrecht
 */
public class ConferenceListDTO {
    
    List<ConferenceDTO> all = new ArrayList<>(); 
    
    public ConferenceListDTO(List<Conference> conferenceList) {
        conferenceList.forEach((c) -> {
            all.add(new ConferenceDTO(c));
            });
    }
    
    public List<ConferenceDTO> getAll() {
        return all;
    }
}
