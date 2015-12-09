/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.iniko.services;

import info.iniko.models.Pet;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

/**
 *
 * @author jminiko
 */
@Service
public class PETServiceImpl implements PETService{

    private final PetRepository repository;

    public PETServiceImpl(){
        repository = null;
    }
    
    public PETServiceImpl(PetRepository petRepository){
        repository = petRepository;
    }
    @Override 
    public void delete(Long id) {
        repository.delete(id);
    }

    public Pet findById(Long id){
        return repository.findOne(id);
    }
    
    @Override
    public Pet save(Pet pet) {
        return repository.save(pet);
    }
    
}
