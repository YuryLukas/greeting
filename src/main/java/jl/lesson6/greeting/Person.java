package jl.lesson6.greeting;

import java.io.FileWriter;
import java.lang.Exception;

public class Person {
    private String firstName;
    private String lastName;
    //?serverTimezone=UTC&useSSL=false
    PersonDB dbPerson = new PersonDB("jdbc:mysql://localhost:3306/person?useSSL=false", "phpmyadmin","password");

    public Person() throws Exception { }

    public Person(int id) throws Exception {
        Person person = dbPerson.getPersonByID(id);
        this.setFirstName(person.getFirstName());
        this.setLastName(person.getLastName());
    }

    Person(String firstName, String lastName) throws Exception {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("person.txt",true);
            writer.write(this.toString());
            writer.close();
        } catch (Exception e) {
            System.out.println("Ошибка записи в файл!");
        }
    }

    public void saveToDb() throws Exception{
        dbPerson.add(this.getFirstName(), this.getLastName());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
