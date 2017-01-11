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
 * This Servlet was created to show how a Servlet could work, generating HTML through PrintWriter. 
 * However, mixing HTML with Java is not recommended because it makes difficult to read and 
 * maintain the application code. Let's then remove the HTML code and we'll redirect with 
 * RequestDispatcher to a JSP page that will generate all the HTML code that we need. This example 
 * application only gives us an idea of some possible ways and tools. Let's evolve our application by 
 * separating actions (business rules) into different classes with the same Logic interface. 
 * We will also create a Servlet Controller to control the flow of actions, and after executing the action, 
 * will redirects to a JSP pages.
 */

@WebServlet("/addContact")
public class AddContactServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	//This method allows us to load  in the initialization of the servlet some files of configuration 
	//of the application, or something else needed.
	@Override
	public void init (ServletConfig config) throws ServletException {
		super.init(config);
		log("Starting the servlet");
	}
	
	//We  can also release possible resources that we are holding
	@Override
	public void destroy(){
		super.destroy();
		log("Destroying the servlet");
	}
	
	@Override
	//Instead using service, the doPost method only accept post methods (inside body)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
										throws ServletException, IOException {
		//Search the writer
		PrintWriter out = response.getWriter();
		
		//Search for parameters in the request
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String dateInText = request.getParameter("birthDate");
		Calendar birthDate = null;
		
		//Date conversion
		try{
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateInText);
			birthDate = Calendar.getInstance();
			birthDate.setTime(date);
			
		} catch (ParseException e){
			out.println("Date Conversion Error");
			return;
		}
		
		//Mounts a contact object
		Contact contact = new Contact();
		contact.setName(name);
		contact.setAddress(address);
		contact.setEmail(email);
		contact.setBirthDate(birthDate);
		
		//Persist contact
		ContactDao dao = new ContactDao();
		dao.create(contact);
		
		//Removing HTML code to dispatch to a JSP that will do the job.
		
		//out.println("<html>");
		//out.println("<body>");
		//out.println("Contact " + contact.getName() + " added successfully ");
		//out.println("</body>");
		//out.println("</html>");
		
		//Dispatching to a JSP
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/contactAdded.jsp");
		rd.forward(request, response);
		
	}
	
}
