package com.stormshark.mvc.dao;

import com.stormshark.mvc.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {

    User createAUser (User user);
    List<User> listAllUsers();
    User UpdateAUser (UUID UserId, User user);
    void deleteAUSer (UUID UserId);
    User getAnUserById (UUID UserId);


}
