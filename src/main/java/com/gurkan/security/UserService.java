package com.gurkan.security;

import java.util.Optional;

import com.gurkan.entity.User;


public interface UserService {
    public Optional<User> getByUsername(String username);
}
