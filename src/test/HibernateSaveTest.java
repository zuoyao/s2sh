package test;


import domain.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by zuoyao on 2018/7/26.
 */
public class HibernateSaveTest {
    public static void main(String[] args) {
        Configuration  configuration=new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //1.保存用户
        /*User user=new User();
        user.setUser_code("zy");
        user.setUser_name("zuoyao");
        user.setUser_password("123");
        session.save(user);*/
        //2.删除用户
        /*User user=new User();
        user.setUser_id(9l);
        session.delete(user);*/
        //3.修改用户，思路先查询出来再修改
        /*User user = session.get(User.class, 1l);
        user.setUser_name("肉肉");
        session.update(user);*/
        //4.查询
        //4_1.按id查询用户 分别用get和load（延迟加载/懒加载）查询
        /*User user = session.get(User.class, 1l);
        System.out.println(user);*/
        /*User load = session.load(User.class, 1l);
        System.out.println(load);*/
        //4_2.使用session.createQuery查询用户
        //查询所有用户
        /*Query query = session.createQuery("from domain.User");
        List<User> list = query.list();
        System.out.println(list);*/
        //查询id为2的用户
        /*Query query = session.createQuery("from domain.User where user_id=2l");
        //List<User> list = query.list();
        User user = (User) query.uniqueResult();
        System.out.println(user);*/
        //使用query进行分页查询
        /*Query query = session.createQuery("from domain.User");
        query.setFirstResult(0);//从第几个索引开始
        query.setMaxResults(2);//查几个
        List list = query.list();
        System.out.println(list);*/
        //4_3.使用session.createCriteria查询（了解）
        //查询所有用户
        /*Criteria criteria = session.createCriteria(User.class);
        List<User> list = criteria.list();
        System.out.println(list);*/
        //查询名字等于肉肉的用户
        /*Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("user_name","肉肉"));
        List list = criteria.list();
        System.out.println(list);*/
        //查询名字中包含肉的用户
        /*Criteria criteria = session.createCriteria(User.class);
        //criteria.add(Restrictions.like("user_name","%肉%"));
        //criteria.add(Restrictions.gt("user_id",2l));//ge大于等于，le是小于等于
        criteria.add(Restrictions.le("user_id",2l));
        List list = criteria.list();
        System.out.println(list);*/
        //4_4 使用session.createSQLQuery查询
        //查询所有用户
        SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM sys_user");
        sqlQuery.addEntity(User.class);//这样查询出来hibernate不知道是什么实体与他对应所以设置这个条件,将结果封装到对象中
        List<User> list = sqlQuery.list();
        System.out.println(list);

        transaction.commit();
        session.close();
        sessionFactory.close();

    }

}
