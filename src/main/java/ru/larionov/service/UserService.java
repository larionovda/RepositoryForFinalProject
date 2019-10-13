package ru.larionov.service;

import org.springframework.stereotype.Service;
import ru.larionov.entity.User;
import java.util.List;

@Service
public interface UserService {
//    User findUserByUserName(String userName);
//    String findUserNameById(int id);
    void addUser(String userName, String password, boolean active, int roles_id);
    List<User> getListUsers();
}
