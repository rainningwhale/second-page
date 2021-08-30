package cn.humou.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletTEST")
public class ServletTEST extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8"); //转码
        PrintWriter out = response.getWriter();
//        out.flush();
//        out.println("<script>");
//        out.println("alert('下载文件不存在！');");
//        out.println("window.close();");
//        out.println("</script>");
//
//        out.print("<script>alert('非常简单！！');</script>");
//        out.close();
        out.print("<script type='text/javascript'>alert('登录失败');");
        out.print("location.href='/day15/Interface/login.jsp';");
        out.print("</script>");

//        response.getWriter().write("&lt;script &gt; alert('验证码错误'); &lt;/script &gt;");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
