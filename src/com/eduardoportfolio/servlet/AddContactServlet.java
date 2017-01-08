package com.eduardoportfolio.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eduardoportfolio.jdbc.dao.ContactDao;
import com.eduardoportfolio.jdbc.model.Contact;

/**
 * @author Eduardo Geralde Neto
 * 
 * This class shows how Servlets can works. We have some problems using Servlets, like, it strongly mixing
 * HTML with Java, and if we want to list all contacts, all this list would be doing through out.print().
 * We can imagine  the maintenance of all that code. And if we want to add a new column in the table?
 * We have better ways to do this  functionalities.
 */

@WebServlet("/addContact")
public class AddContactServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	//this method allows us to load  in the initialization of the servlet some files of 
	//configuration of the application, or something else needed
	@Override
	public void init (ServletConfig config) throws ServletException {
		super.init(config);
		log("Starting the servlet");
	}
	
	//we  can also release possible resources that we are holding
	@Override
	public void destroy(){
		super.destroy();
		log("Destroying the servlet");
	}
	
	@Override
	//instead using service, the doPost method only accept post methods (inside body)
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
		
		//print the name of the contact that was added, in HTML
		//out.println("<html>");
		//out.println("<body>");
		//out.println("Contact " + contact.getName() + " added successfully ");
		//out.println("</body>");
		//out.println("</html>");
		
		//but, we are mixing HTML with Java. Let's improve this code
		
		//Now we going to redirect for another JSP and delete all HTML
		//in this code. Let's put java in Servlets and HTML in JSP.
		RequestDispatcher rd = request.getRequestDispatcher("/contactAdded.jsp");
		rd.forward(request, response);
		
	}
	
}
