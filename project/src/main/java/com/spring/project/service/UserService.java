package com.spring.project.service;
import java.util.List;

import com.spring.project.model.Book;
import com.spring.project.model.Role;
import com.spring.project.model.User;
import com.spring.project.repo.BookRepository;
import com.spring.project.repo.RoleRepository;
import com.spring.project.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    RoleRepository roleRepo;


    @Autowired PasswordEncoder passwordEncoder;

    public void registerDefaultUser(User user) {
        Role roleUser = roleRepo.findByName("USER");
        user.addRole(roleUser);
        encodePassword(user);
        userRepo.save(user);
    }


    public List<User> listAll() {
        return userRepo.findAll();
    }

    public User get(Long id) {
        return userRepo.findById(id).get();
    }

    public List<Role> listRoles() {
        return roleRepo.findAll();
    }



    public void save(User user) {
        encodePassword(user);
        userRepo.save(user);
    }

    public void deleteUserById(int id) {
        this.userRepo.deleteById((long) id);
    }

    private void encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }


}
