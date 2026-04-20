/*10.b Build an Application to get Rollno, Studentname, Sub1, Sub2, Sub3, Sub4 and Sub5 through JSP
called index.jsp with client sided validation and submit to the servlet called ResultServlet and process all
the fields with server sided validation and display all the data along with result ( Pass if all subjects
greater than 40%) and Average marks through result.jsp with a link to move to the client side*/

package com.result;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String roll = request.getParameter("roll");
        String name = request.getParameter("name");

        String message = "";

        try {
            int s1 = Integer.parseInt(request.getParameter("s1"));
            int s2 = Integer.parseInt(request.getParameter("s2"));
            int s3 = Integer.parseInt(request.getParameter("s3"));
            int s4 = Integer.parseInt(request.getParameter("s4"));
            int s5 = Integer.parseInt(request.getParameter("s5"));

            // Server validation
            if (roll.isEmpty() || name.isEmpty()) {
                message = "Error: Roll No and Name required";
            } 
            else if (s1<0||s1>100 || s2<0||s2>100 || s3<0||s3>100 || s4<0||s4>100 || s5<0||s5>100) {
                message = "Error: Marks must be between 0 and 100";
            } 
            else {

                String result;
                if (s1>=40 && s2>=40 && s3>=40 && s4>=40 && s5>=40)
                    result = "PASS";
                else
                    result = "FAIL";

                double avg = (s1 + s2 + s3 + s4 + s5) / 5.0;

                request.setAttribute("roll", roll);
                request.setAttribute("name", name);
                request.setAttribute("s1", s1);
                request.setAttribute("s2", s2);
                request.setAttribute("s3", s3);
                request.setAttribute("s4", s4);
                request.setAttribute("s5", s5);
                request.setAttribute("avg", avg);
                request.setAttribute("result", result);

                message = "Processed Successfully";
            }

        } catch(Exception e) {
            message = "Error: Invalid input";
        }

        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}