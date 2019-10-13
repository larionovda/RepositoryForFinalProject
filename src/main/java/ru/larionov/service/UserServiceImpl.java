package ru.larionov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.larionov.dao.JdbcTemplateUserDAO;
import ru.larionov.entity.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private JdbcTemplateUserDAO jdbcTemplateUserDAO;

//    @Override
//    public User findUserByUserName(String userName) {
//        return jdbcTemplateUserDAO.findUserByUserName(userName);
//    }
//
//    @Override
//    public String findUserNameById(int id) {
//        return jdbcTemplateUserDAO.findUserNameById(id);
//    }

    @Override
    public void addUser(String userName, String password, boolean active, int roles_id) {
        jdbcTemplateUserDAO.addUser(userName, password, active, roles_id);
    }

    @Override
    public List<User> getListUsers() {
        return jdbcTemplateUserDAO.getListUsers();
    }
}
