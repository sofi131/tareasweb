package com.ceica.tareasweb.servlets;

import com.ceica.tareasweb.controller.TaskController;
import com.ceica.tareasweb.models.Task;
import com.ceica.tareasweb.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "userServlet", value = "/user")
public class UserServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String logoutParam = request.getParameter("logout");
        // Si el parámetro "logout" tiene el valor "salir"
        if ("salir".equals(logoutParam)) {
            // Obtener la sesión actual (creará una nueva si no existe)
            HttpSession session = request.getSession(false);
            if (session != null) {
                // Invalidar la sesión
                session.invalidate();
                // Redireccionar a la página de inicio de sesión, o donde corresponda
                response.sendRedirect(request.getContextPath() + "/");
            }
        } else {
            User user = (User) request.getSession().getAttribute("user");

            if (user == null) {
                response.sendRedirect("login");
            } else {
//saber que usuario está logueado, las tareas del user y pasa al user.jsp
                if (user.getRol().getDescription().equals("user")) {
                    TaskController taskController=new TaskController();
                    taskController.userLogged=user;
                    List<Task> taskList=taskController.getAllTaskByUser();
                    request.setAttribute("name", user.getUsername());
                    request.setAttribute("tasks",taskList);
                    request.getRequestDispatcher("user.jsp").forward(request, response);


                } else {
                    response.sendRedirect("admin");
                }
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //sesiones que caducan -> en do get comprobar que tengo sesión en el usuario
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("login");
        } else {
            //crear obj task que es lo que va contra la bbdd
            TaskController taskController=new TaskController();
            //guardamos el usuario logueado en user
            taskController.userLogged=user;
            //parámetros
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            LocalDate deadline = LocalDate.parse(request.getParameter("deadline"));
            taskController.createTask(title,description,deadline);
            //redirección al mismo server - petición get
            response.sendRedirect("user");
        }
    }
}