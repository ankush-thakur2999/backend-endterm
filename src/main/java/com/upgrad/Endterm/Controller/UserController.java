package com.upgrad.Endterm.Controller;


import com.upgrad.Endterm.Exception.RecordNotFoundException;
import com.upgrad.Endterm.Model.User;
import com.upgrad.Endterm.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping
    public String getAllEmployees(Model model)
    {
        System.out.println("getAllUsers");

        List<User> list = userService.getAllEmployees();

        model.addAttribute("users", list);

        return "list-user";
    }



    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editUserById(Model model, @PathVariable("id") Optional<Long> id)
            throws RecordNotFoundException
    {

        System.out.println("editUserById" + id);
        if (id.isPresent()) {
            User user = userService.getUserById(id.get());
            model.addAttribute("user", user);
        } else {
            model.addAttribute("user", new User());
        }


        return "add-edit-user";
    }
    @RequestMapping(path = "/delete/{id}")
    public String deleteEmployeeById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException
    {

        System.out.println("deleteEmployeeById" + id);

        userService.deleteUserById(id);
        return "redirect:/";
    }
    @RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
    public String createOrUpdateEmployee(User user)
    {
        System.out.println("createOrUpdateEmployee ");

        userService.createOrUpdateUser(user);

        return "redirect:/";
    }

}
