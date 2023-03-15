package com.logical.user.management.repo;

import com.logical.user.management.entity.UserData;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface UserRepo extends MongoRepository<UserData,Integer> {

    @Query("{'emailId':{ $regex: \"Programming\"}}")
    public List<UserData> searchByEmailId(String emailId);
}
