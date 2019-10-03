package ru.larionov.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.larionov.entity.User;
import ru.larionov.mapper.MapperUser;

import java.util.List;

@Repository
public class UserImpl implements JdbcTemplateUserDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final MapperUser MAPPER_USER = new MapperUser();

    @Override
    public List<User> getListUsers() {
        String SQL = "select * from user";
        return jdbcTemplate.query(SQL, MAPPER_USER);
    }

    @Override
    public User findUserByUserName(String username) {
        String SQL = " select user.id, user_name, pass, active, roles_id from user where user_name = ?";
        return jdbcTemplate.queryForObject(SQL, MAPPER_USER, username);
    }

    @Override
    public void addUser(String username, String password, boolean active, int roles_id) {
        String SQL = "insert into user (user_name, pass, active, roles_id) values (?, ?, ?, ?)";
        jdbcTemplate.update(SQL, username, password, active, roles_id);
    }

    @Override
    public String findUserNameById(int id) {
        String SQL = "Select user_name where id = ?";
        return jdbcTemplate.queryForObject(
                SQL, new Object[]{id}, String.class);
    }
}
