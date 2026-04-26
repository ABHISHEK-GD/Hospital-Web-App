package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.dao.HospitalDAO;

@WebServlet("/AddPatientServlet")
public class AddPatientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String date = request.getParameter("date");
        String ailment = request.getParameter("ailment");
        String doctor = request.getParameter("doctor");

        HospitalDAO dao = new HospitalDAO();

        boolean status = dao.addPatient(id, name, age, gender, date, ailment, doctor);

        if (status) {
            RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
            rd.forward(request, response);
        } else {
            response.getWriter().println("Error Occurred!");
        }
    }
}