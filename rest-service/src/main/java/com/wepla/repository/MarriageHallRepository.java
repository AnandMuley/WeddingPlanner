package com.wepla.repository;

import com.wepla.entity.MarriageHall;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarriageHallRepository extends MongoRepository<MarriageHall, String>{
}
