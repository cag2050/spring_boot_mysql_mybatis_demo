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

    @RequestMapping(value = "/getUsers", method = RequestMethod.POST)
    public List<User> getUsers() {
        List<User> users = userMapper.getAll();
        return users;
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public User getUser(@RequestParam Long id) {
        User user = userMapper.getOne(id);
        return user;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void save(@RequestBody User user) {
        userMapper.insert(user);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void update(@RequestBody User user) {
        userMapper.update(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }


}