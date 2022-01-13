/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Speaker;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebastianengelbrecht
 */
public class SpeakerListDTO {
    
      List<SpeakerDTO> all = new ArrayList<>(); 
    
    public SpeakerListDTO(List<Speaker> speakerList) {
        speakerList.forEach((s) -> {
            all.add(new SpeakerDTO(s));
            });
    }
    
    public List<SpeakerDTO> getAll() {
        return all;
    }
    
}
