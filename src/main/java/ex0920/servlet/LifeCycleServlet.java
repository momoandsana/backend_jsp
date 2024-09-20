package ex0920.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LifeCycleServlet extends HttpServlet {

    public LifeCycleServlet() {
        super();
        System.out.println("Servlet created");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 응답 유형과 인코딩 설정
        resp.setContentType("text/html"); // 응답하는 부분이니까
        resp.setCharacterEncoding("UTF-8");

        // 응답 출력
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1 style='color:blue'>LifeCycleServlet - GET 요청 처리 호석!!</h1>");
        out.println("</body></html>");
//        브라우저에서는 get 요청만 가능
        System.out.println("Received get request");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // POST 요청 처리 로직
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>LifeCycleServlet - POST 요청 처리</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
