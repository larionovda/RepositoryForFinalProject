package ru.larionov.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RoleImpl implements JdbcTemplateRoleDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<String> getRoleNames(Long userId) {
        String SQL = "select roles.role_name from roles inner join role_user on roles.role_id = role_user.role_id\n" +
                "\twhere role_user.role_id = roles.role_id and role_user.user_id = ?";
        Object[] params = new Object[] { userId };
        List<String> roles = jdbcTemplate.queryForList(SQL, params, String.class);
        return roles;
    }
}
