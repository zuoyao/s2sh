package utils;

import domain.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by zuoyao on 2018/7/26.
 */
public class UtilTest {
    public static void main(String[] args) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        User user=new User();
        user.setUser_code("zz");
        user.setUser_name("正则");
        session.save(user);

        transaction.commit();
        session.close();
    }
}
