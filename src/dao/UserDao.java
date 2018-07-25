package dao;

import domain.User;

/**
 * Created by zuoyao on 2018/7/25.
 */
public interface UserDao {
    User getUserByUserCode(String user_code);
    void saveUser(User user);
}
