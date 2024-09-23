package ex0923.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */
public class LoginServlet extends HttpServlet {
    String dbId="jang",dbPwd="1234";


    public LoginServlet() {
        System.out.println("loginServlet created");
    }

    /**
     *  요청을 처리할 메소드 재정의
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");


        //전송된 데이터를 받기, html 의 name 으로 구분
        // request.getParameter 는 기본으로  String 형식
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        // 나중에 convert 해야 한다

        //name='hobby'여러개
        //String hobby= request.getParameter("hobby");
        String[] hobbies = request.getParameterValues("hobby");

        System.out.println("id = " + id);
        System.out.println("pwd = " + pwd);
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        for(String h:hobbies)
        {
            System.out.println(h);
        }

        //id와 비번이 일치하면 LoginOk.jsp , 아니면 폼으로 이동, null 이 되지 않는 것을 equals 의 앞으로
        if(dbId.equals(id) && dbPwd.equals(pwd))
        {
//            name = URLEncoder.encode(name, "UTF-8");
//            // WAS 에서 브라우저로 보내는 경우 인코딩 필요
//
//            // 새로운 request, response 를 생성해서 이동한다
//            response.sendRedirect("LoginOk.jsp?name="+name);
//            이전의 request 정보들은 유지되지 않는다->라다이렉트이기 때문에
              //리다이렉트이기 때문에 정보를 직접 넣어서 보내야 한다

//            -----------------------------------------

              // forward 방식으로 이동하기
            RequestDispatcher rd = request.getRequestDispatcher("LoginOk.jsp");
            rd.forward(request, response); // 현재의 request 와 response 를 유지한다
            // forward 이므로 url 이동이 없다
        }
        else
        {
            response.setContentType("text/html;charset=UTF-8");
            // 에러메시지 출력
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('login fail 정보 다시 확인해')");
//            out.println("location.href='HobbyForm.html'");
            out.println("history.back()");
            out.println("</script>");
            //브라우저에서 먼저 리다이렉트하기 때문에 위의 코드는 실행되지 않는다

//            response.sendRedirect("HobbyForm.html");
        }

    }
}






















