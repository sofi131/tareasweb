package com.ceica.tareasweb.controller;
import com.ceica.tareasweb.models.Rol;
import com.ceica.tareasweb.models.Task;
import com.ceica.tareasweb.models.User;

import java.time.LocalDate;
import java.util.List;


public class TaskController {
    public static User userLogged;

    public boolean login(String username,String password){

        User user=new User();
        userLogged=user.login(username,password);
        if(userLogged!=null){
            return true;
        }else {
            return false;
        }
    }
    //crear usuario
    public boolean createUser(String username,String pass,int rol){
        User user=new User();
        return user.insertar("(username,password,idrol) values (?,?,?)",username,pass,rol);
    }
    //editar contraseña
    public boolean editPassword(String username,String password){
        User user=new User();
        return user.actualizar("password=? where username=?",password,username);
    }
    //crear tarea
    public boolean createTask(String title, String description, LocalDate deadline){
        Task task=new Task();
        task.insertar("(title,description,deadline,iduser) values (?,?,?,?)",title,description,deadline,userLogged.getIduser());
        return true;
    }

    public List<Task> getAllTaskByUser(){
        Task task=new Task();
        return task.getAllByUser(userLogged.getIduser());
    }
    //aquí para visualizar la tabla ??????? --------------------- MIRAR ESTO
    public List<Task> getAllTask(){
        Task task = new Task();
        //return task.getDatos();
        return task.getAll();
    }
    //completar task
    public boolean completeTask(int idtask){
        Task task=new Task();
        return task.actualizar("status=? where idtask=?",true, idtask);
    }
//si es admin
    public static boolean isAdmin() {
        return userLogged.getRol().getIdrol()==2?true:false;
    }
//creado de admin
    public List<User> getAllUser() {
        User user = new User();
        return user.getAll();
    }
//método de admin
    public List<Rol> getRol() {
        Rol rol=new Rol();
        return rol.getAll();
    }

    //consulta que queremos actualizar
    public boolean updateUser(User user) {
        return user.actualizar("password=?,idrol=? where iduser=?", user.getPassword(), user.getRol().getIdrol(), user.getIduser());
    }

}