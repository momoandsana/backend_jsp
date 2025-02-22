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
//        resp.sendRedirect("life");
        // get 은 url 에 쿼리문이 붙어서 옴
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
//        resp.sendRedirect("life");

        System.out.println("Received post request");
        // post 는 url 깔끔하게 옴
    }

    @Override
    //protected service를 넣어야 함. service 오버라이드 하면 doGet doPost 자동으로 요청이 가지 않는다
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service");

        //전송된 정보를 받기
        String userId = req.getParameter("userId");// <input name="userId"
        String userName = req.getParameter("userName");// <input name="userId"
        String userPwd = req.getParameter("userPwd");// <input name="userId"

        System.out.println(" userId="+userId);
        System.out.println(" userName="+userName);
        System.out.println(" userPwd="+userPwd);

        super.service(req, resp); // 오버라이딩 했지만 이 코드 덕분에 자동으로 다시 doGet, doPost 자동으로 요청
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
        super.destroy();
    }
}
