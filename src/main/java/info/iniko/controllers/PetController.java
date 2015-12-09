/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.iniko.controllers;

import info.iniko.models.Pet;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import info.iniko.services.PETService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author jminiko
 */
@RestController
public class PetController {
    
    private final PETService pojoService;
    
    @Autowired
    public PetController(final PETService service) {
        this.pojoService = service;
    }
    
    public PetController(){
        pojoService = null;
    }
    
    @RequestMapping(value = "/pet/{petId}", method = RequestMethod.GET)
    public void findPet(@PathVariable String petId) {
        pojoService.findById(Long.valueOf(petId));
    }
    
    @RequestMapping(value = "/pet/{petId}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable String petId) {
        pojoService.delete(Long.valueOf(petId));
    }
    @RequestMapping(value = "/pet/{petId}", method = RequestMethod.POST)
    public Pet createPet(@PathVariable String petId,
                         @RequestBody @Valid final Pet pet) {
        Pet p = null;
        try{
            p = pojoService.save(pet);
            if(p==null)
                throw new PetNotFoundException(petId);
        }catch(Exception ex){
            throw new PetNotFoundException(petId);
        }
        return p;
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    class PetNotFoundException extends RuntimeException {

	public PetNotFoundException(String petId) {
		super("could not find pet '" + petId + "'.");
	}
}
}
