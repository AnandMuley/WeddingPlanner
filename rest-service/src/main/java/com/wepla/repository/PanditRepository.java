package com.wepla.repository;

import com.wepla.entity.Pandit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PanditRepository extends MongoRepository<Pandit, String> {

    List<Pandit> findByNameContainingIgnoreCase(String name);

}
