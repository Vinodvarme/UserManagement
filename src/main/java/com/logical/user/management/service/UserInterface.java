package com.logical.user.management.service;

import com.logical.user.management.entity.UserData;

import java.util.List;

public interface UserInterface {

     UserData addNewUser(UserData userData);
     List<UserData>getAllUser(int pageNumber,int pageSize);

     List<UserData> getUserByKeyword(String keyword);
     public UserData getUserById(int userId);
}
