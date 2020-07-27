package com.softserve.edu.service;

import com.softserve.edu.model.Marathon;
import com.softserve.edu.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUserById(Long id);
    User createOrUpdateUser( User user);
    List<User> getAllByRole(String role);
    boolean addUserToMarathon(User user, Marathon marathon);
}
