package ex0923.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
//form 에서는 action="blood"
@WebServlet(name="bloodServlet",urlPatterns = "/blood",loadOnStartup = 1)
public class BloodServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init started");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String name = request.getParameter("name");
//        String blood=request.getParameter("blood");

//        RequestDispatcher rd = request.getRequestDispatcher("Blood.jsp"); //webapp(루트) 밑에 있으니까
//        rd.forward(request, response);

       request.getRequestDispatcher("Blood.jsp").forward(request, response);
    }
}
