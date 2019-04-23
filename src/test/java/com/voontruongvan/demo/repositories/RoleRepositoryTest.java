package com.voontruongvan.demo.repositories;

import com.voontruongvan.demo.models.Role;
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
public class RoleRepositoryTest {
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void test_findByName() {
        roleRepository.save(new Role("ROLE_TEST","Teacher"));
        assertNotNull(roleRepository.findByName("ROLE_TEST"));
        assertNull(roleRepository.findByName("voontv"));
    }
}
