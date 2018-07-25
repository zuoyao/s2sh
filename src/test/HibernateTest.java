package test;

import dao.UserDao;
import domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

import javax.annotation.Resource;


/**
 * Created by zuoyao on 2018/7/25.
 */
public class HibernateTest {
    /*public static void main(String[] args) {
        //单独测试hibernate
        Configuration conf = new Configuration().configure();
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User u = new User();
        u.setUser_code("rose");
        u.setUser_name("肉丝");
        u.setUser_password("1234");
        session.save(u);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
*/

   /* public static void main(String[] args) {
        //hibernate和spring整合
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        SessionFactory sessionFactory =(SessionFactory) applicationContext.getBean("sessionFactory");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User u = new User();

        u.setUser_code("jieshi");
        u.setUser_name("杰死");
        u.setUser_password("1234");
        session.save(u);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }*/

   /* public static void main(String[] args) {
        //hibernate模板
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
         UserDao userDao=(UserDao) applicationContext.getBean("userDao");
        User rose = userDao.getUserByUserCode("rose");
        System.out.println(rose);
    }*/
    public static void main(String[] args) {
        //hibernate事务
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService=(UserService) applicationContext.getBean("userService");
        User user=new User();
        user.setUser_code("jj");
        user.setUser_name("姐姐");
        userService.saveUser(user);
    }
}
