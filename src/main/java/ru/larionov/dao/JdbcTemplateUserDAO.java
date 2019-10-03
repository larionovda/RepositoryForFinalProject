package ru.larionov.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.larionov.entity.User;
import java.util.List;

@Repository
public interface JdbcTemplateUserDAO {
    User findUserByUserName(String userName);
    String findUserNameById(int id);
    void addUser(String userName, String password, boolean active, int roles_id);
    List<User> getListUsers();
}
