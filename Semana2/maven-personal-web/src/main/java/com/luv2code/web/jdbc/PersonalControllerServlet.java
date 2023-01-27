package com.luv2code.web.jdbc;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/PersonalControllerServlet")
public class PersonalControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PersonalDbUtil personalDbUtil;
//	name="jdbc/web_student_tracker" 
//	url="jdbc:mysql://localhost:3306/web_student_tracker?useSSL=false"
	@Resource(name="jdbc/web_personal")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			personalDbUtil = new PersonalDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listAllPersonal(request, response);
				break;
				
			case "ADD":
				addPersonal(request, response);
				break;
				
			case "LOAD":
				loadPersonal(request, response);
				break;
				
			case "UPDATE":
				updatePersonal(request, response);
				break;
			
			case "DELETE":
				deletePersonal(request, response);
				break;
			case "ENTRADA":
				personalEntradaSalida(request, response);
				break;
			case "SALIDA":
				personalEntradaSalida(request, response);
				break;
			default:
				listAllPersonal(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void personalEntradaSalida(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			String thePersonaltId = request.getParameter("personalId");
			String tipo = request.getParameter("command");
//			dd/MM/uuuu 
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
			if(tipo.equals("ENTRADA")) {
				personalDbUtil.checkeEntradaSalidaPersonal(thePersonaltId,dtf.format(LocalDateTime.now()),"hora_entrada");
			}else {
				personalDbUtil.checkeEntradaSalidaPersonal(thePersonaltId,dtf.format(LocalDateTime.now()),"hora_salida");
			}

			
			
			listAllPersonal(request, response);
		}
	
	private void deletePersonal(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		String thePersonaltId = request.getParameter("personalId");
		
		personalDbUtil.deletePersonal(thePersonaltId);
		
		listAllPersonal(request, response);
	}

	private void updatePersonal(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		int id = Integer.parseInt(request.getParameter("personalId"));
		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		
		Personal thePersonal = new Personal(id, nombres, apellidos,"","");
		
		personalDbUtil.updatePersonal(thePersonal);
		
		listAllPersonal(request, response);
		
	}

	private void loadPersonal(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		String thePersonaltId = request.getParameter("personalId");
		
		Personal thePersonal = personalDbUtil.getPersonal(thePersonaltId);
		
		request.setAttribute("THE_PERSONAL", thePersonal);
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-personal-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addPersonal(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student info from form data
		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");	
		
		Personal thePersonal = new Personal(nombres, apellidos);
		
		personalDbUtil.addPersonal(thePersonal);
				
		listAllPersonal(request, response);
	}

	private void listAllPersonal(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		List<Personal> allpersonal = personalDbUtil.getAllPersonal();
		
		request.setAttribute("PERSONAL_LIST", allpersonal);
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-personal.jsp");
		dispatcher.forward(request, response);
	}

}













