package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.dao.HospitalDAO;

@WebServlet("/DisplayPatientsServlet")
public class DisplayPatientsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HospitalDAO dao = new HospitalDAO();

        String search = request.getParameter("search");

        ArrayList<String[]> list;

        // ✅ FIXED LOGIC
        if (search != null && search.trim().length() > 0) {
            list = dao.searchPatients(search.trim());
        } else {
            list = dao.getAllPatients();
        }

        request.setAttribute("data", list);

        RequestDispatcher rd = request.getRequestDispatcher("patientdisplay.jsp");
        rd.forward(request, response);
    }
}