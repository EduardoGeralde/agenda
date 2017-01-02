package com.eduardoportfolio.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eduardoportfolio.jdbc.dao.ContactDao;
import com.eduardoportfolio.jdbc.model.Contact;

@WebServlet("/addContact")
public class AddContactServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	//instead using service, the doPost method only accept post methods 
	//(inside body protocol HTTP)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
										throws ServletException, IOException {
		//search the writer
		PrintWriter out = response.getWriter();
		
		//search for parameters in the request
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String dateInText = request.getParameter("birthDate");
		Calendar birthDate = null;
		
		//doing the date conversion
		try{
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateInText);
			birthDate = Calendar.getInstance();
			birthDate.setTime(date);
			
		} catch (ParseException e){
			out.println("Date Conversion Error");
			return;  //stop the method execution
		}
		
		//mounts a contact object
		Contact contact = new Contact();
		contact.setName(name);
		contact.setAddress(address);
		contact.setEmail(email);
		contact.setBirthDate(birthDate);
		
		//persist contact
		ContactDao dao = new ContactDao();
		dao.create(contact);
		
		//print the name of the contact that was add
		out.println("<html>");
		out.println("<body>");
		out.println("Contact " + contact.getName() + " added successfully ");
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
