package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HospitalDAO;

@WebServlet("/UpdatePatientServlet")
public class UpdatePatientServlet extends HttpServlet {

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

        boolean status = dao.updatePatient(id, name, age, gender, date, ailment, doctor);

        if(status) {
            response.sendRedirect("DisplayPatientsServlet");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}