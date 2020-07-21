package com.cpulover.rest.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cpulover.rest.entity.User;

@Component
public class UserDaoImpl {

	// simulate a database (in-memory)
	private static List<User> users=new ArrayList<>();
	private static int usersCount = 3;

	static {
		users.add(new User(1, "Hieu1", new Date(),"cpulover1"));
		users.add(new User(2, "Hieu2", new Date(),"cpulover2"));
		users.add(new User(3, "Hieu3", new Date(),"cpulover3"));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
			user.setId(++usersCount);
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
