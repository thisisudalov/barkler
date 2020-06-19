package Service;

import DAOimpls.FeedDAOimpl;
import models.Feed;

import java.util.List;

public class FeedService {
    private FeedDAOimpl dao = new FeedDAOimpl();

    public FeedService(){}

    public Feed findFeedById(int id){return dao.findById(id);}

    public List<Feed> findFeedByUserId(int id){return dao.findByUserId(id);}


    public void delete(Feed feed){dao.delete(feed);}

    public void update(Feed feed){dao.update(feed);}

    public void create(Feed feed){dao.save(feed);}
}
