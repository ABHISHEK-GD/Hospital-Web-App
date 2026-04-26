package com.servlet;

import java.io.IOException;
import java.util.List;

import com.dao.HospitalDAO;
import com.model.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fromDate = request.getParameter("fromDate");
        String toDate = request.getParameter("toDate");
        String ailment = request.getParameter("ailment");
        String doctor = request.getParameter("doctor");

        HospitalDAO dao = new HospitalDAO();

        List<Patient> list = dao.getReport(fromDate, toDate, ailment, doctor);

        request.setAttribute("list", list);

        request.getRequestDispatcher("report_result.jsp").forward(request, response);
    }
}