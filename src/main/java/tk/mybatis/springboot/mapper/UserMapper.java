package tk.mybatis.springboot.mapper;

import java.util.List;

import tk.mybatis.springboot.model.User;

public interface UserMapper {
	
	List<User> getAll();
	
	User getOne(Long id);

	void insert(User user);

	void update(User user);

	void delete(Long id);

}