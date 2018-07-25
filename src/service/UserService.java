package service;

import domain.User;

/**
 * Created by zuoyao on 2018/7/24.
 */
public interface UserService {
    //登陆方法
    User	getUserByCodePassword(User u);
    //注册用户
    void saveUser(User user);
}
