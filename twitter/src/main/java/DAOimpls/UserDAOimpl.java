package DAOimpls;

import DAO.UserDAO;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import utils.HibernateSessionFactoryUtil;

import javax.persistence.Query;
import java.util.List;

public class UserDAOimpl implements UserDAO {
    @Override
    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    @Override
    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    @Override
    public User findByUsername(String username) {
        String sql = "select * from public.user where username = '" + username + "'";

        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createSQLQuery(sql).addEntity(User.class);
        List<User> users = ((NativeQuery) query).list();
        if (users.size()>0)
        {
            return users.get(0);
        }
        else return null;
    }

    @Override
    public User findByEmail(String email) {
        String sql = "select * from public.user where email = '" + email + "'";
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createSQLQuery(sql).addEntity(User.class);
        List<User> users = ((NativeQuery) query).list();

        if (users.size() > 0) {
            return users.get(0);
        } else return null;
    }

    @Override
    public User findByKey(String key){
        String sql = "select * from public.user where key = '" + key + "'";
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createSQLQuery(sql).addEntity(User.class);
        List<User> users = ((NativeQuery) query).list();

        if (users.size() > 0) {
            return users.get(0);
        } else return null;
    }
}
