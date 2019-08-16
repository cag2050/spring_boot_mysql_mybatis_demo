package tk.mybatis.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.springboot.mapper.UserMapper;
import tk.mybatis.springboot.model.User;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users = userMapper.getAll();
        return users;
    }

    @PostMapping("/getUser")
    public User getUser(@RequestParam Long id) {
        User user = userMapper.getOne(id);
        return user;
    }

    @PostMapping("/add")
    public void save(@RequestBody User user) {
        userMapper.insert(user);
    }

    @PostMapping("/update")
    public void update(@RequestBody User user) {
        userMapper.update(user);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }


}