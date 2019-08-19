package tk.mybatis.springboot.mapper;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import tk.mybatis.springboot.model.User;

import java.util.List;

@CacheConfig(cacheNames = "users")
public interface UserMapper {

	@Cacheable
	List<User> getAll();
	
	User getOne(Long id);

	void insert(User user);

	void update(User user);

	void delete(Long id);

}