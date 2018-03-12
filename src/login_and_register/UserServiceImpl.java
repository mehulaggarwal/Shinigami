package login_and_register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public void create(User User1) {
		userDao.create(User1);
	}

	@Override
	public void update(User User1) {
	    userDao.update(User1);
	}

	@Override
	public User edit(String email) {
		return userDao.edit(email);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public User find(String email) {
		return userDao.find(email);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public User get(String email) {
		return userDao.get(email);
	}

}
