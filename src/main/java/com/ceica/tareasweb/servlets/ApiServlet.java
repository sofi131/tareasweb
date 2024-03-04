package com.ceica.tareasweb.servlets;

import com.ceica.tareasweb.controller.TaskController;
import com.ceica.tareasweb.models.Task;
import com.ceica.tareasweb.models.User;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "apiServlet", value = "/api")
public class ApiServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idtask= Integer.parseInt(request.getParameter("idtask"));
        User user= (User) request.getSession().getAttribute("user");
// Si el usuario no ha iniciado sesión, devuelve 303 See Other
        if (user == null) {
            response.setStatus(HttpServletResponse.SC_SEE_OTHER);
            response.setHeader("Location", "/login"); // Indica al cliente que debe ir a /login

        }else {


            TaskController taskController = new TaskController();
            taskController.userLogged = user;
            taskController.deleteTask(idtask);
            List<Task> taskList = taskController.getAllTaskByUser();
            Gson gson= new Gson();
            String json = gson.toJson(taskList);

            PrintWriter out = response.getWriter();
            // configurar la respuesta http para devolver json
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.write(json);
            //out.write("{\"msg\":\"task deleted\"}");
        }
    }
}