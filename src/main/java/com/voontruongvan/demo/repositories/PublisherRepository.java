package com.voontruongvan.demo.repositories;

import com.voontruongvan.demo.models.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Integer> {
}
