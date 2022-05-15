package vn.hanu.fit.ss2codecamp.services.impl;

import org.springframework.stereotype.Service;
import vn.hanu.fit.ss2codecamp.entities.User;
import vn.hanu.fit.ss2codecamp.repositories.UserRepository;
import vn.hanu.fit.ss2codecamp.services.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Object updateById(int id, Object o) {
        return null;
    }

    @Override
    public Object save(Object o) {
        return null;
    }
}
