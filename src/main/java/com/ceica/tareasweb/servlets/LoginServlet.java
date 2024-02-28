package com.ceica.tareasweb.servlets;

import com.ceica.tareasweb.controller.TaskController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

//doGet y doPost
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String user=request.getParameter("user");
        String pass=request.getParameter("password");
        TaskController taskController=new TaskController();
        if(taskController.login(user,pass)){
            //request.getRequestDispatcher("admin.jsp").forward(request,response);
            response.sendRedirect("admin");
        }else{
            request.setAttribute("mensaje","Usuario o password incorrecto");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        //request.getRequestDispatcher("login.jsp").forward(request,response);
    }
}

