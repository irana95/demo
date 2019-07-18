package com.example.demo;


import com.example.demo.Dao.EmployeeDao;
import com.example.demo.Model.EmployeeEntity;
import com.example.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getUsers(ModelAndView model){
        model.setViewName("loginpage");
//        List<EmployeeEntity> user=employeeDao.getUsers();
//        model.addObject("user",user);
        return  model;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUsers(ModelAndView model,  @PathVariable("id") int id){
        return  "UserAccount";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String getUsers(ModelAndView model, HttpServletRequest req){
        req.getSession().invalidate();
        return  "/";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getUsers(){
        return  "register";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.GET)
    public String saveUser(@ModelAttribute("user") User user){
        employeeDao.save(user);
        return  "redirect:/";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET )
    public String getUserById(HttpServletRequest req, @RequestParam("username") String username, @RequestParam("password") String password) throws ServletException, IOException {
        String path="/index";
        System.out.println(req.getParameter("email"));
        System.out.println(req.getParameter("password"));
        User user = employeeDao.checkLogin(username, password);
        if (user!=null) {
            HttpSession session = req.getSession(false);
            session.setAttribute("user", user);
        }else{
            path="redirect:/register";
        }
            return path;
    }
}
