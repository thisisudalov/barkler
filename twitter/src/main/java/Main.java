import Controllers.FeedController;
import Controllers.Log;
import models.ResponseEntity;

import java.awt.*;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

public class Main {
    public static void main(String[] args) {
        staticFiles.location("/public");


        post("/api/login/create", (req, res) -> {
            Log.create(req);
            return 1;
        });
        post("/api/login/auth", (req,res)->{
            String result = Log.in(req);
            System.out.println("redirected to feed");
            res.type("application/json");
            res.cookie("authorization", result);
            String msg = new ResponseEntity(200, result).toGson();
            return msg;
        });
        get("/login", (req,res)->{
            res.type("text/html");
            res.redirect("login.html");
            return res;
        });
        get("/api/feed/get/:name", (req, res) -> new ResponseEntity(200, "OK", FeedController.getFeed(req)).toGson());
        post("/api/feed/post", (req, res) ->{
            FeedController.postFeed(req);
            return 1;
        });
        get("/feed", (req,res)->{
            res.type("text/html");
            res.redirect("feed.html");
            return res;
        });
    }
}
