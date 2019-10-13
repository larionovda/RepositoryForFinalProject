package ru.larionov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.larionov.dao.JdbcTemplateUserDAO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private JdbcTemplateUserDAO jdbcTemplateUserDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return jdbcTemplateUserDAO.findUserByUserName(username);
    }
}