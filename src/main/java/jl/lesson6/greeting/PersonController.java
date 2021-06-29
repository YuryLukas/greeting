package jl.lesson6.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @GetMapping("/person")
	public Person getPerson(@RequestParam(value = "id") int id) throws Exception{
		//Person person = new Person();
        //return person.getPersonById();
	    return new Person(id);
    }

    @PostMapping("/person")
    public void savePerson(@RequestParam(value = "firstname") String firstName, 
                            @RequestParam(value = "lastname") String lastName) throws Exception {
        Person person = new Person(firstName, lastName);
        person.saveToFile();
        person.saveToDb();
    }
}
