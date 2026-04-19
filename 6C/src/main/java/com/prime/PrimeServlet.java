/*6c. Build a servlet program to check the given number is prime number or not using HTML with step by
step procedure.*/

package com.prime;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/prime")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Get input
            int number = Integer.parseInt(request.getParameter("number"));

            // Validation
            if (number < 0) {
                throw new IllegalArgumentException("Number cannot be negative");
            }

            // Prime check logic
            boolean isPrime = true;

            if (number <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            // Output HTML
            out.println("<html><body>");
            out.println("<h2>Prime Number Result</h2>");
            out.println("<p>Entered Number: " + number + "</p>");

            if (isPrime) {
                out.println("<p style='color:green;'>" + number + " is a Prime Number</p>");
            } else {
                out.println("<p style='color:red;'>" + number + " is NOT a Prime Number</p>");
            }

            out.println("<a href='index.html'>Check Another Number</a>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            showError(out, "Invalid input! Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            showError(out, e.getMessage());
        }
    }

    private void showError(PrintWriter out, String message) {
        out.println("<html><body>");
        out.println("<h2 style='color:red;'>Error</h2>");
        out.println("<p>" + message + "</p>");
        out.println("<a href='index.html'>Try Again</a>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}