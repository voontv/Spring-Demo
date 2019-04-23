package com.voontruongvan.demo.repositories;

import com.voontruongvan.demo.models.BookImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookImageRepository extends JpaRepository<BookImage, Integer> {
}
