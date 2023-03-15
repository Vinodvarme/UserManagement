package com.logical.user.management.service;

import com.logical.user.management.entity.UserData;
import com.logical.user.management.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserInterface{
    @Autowired
    UserRepo userRepo;

    @Override
    public UserData addNewUser(UserData userData) {

        return userRepo.save(userData);
    }

    @Override
    public List<UserData> getAllUser(int pageNumber, int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        Page<UserData>page=this.userRepo.findAll(pageable);
        List<UserData>list=page.getContent();
        return list;
    }
    @Override
    public List<UserData> getUserByKeyword(String emailId) {
        List<UserData>list=this.userRepo.searchByEmailId(emailId);

        return list;
    }

    @Override
    public UserData getUserById(int userId) {
        return userRepo.findById(userId).orElseThrow();
    }

}
