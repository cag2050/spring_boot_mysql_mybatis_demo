package tk.mybatis.springboot.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class UserController {

    @RequestMapping("/")
    String home() {
        return "hello world";
    }
}
