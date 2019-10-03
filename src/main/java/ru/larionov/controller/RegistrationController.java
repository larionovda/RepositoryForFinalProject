package ru.larionov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.larionov.dao.JdbcTemplateUserDAO;
import ru.larionov.entity.User;
import ru.larionov.entity.Role;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private JdbcTemplateUserDAO jdbcTemplateUserDAO;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        user.setActive(true);
        user.getRoles().add(Role.DOCTOR);
        jdbcTemplateUserDAO.addUser(user.getUsername(), user.getPassword(), user.isActive(), takeRoleByInt(user.getRoles().iterator().next()));
        return  "redirect:/login";
    }

    private int takeRoleByInt(Role role){
        switch (role) {
            case DOCTOR:
                return 1;
            case NURSE:
                return 2;
        }
        return 1;
    }
}
