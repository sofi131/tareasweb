package com.ceica.tareasweb.servlets;

import com.ceica.tareasweb.controller.TaskController;
import com.ceica.tareasweb.models.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       request.getRequestDispatcher("login.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String user=request.getParameter("user");
        String pass=request.getParameter("password");
        TaskController taskController=new TaskController();

        if(taskController.login(user,pass)){
            HttpSession session=request.getSession();
            session.setAttribute("user",taskController.userLogged);
            if(taskController.isAdmin()){
                response.sendRedirect("admin");
            }else{
                response.sendRedirect("user");
            }
        }else{
            request.setAttribute("mensaje","Usuario o Password incorrecto");
            request.getRequestDispatcher("login.jsp").forward(request,response);

        }
    }
}
