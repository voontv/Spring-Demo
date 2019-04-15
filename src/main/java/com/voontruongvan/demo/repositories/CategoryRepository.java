package com.voontruongvan.demo.repositories;

import com.voontruongvan.demo.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
