package com.stormshark.mvc.service;

import com.stormshark.mvc.dao.UserDao;
import com.stormshark.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("Mysql") UserDao userDao) {
        this.userDao = userDao;
    }

    public User createUser(User user)  {
     return userDao.createAUser(user);
    }

  public List<User> allUsers() {
        return userDao.listAllUsers();
    }

  public void deleteUserById(UUID userid){
        userDao.deleteAUSer(userid);
    }

  public User updateUser(UUID id, User user){
        return userDao.UpdateAUser(id,user);
    }

  public User getAnUser(UUID id) {
        return userDao.getAnUserById(id);
  }

}
