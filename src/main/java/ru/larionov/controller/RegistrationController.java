package ru.larionov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.larionov.entity.Role;
import ru.larionov.entity.User;
import ru.larionov.service.UserService;
import java.util.ArrayList;
import java.util.List;


@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String showAddPatient(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public String savePerson(@ModelAttribute("user") User user) {
        List<User> users = new ArrayList<>(userService.getListUsers());
        for (User user1 : users){
            if (user1.getUsername().equals(user.getUsername())){
                return "redirect:/registration";
            }
        }
        user.setActive(true);
        user.getRoles().add(Role.NURSE);
        userService.addUser(user.getUsername(), user.getPassword(), user.isActive(), takeRoleByInt(user.getRoles().iterator().next()));
        return "redirect:/login";
    }

    private int takeRoleByInt(Role role) {
        switch (role) {
            case DOCTOR:
                return 1;
            case NURSE:
                return 2;
        }
        return 1;
    }
}
