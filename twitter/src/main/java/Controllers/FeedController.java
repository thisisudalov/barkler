package Controllers;

import Logics.UtilToSQLConversion;
import Service.FeedService;
import Service.UserService;
import com.google.gson.Gson;
import models.Feed;
import models.User;
import spark.Request;

import java.util.List;
public class FeedController {
    static UserService userService = new UserService();
    static FeedService feedService = new FeedService();

    public static List<Feed> getFeed(Request req){

        User u = userService.findByUsername(req.params(":name"));
        if(u!=null) {
            List<Feed> feeds = feedService.findFeedByUserId(u.getId());
            return feeds;
        }
        else return null;
    }

    public static String postFeed(Request req){
        FeedService feedService = new FeedService();

        System.out.println(req.body());
        Feed feedInfo = new Gson().fromJson(req.body(), Feed.class);
        String auth_key = req.cookie("authorization");
        User u = userService.findByKey(auth_key);
        if(u!=null) {
            feedGenerate(feedInfo, u);
            System.out.println(feedInfo.getTimestamp());
            feedService.create(feedInfo);
            return "OK";
        }
        else return "err";
    }

    private static String defineUser(String body){
        return body.substring(11, body.length()-2);
    }


    private static void feedGenerate(Feed feed, User u){
        feed.setUser_id(u.getId());
        feed.setTimestamp(UtilToSQLConversion.init());
    }
}
