/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.RentalArrangement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 45319
 */
public class ArrangementsListDTO {
    
    List<RentalArrangementDTO> all = new ArrayList<>(); 
    
    public ArrangementsListDTO(List<RentalArrangement> raEntities) {
        raEntities.forEach((ra) -> {
            all.add(new RentalArrangementDTO(ra));
            });
    }
    
    public List<RentalArrangementDTO> getAll() {
        return all;
    }
    
}
