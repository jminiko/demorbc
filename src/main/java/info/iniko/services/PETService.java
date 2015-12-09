/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.iniko.services;

import info.iniko.models.Pet;
import org.springframework.security.access.annotation.Secured;

/**
 *
 * @author jminiko
 */

public interface PETService {
    @Secured({"ROLEA","ROLEB"})
    public Pet findById(Long id);
    @Secured({"ROLEB"})
    public void delete(Long id);
    @Secured({"ROLEB"})
    public Pet save(Pet pet);
}
