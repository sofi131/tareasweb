package com.ceica.tareasweb.servlets;

import com.ceica.tareasweb.controller.TaskController;
import com.ceica.tareasweb.models.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "apiServlet", value = "/api")
public class ApiServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idtask= Integer.parseInt(request.getParameter("idtask"));
        TaskController taskController=new TaskController();
        taskController.deleteTask(idtask);
        //List<Task> taskList=taskController.getAllTaskByUser();


        PrintWriter out=response.getWriter();

        out.write("{\"msg\":\"task deleted\"}");
    }
}