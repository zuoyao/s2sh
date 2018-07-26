package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by zuoyao on 2018/7/26.
 */
public class HibernateUtil {
    private static SessionFactory sf;
    static {
        Configuration configuration=new Configuration().configure();
        sf=configuration.buildSessionFactory();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("虚拟机关闭，释放资源");
                sf.close();
            }
        }));
    }
    public static Session openSession(){
        return sf.openSession();
    }
    public static Session getCurentSession(){
        return sf.getCurrentSession();
    }



}
