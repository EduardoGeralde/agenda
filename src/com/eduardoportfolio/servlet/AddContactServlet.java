package com.eduardoportfolio.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eduardoportfolio.jdbc.dao.ContactDao;
import com.eduardoportfolio.jdbc.model.Contact;

/**
 * @author Eduardo Geralde Neto
 * 
 * This class just give us a example to demonstrate some tools that can be used in a Servlet. Here, this tools
 *  don't really make any sense, like "urlPatterns", "initParams", "init", "destroy", "doPost", "PrintWriter".
 * 
 * This Servlet was created to show how a Servlet could work, generating HTML through PrintWriter. 
 * However, mixing HTML with Java is not recommended because it makes difficult to read and 
 * maintain the code. In fact, we have to remove the HTML code and redirect with RequestDispatcher to 
 * a JSP page that will generate all the HTML code that we need. This example application only gives us 
 * an idea of some possible ways and tools.
 */

//Passing parameters in the initialization
@WebServlet(name = "AddServlet", urlPatterns = {"/addContact","/add"},
			initParams = { @WebInitParam(name= "param1", value= "Contact "),
						@WebInitParam(name="param2", value=" added successfully")})

public class AddContactServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	//This method allows us to load  in the initialization of the Servlet some files of configuration 
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
		
		//Filling a contact object
		Contact contact = new Contact();
		contact.setName(name);
		contact.setAddress(address);
		contact.setEmail(email);
		contact.setBirthDate(birthDate);
		
		//Persisting contact
		ContactDao dao = new ContactDao();
		dao.create(contact);
		
		//Generating HTML using PrintWriter, bad practice, mixing with Java.
		out.println("<html>");
		out.println("<body>");
		out.println(getServletConfig().getInitParameter("param1"));
		out.println(contact.getName());
		out.println(getServletConfig().getInitParameter("param2"));
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
