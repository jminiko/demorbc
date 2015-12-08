/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.iniko.services;

import info.iniko.models.Pet;
import java.util.List;

/**
 *
 * @author jminiko
 */

public interface PETService {
    
    public Pet findById(Long id);
    public void delete(Long id);
    public Pet save(Pet pet);
}
