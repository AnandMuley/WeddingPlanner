package com.wepla.repository;

import com.wepla.entity.MarriageHall;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarriageHallRepository extends MongoRepository<MarriageHall, String>{

    List<MarriageHall> findByLocationContainingIgnoreCase(String location);
}
