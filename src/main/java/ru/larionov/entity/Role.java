package ru.larionov.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    DOCTOR, NURSE;

    @Override
    public String getAuthority() {
        return name();
    }
}
