package com.ceica.tareasweb.servlets;

import com.ceica.tareasweb.controller.TaskController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "apiServlet", value = "/api")
public class ApiServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idtask= Integer.parseInt(request.getParameter("idtask"));
        TaskController taskController=new TaskController();
        taskController.deleteTask(idtask);
        PrintWriter out=response.getWriter();
        String respuesta="{\"msg\":\"tarea a borrrar " + idtask+" por la api\"}";
        out.write(respuesta);
    }
}
