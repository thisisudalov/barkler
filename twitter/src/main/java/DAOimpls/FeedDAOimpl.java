package DAOimpls;

import DAO.FeedDAO;
import models.Feed;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import utils.HibernateSessionFactoryUtil;

import javax.persistence.Query;
import java.util.List;

public class FeedDAOimpl implements FeedDAO {

    @Override
    public Feed findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Feed.class, id);
    }

    @Override
    public List<Feed> findByUserId(int id){
        String sql = "select * from public.feed where user_id = " + id;

        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createSQLQuery(sql).addEntity(Feed.class);
        List<Feed> feeds = ((NativeQuery) query).list();
        if (feeds.size()>0)
        {
            return feeds;
        }
        else return null;
    }

    @Override
    public void save(Feed feed) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(feed);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Feed feed) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(feed);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Feed feed) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(feed);
        tx1.commit();
        session.close();
    }
}
