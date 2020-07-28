package com.softserve.edu.service.impl;

import com.softserve.edu.exception.EntityNotFoundException;
import com.softserve.edu.model.Marathon;
import com.softserve.edu.model.User;
import com.softserve.edu.repository.MarathonRepository;
import com.softserve.edu.repository.UserRepository;
import com.softserve.edu.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MarathonRepository marathonRepository;

    public UserServiceImpl(UserRepository userRepository,
                           MarathonRepository marathonRepository) {
        this.userRepository = userRepository;
        this.marathonRepository = marathonRepository;
    }

    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        return users.isEmpty() ? new ArrayList<>() : users;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(("No user /w id "+id)));
    }

    public User createOrUpdateUser(User entity) {
        return userRepository.save(entity);
    }

    public List<User> getAllByRole(String role) {
        return userRepository.getAllByRole(User.Role.valueOf(role.toUpperCase()));
    }

    public boolean addUserToMarathon(User user, Marathon marathon) {
        User userEntity = userRepository.getOne(user.getId());
        Marathon marathonEntity = marathonRepository.getOne(marathon.getId());
        marathonEntity.getUsers().add(userEntity);
        return marathonRepository.save(marathonEntity) != null;
    }
    public List<User> allUsersByMarathonIdAndRole(long id, String role) {
        return userRepository.findAllByMarathonsIdAndRole(id, User.Role.valueOf(role));
    }
    public boolean deleteUserFromMarathon(User user, Marathon marathon) {

        Optional<User> userEntity = userRepository.findById(user.getId());
        Optional<Marathon> marathonEntity = marathonRepository.findById(marathon.getId());
        if(!userEntity.isPresent() || !marathonEntity.isPresent()) {
            return false;
        }
        List<User> users = marathonEntity.get().getUsers();
        users.remove(userEntity.get());
        marathonEntity.get().setUsers(users);
        return true;
    }
}
