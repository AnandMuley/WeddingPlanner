package com.wepla.repository;

import com.wepla.entity.Pandit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanditRepository extends MongoRepository<Pandit, String> {

}
