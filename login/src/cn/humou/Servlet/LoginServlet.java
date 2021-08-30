package cn.humou.Servlet;

import cn.humou.Bean.User;
import cn.humou.Dao.Userdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=gbk");
        User loginuser = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");


        //3.先获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        System.out.println(checkCode_session);
        System.out.println("-------------");
        System.out.println(checkcode);
        //删除session中存储的验证码
        session.removeAttribute("checkCode_session");
        //4.再判断验证码是否正确
        if(checkCode_session != null && checkCode_session.equalsIgnoreCase(checkcode)){
            //忽略大小写比较
            //验证码正确
            //判断用户名和密码是否一致

            loginuser.setUsername(username);
            loginuser.setPassword(password);

            Userdao userdao = new Userdao();
            User user = userdao.login(loginuser);
            System.out.println(user);

            if(user != null){

                session.setAttribute("user",username);

                //重定向到succes.jsp
                response.sendRedirect(request.getContextPath()+"/Interface/success.jsp");
//                response.getWriter().write("登录成功");
            }else{
                request.setAttribute("login_error","用户名或密码错误");
                //转发到登录界面
                request.getRequestDispatcher("/Interface/login.jsp").forward(request,response);
//                response.getWriter().write("登录失败");
            }
//            if(("humou".equals(username)) && "123".equals(password)){
//                //登录成功
//                //存储信息，用户信息
//                session.setAttribute("user",username);
//
//                //重定向到succes.jsp
//                response.sendRedirect(request.getContextPath()+"/success.jsp");
//            }else {
//                //登录失败
//                //存储提示信息到request
//
//                request.setAttribute("login_error","用户名或密码错误");
//                //转发到登录界面
//                request.getRequestDispatcher("login.jsp").forward(request,response);
//            }


        }else {
            //验证码不一致
            //存储提示信息到request
            request.setAttribute("cc_error","验证码错误");
            //转发到登录界面
//            response.getWriter().write("&lt;script &gt; alert('验证码错误') &lt;/script &gt;");
            PrintWriter out = response.getWriter();
//            out.flush();
//            out.println("<script>");
//            out.println("alert('验证码错误');");
//
//            out.println("</script>");
//            out.flush();
//            out.println("<script>");
//            out.println("alert('下载文件不存在！');");
//            out.println("window.close();");
//            out.println("</script>");




//            response.sendRedirect(request.getContextPath()+"/Interface/login.jsp");
            out.print("<script type='text/javascript'>alert('登录失败');");
            out.print("location.href='/day15/Interface/login.jsp';");
            out.print("</script>");

//            out.close();
//            request.getRequestDispatcher("/Interface/login.jsp").forward(request,response);
        }
//        System.out.println("-----------");
//
//        loginuser.setUsername(username);
//        loginuser.setPassword(password);
//
//        Userdao userdao = new Userdao();
//        User user = userdao.login(loginuser);
//        System.out.println(user);
//
//        if(user != null){
//            response.getWriter().write("登录成功");
//        }else{
//            response.getWriter().write("登录失败");
//        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
