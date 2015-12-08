/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.iniko.testservice;

import info.iniko.services.PETServiceImpl;
import info.iniko.services.PetRepository;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.util.Assert;
import info.iniko.services.PETService;

/**
 *
 * @author jminiko
 */
@RunWith(MockitoJUnitRunner.class) 
public class POJOTestService {
    @Mock
    PetRepository repo;        
            
    PETService service;
    
    @Before
    public void setUp(){
        service = new PETServiceImpl(repo);
    }
    
    @Test
    public void testFindAll(){
        List collection = service.findAll();
        System.out.println(collection);
        Assert.notNull(collection);
    }
}
