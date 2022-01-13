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
public class TalkListDTO {
    
    List<TalkDTO> all = new ArrayList<>(); 
    
    public TalkListDTO(List<Talk> talkList) {
        talkList.forEach((t) -> {
            all.add(new TalkDTO(t));
            });
    }
    
    public List<TalkDTO> getAll() {
        return all;
    }
}

