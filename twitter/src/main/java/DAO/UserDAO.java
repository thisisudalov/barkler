package DAO;

import models.User;


public interface UserDAO {

    User findById(int id);

    void save(User user);

    void update(User user);

    void delete(User user);

    User findByUsername(String username);

    User findByEmail (String email);

    User findByKey (String key);
}

