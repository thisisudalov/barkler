package Service;

import DAOimpls.UserDAOimpl;
import models.User;

public class UserService {
    private UserDAOimpl dao = new UserDAOimpl();

    public UserService(){};

    public User findUserById(int id){return dao.findById(id);}

    public void delete(User user){dao.delete(user);}

    public void update(User user){dao.update(user);}

    public void create(User user){dao.save(user);}

    public User findByUsername(String username) {return dao.findByUsername(username);}

    public User findByEmail(String email) {return dao.findByEmail(email);}

    public User findByKey (String key) {return dao.findByKey(key);}

}
