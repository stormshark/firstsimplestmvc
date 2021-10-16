package com.stormshark.mvc.api;

import com.stormshark.mvc.model.User;
import com.stormshark.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/users")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.allUsers();
    }

    @PostMapping
    public User createAnUser (@Valid @NonNull @RequestBody User user ){
        return userService.createUser(user);
    }

    @DeleteMapping (path = {"{id}"})
    public void deleteUser(@PathVariable("id") UUID id){
        userService.deleteUserById(id);
    }

    @GetMapping(path = {"{id}"})
    public User getUserById(@PathVariable("id") UUID id) {
        return userService.getAnUser(id);
    }

    @PutMapping(path= {"{id}"})
    public User updateAnUserById(@PathVariable("id") UUID id, @RequestBody User user){
       return userService.updateUser(id,user);
    }

}
