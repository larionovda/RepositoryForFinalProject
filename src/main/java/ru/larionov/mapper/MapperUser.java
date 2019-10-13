package ru.larionov.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.larionov.entity.User;
import ru.larionov.entity.Role;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperUser implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("user_id"));
        user.setUsername(resultSet.getString("user_name"));
        user.setPassword(resultSet.getString("pass"));
        user.setActive(resultSet.getBoolean("active"));
        user.getRoles().add(getRole(resultSet.getInt("roles_id")));
        return user;
    }

    private Role getRole(int id) {
        if (id == 1) {
            return Role.DOCTOR;
        } else if (id == 2) {
            return Role.NURSE;
        }
        return null;
    }
}