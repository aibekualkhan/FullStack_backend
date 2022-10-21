package com.lab.fullstack.dao;

import com.lab.fullstack.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, String> {
}
