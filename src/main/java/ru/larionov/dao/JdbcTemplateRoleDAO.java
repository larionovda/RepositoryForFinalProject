package ru.larionov.dao;

import java.util.List;

public interface JdbcTemplateRoleDAO {
    List<String> getRoleNames(Long userId);
}
