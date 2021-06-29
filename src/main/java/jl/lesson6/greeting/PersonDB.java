package jl.lesson6.greeting;

import java.sql.*;

public class PersonDB extends MysqlConnect {

    public PersonDB(String url, String user, String password) throws Exception{
        super(url, user, password);
    }

    public void add(String firstName, String secondName) throws Exception {
        String query = "INSERT INTO `person` (`id`, `firstname`, `lastname`) VALUES (NULL, ?, ?);";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setString(1,firstName);
        preparedStatement.setString(2, secondName);
        preparedStatement.executeUpdate();
    }

    public Person getPersonByID(int id) throws Exception{
        Person person = new Person();
        String query = "SELECT * FROM `person` WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);

        ResultSet rs  = preparedStatement.executeQuery();

        while (rs.next()){
            person.setFirstName(rs.getString(2));
            person.setLastName(rs.getString(3));
        }
        return person;
    }
}
