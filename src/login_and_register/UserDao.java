package login_and_register;

import java.util.List;

public interface UserDao {

	public void create(User User1);
	public void update(User User1);
	public User edit(String email);
	public void delete(int id);
	public User get(String email);
	public User find(String email);
	public List<User> getAll();
	
}
