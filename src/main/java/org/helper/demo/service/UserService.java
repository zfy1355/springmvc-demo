package org.helper.demo.service;

import org.helper.demo.entity.User;

import java.util.List;


public interface UserService {

    List<User> getUserList();

    Long createUser(User user);

    User getUser(Long id);

    User updateUser(Long id, User user);

    User deleteUser(Long id);
}
