package dao.impl;

import dao.UserDao;
import domain.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by zuoyao on 2018/7/25.
 */
//HibernateDaoSupport 为dao注入sessionFactory
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Override
    public User getUserByUserCode(final String user_code) {
        //Hql
        return super.getHibernateTemplate().execute(new HibernateCallback<User>() {
            @Override
            public User doInHibernate(Session session) throws HibernateException {
                String hql="from User where user_code = ? ";
                Query query = session.createQuery(hql);
                query.setParameter(0,user_code);
                User user =(User) query.uniqueResult();
                return user;
            }
        });


        /*DetachedCriteria dc=DetachedCriteria.forClass(User.class);
        dc.add(Restrictions.eq("user_code",user_code));
        List<User> list =(List<User>)getHibernateTemplate().findByCriteria(dc);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }else {
            return null;
        }*/
    }

    @Override
    public void saveUser(User user) {
        getHibernateTemplate().save(user);
    }
}
