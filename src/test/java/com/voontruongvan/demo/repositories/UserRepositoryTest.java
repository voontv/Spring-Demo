package com.voontruongvan.demo.repositories;

import com.voontruongvan.demo.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test_findByUsername() {
        User user = new User();
        user.setId(0);
        user.setUsername("voontv");
        user.setFirstName("Truong Van");
        user.setLastName("Voon");
        user.setPassword("12345");
        userRepository.save(user);
        assertNotNull(userRepository.findByUsername("voontv"));
        assertNull(userRepository.findByUsername("abdhddhdh"));
    }
}
