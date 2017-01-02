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

public class ContactDao {

	private Connection connection;

	//getting the connection in the constructor
	public ContactDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void create(Contact contact) {
		
		//string with SQL command
		String sql = "insert into contacts (name, email, address, birthDate) values (?,?,?,?)";

		try {
			// prepare statement for insertion
			PreparedStatement stmt = connection.prepareStatement(sql);

			// set the values
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAddress());
			stmt.setDate(4, new Date(contact.getBirthDate().getTimeInMillis()));

			// execute preparedStatement
			stmt.execute();

			stmt.close();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contact> getList() {
		try {
			// creating a list of contacts
			List<Contact> contacts = new ArrayList<Contact>();

			// prepare statement for list
			PreparedStatement stmt = this.connection.prepareStatement("select * from contacts");

			// execute a select
			ResultSet rs = stmt.executeQuery();

			// iterate in ResultSet
			while (rs.next()) {

				Contact contact = new Contact();

				// filling Contact Object
				contact.setId(rs.getLong("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));

				// mounting the date through calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("birthdate"));
				contact.setBirthDate(data);

				// adding object to list
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

	public Contact selectById(int id) {

		Contact contact = new Contact();
		
		try {
			// prepare statement for list
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from contacts where id = " + id);

			// execute a select
			ResultSet rs = stmt.executeQuery();

			// filling Contact Object
			if (rs.next()) {
				contact.setId(rs.getLong("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
			}
			
			rs.close();
			stmt.close();
			connection.close();

			return contact;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public void update (Contact contact){
		
		//String with SQL command
		String sql = "update contacts set name=?, email=?, address=?, birthdate=? where id=?";
		
		try{
			// prepare statement for update
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			// set the values
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
	
	public void delete(Contact contact){
		
		try{
			PreparedStatement stmt = connection.prepareStatement("delete from contacts where id=?");
			
			stmt.setLong(1, contact.getId());
			
			stmt.execute();
			
			stmt.close();
			
		} catch (SQLException e){
			throw new DAOException (e);
		}
	}
}
