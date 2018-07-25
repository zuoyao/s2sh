package service.impl;

import dao.UserDao;
import domain.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.UserService;

/**
 * Created by zuoyao on 2018/7/24.
 */
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = true)
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Override
    public User getUserByCodePassword(User u) {
        //1 根据登陆名称查询登陆用户
        User existU = userDao.getUserByUserCode(u.getUser_code());
        //2 判断用户是否存在.不存在=>抛出异常,提示用户名不存在
        if(existU==null){
            throw new RuntimeException("用户名不存在!");
        }
        //3 判断用户密码是否正确=>不正确=>抛出异常,提示密码错误
        if(!existU.getUser_password().equals(u.getUser_password())){
            throw new RuntimeException("密码错误!");
        }
        //4 返回查询到的用户对象

        return existU;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
