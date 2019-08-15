package tk.mybatis.springboot.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.springboot.enums.UserSexEnum;
import tk.mybatis.springboot.model.User;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception {
        userMapper.insert(new User("aa", "a123456", UserSexEnum.MAN));
        userMapper.insert(new User("bb", "b123456", UserSexEnum.WOMAN));
        userMapper.insert(new User("cc", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, userMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<User> users = userMapper.getAll();
        if (users == null || users.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(users.toString());
        }
    }


    @Test
    // 在单元测试中使用 @Transactional注解，能在发生异常的时候回退，默认情况下在测试方法的末尾会回滚事务。
    // 只添加 @Transactional，不添加 @Rollback，默认会回滚事务。
    @Transactional
    // 如果想关闭回滚，只要加上 @Rollback(false) 注解即可，@Rollback表示事务执行完回滚，支持传入一个value，默认true即回滚，false不回滚。
    @Rollback(false)
    public void testUpdate() throws Exception {
        User user = userMapper.getOne(28l);
        System.out.println(user.toString());
        user.setNickName("neo333");
        userMapper.update(user);
        Assert.assertTrue(("neo".equals(userMapper.getOne(28l).getNickName())));
    }
}
