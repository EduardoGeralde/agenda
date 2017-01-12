package com.eduardoportfolio.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.eduardoportfolio.jdbc.ConnectionFactory;
import com.eduardoportfolio.jdbc.exception.DAOException;
import com.eduardoportfolio.jdbc.model.Contact;

/**
 * @author Eduardo Geralde Neto
 * 
 * This ContactDao class has our CRUD. This represents our basics methods of persistent storage.
 * The only responsible to access and change our data in BD.
 */


public class ContactDao {

	private Connection connection;

	//Getting the connection from the filter (injection of dependencies)
	public ContactDao(Connection connection) {
		this.connection = connection;
	}

	//Creating (add) contact in DB
	public void create(Contact contact) {
		
		//String with SQL command
		String sql = "insert into contacts (name, email, address, birthDate) values (?,?,?,?)";

		try { 
			//Prepare statement for insertion
			PreparedStatement stmt = connection.prepareStatement(sql);

			//Set the values
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAddress());
			stmt.setDate(4, new Date(contact.getBirthDate().getTimeInMillis()));

			//Execute PreparedStatement
			stmt.execute();

			stmt.close();
			connection.close();

		} catch (SQLException e) {
			throw new DAOException(e);
		} 
	}

	//List all contacts in DB
	public List<Contact> getList() {
		try {
			//Creating a list of contacts
			List<Contact> contacts = new ArrayList<Contact>();

			//Prepare statement for list
			PreparedStatement stmt = this.connection.prepareStatement("select * from contacts");

			//Execute a select
			ResultSet rs = stmt.executeQuery();

			//Iterate in ResultSet
			while (rs.next()) {

				Contact contact = new Contact();

				//Filling Contact Object
				contact.setId(rs.getLong("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));

				//Preparing the format of date to calendar
				Calendar date = Calendar.getInstance();
				date.setTime(rs.getDate("birthdate"));
				contact.setBirthDate(date);

				//Adding object to list
				contacts.add(contact);
			}

			rs.close();
			stmt.close();
			connection.close();

			return contacts;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	//List contact by given id
	public Contact selectById(Long id) {

		Contact contact = new Contact();
		
		try {
			//Prepare statement for list
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from contacts where id = " + id);

			//Execute a select
			ResultSet rs = stmt.executeQuery();

			//Filling Contact Object
			if (rs.next()) {
				contact.setId(rs.getLong("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
				
				//Mounting the date through calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("birthdate"));
				contact.setBirthDate(data);
			}
			
			rs.close();
			stmt.close();
			connection.close();

			return contact;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	//Update contact in DB
	public void update (Contact contact){
		
		//String with SQL command
		String sql = "update contacts set name=?, email=?, address=?, birthdate=? where id=?";
		
		try{
			//Prepare statement for update
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			//Set the values
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAddress());
			stmt.setDate(4, new Date (contact.getBirthDate().getTimeInMillis()));
			stmt.setLong(5, contact.getId());
			
			stmt.execute();
			
			stmt.close();
			connection.close();
			
		} catch (SQLException e){
			throw new DAOException(e);
		}
	}
	
	//Delete contact of the DB
	public void delete(Contact contact){
		
		try{
			//Prepare statement for delete
			PreparedStatement stmt = connection.prepareStatement("delete from contacts where id=?");
			
			//Set the values
			stmt.setLong(1, contact.getId());
			
			stmt.execute();
			
			stmt.close();
			
		} catch (SQLException e){
			throw new DAOException (e);
		}
	}
}
