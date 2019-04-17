package com.voontruongvan.demo.repositories;

import com.voontruongvan.demo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
