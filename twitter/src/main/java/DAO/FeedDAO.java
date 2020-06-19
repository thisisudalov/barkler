package DAO;

import models.Feed;

import java.util.List;

public interface FeedDAO {
    Feed findById(int id);

    List<Feed> findByUserId(int id);

    void save(Feed feed);

    void update(Feed feed);

    void delete(Feed feed);

}
