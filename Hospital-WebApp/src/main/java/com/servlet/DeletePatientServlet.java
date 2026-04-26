package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import com.dao.HospitalDAO;

@WebServlet("/DeletePatientServlet")
public class DeletePatientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    int id = Integer.parseInt(request.getParameter("patientId"));

	    HospitalDAO dao = new HospitalDAO();
	    boolean status = dao.deletePatient(id);

	    if (status) {
	        // success → go to list
	        response.sendRedirect("DisplayPatientsServlet");
	    } else {
	        // not found → error page
	        response.sendRedirect("error.jsp");
	    }
	}
}