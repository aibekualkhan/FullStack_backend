package com.lab.fullstack.service;


import com.lab.fullstack.dao.RoleDao;
import com.lab.fullstack.dao.UserDao;
import com.lab.fullstack.model.Role;
import com.lab.fullstack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Chista Aibek`s role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Obychnye sushestva");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(encodePassword("admin"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRoles(adminRoles);
        userDao.save(adminUser);
    }

    public User registerNewUser(User user) {
        Role role = roleDao.findById("User").get();

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRoles(userRoles);
        user.setUserPassword(encodePassword(user.getUserPassword()));

        return userDao.save(user);
    }

    public String encodePassword(String password){
        return passwordEncoder.encode(password);
    }
}
