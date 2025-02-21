package com.example.login_CRUD.model.entities;

import com.example.login_CRUD.model.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
