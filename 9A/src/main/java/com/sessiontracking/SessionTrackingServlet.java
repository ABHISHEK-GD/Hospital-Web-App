/*9.a Build a Session Management using Servlet program ( withou using html)  set with one minute session  to show Session Tracking Information, Session ID,Session Creation Time,Last Access Time,Visit Count
*/

package com.sessiontracking;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.*;
import javax.servlet.http.*;
import java.util.Date;


@WebServlet("/SessionTracker")
public class SessionTrackingServlet extends HttpServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get the session object
        // If session doesn't exist, create a new one
        HttpSession session = request.getSession(true);
        
        // Get the session creation time
        Date createTime = new Date(session.getCreationTime());
        
        // Get the last access time
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        
        // Get the session ID
        String sessionId = session.getId();
        
        // Get the visit count from session
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }
        
        // Store the updated visit count in session
        session.setAttribute("visitCount", visitCount);
        
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Generate HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Session Tracking Demo</title></head>");
        out.println("<body>");
        out.println("<h2>Session Tracking Information</h2>");
        out.println("<p>Session ID: " + sessionId + "</p>");
        out.println("<p>Session Creation Time: " + createTime + "</p>");
        out.println("<p>Last Access Time: " + lastAccessTime + "</p>");
        out.println("<p>Visit Count: " + visitCount + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
