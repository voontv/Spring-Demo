package com.voontruongvan.demo.repositories;

import com.voontruongvan.demo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
