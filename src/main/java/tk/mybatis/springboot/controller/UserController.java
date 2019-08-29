package tk.mybatis.springboot.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.springboot.mapper.UserMapper;
import tk.mybatis.springboot.model.User;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    private Log log = LogFactory.getLog(UserController.class);

    @PostMapping("/getUsers")
    public List<User> getUsers() {
        log.info("访问了 getUsers 接口");
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