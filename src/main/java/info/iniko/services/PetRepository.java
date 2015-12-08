/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.iniko.services;

import info.iniko.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jminiko
 */
public interface PetRepository extends JpaRepository<Pet, Long>{
    
}
