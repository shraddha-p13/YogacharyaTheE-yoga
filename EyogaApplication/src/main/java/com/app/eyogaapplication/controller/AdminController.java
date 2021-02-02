package com.app.eyogaapplication.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.eyogaapplication.service.InstructorService;
 
@RestController
public class AdminController 
{
 
    @Autowired
   private InstructorService service;
    
    @RequestMapping(value="/test")
    public String test() {
    	return "test";
    }
 
/*    @RequestMapping(value= "/instructor/all", method= RequestMethod.GET)
    public Iterable<InstructorData> getInstructor() {
        System.out.println(this.getClass().getSimpleName() + " - Get all employees service is invoked.");
        return service.getInstructorData();
    }
 
    @RequestMapping(value= "/instructor/{id}", method= RequestMethod.GET)
    public InstructorData getInstructorById(@PathVariable int id) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Get instructor details by id is invoked.");
 
        Optional<InstructorData> instruct =  service.getInstructorById(id);
        if(!instruct.isPresent())
            throw new Exception("Could not find instructor with id- " + id);
 
        return instruct.get();
    }
 
    @RequestMapping(value= "/instructor/add", method= RequestMethod.POST)
    public InstructorData createInstructor(@RequestBody InstructorData newinstruct) {
        System.out.println(this.getClass().getSimpleName() + " - Create new instructor method is invoked.");
        return service.addNewInstructor(newinstruct);
    }
 
    @RequestMapping(value= "/instructor/update/{id}", method= RequestMethod.PUT)
    public InstructorData updateInstructor(@RequestBody InstructorData updinstruct, @PathVariable int id)
    		throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Update instructor details by id is invoked.");
 
        Optional<InstructorData> instruct =  service.getInstructorById(id);
        if (!instruct.isPresent())
            throw new Exception("Could not find instructor with id- " + id);
 
         IMPORTANT - To prevent the overriding of the existing value of the variables in the database, 
         * if that variable is not coming in the @RequestBody annotation object.     
        if(updinstruct.getFname() == null || updinstruct.getFname().isEmpty())
            updinstruct.setFname(instruct.get().getFname());
        if(updinstruct.getLname() == null || updinstruct.getLname().isEmpty())
            updinstruct.setLname(instruct.get().getLname());
        if(updinstruct.getContactno() == null)
             updinstruct.setContactno(instruct.get().getContactno());
        if(updinstruct.getEmail() == null || updinstruct.getEmail().isEmpty())
            updinstruct.setEmail(instruct.get().getEmail());
        if(updinstruct.getUsername() == null || updinstruct.getUsername().isEmpty())
            updinstruct.setUsername(instruct.get().getUsername());
        if(updinstruct.getPassword() == null || updinstruct.getPassword().isEmpty())
            updinstruct.setPassword(instruct.get().getPassword());
 
        // Required for the "where" clause in the sql query template.
        updinstruct.setId(id);
        return service.updateInstructor(updinstruct);
    }
 
    @RequestMapping(value= "/instructor/delete/{id}", method= RequestMethod.DELETE)
    public void deleteInstructorById(@PathVariable int id) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Delete instructor by id is invoked.");
 
        Optional<InstructorData> instructor =  service.getInstructorById(id);
        if(!instructor.isPresent())
            throw new Exception("Could not find instructor with id- " + id);
 
        service.deleteInstructorById(id);
    }
 
    @RequestMapping(value= "/Instructor/deleteall", method= RequestMethod.DELETE)
    public void deleteAll() {
        System.out.println(this.getClass().getSimpleName() + " - Delete all instructor is invoked.");
        service.deleteAllInstructor();
    }*/
}