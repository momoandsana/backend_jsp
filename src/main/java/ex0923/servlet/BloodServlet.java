package ex0923.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BloodServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String name = request.getParameter("name");
//        String blood=request.getParameter("blood");

        RequestDispatcher rd = request.getRequestDispatcher("Blood.jsp");
        rd.forward(request, response);
    }
}
