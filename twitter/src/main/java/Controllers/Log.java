package Controllers;

import Logics.Generator;
import Logics.UtilToSQLConversion;
import Service.UserService;
import com.google.gson.Gson;
import models.User;
import spark.Request;

import java.util.Date;


public class Log {

    public static String create(Request req){
        UserService userService = new UserService();

        User userinfo = new Gson().fromJson(req.body(), User.class);
        if (!checkIfExists(userinfo, userService)) {
            userService.create(userKeyDefination(userinfo));
        }
        else System.out.println("already exists");
        return "";
    }

    public static String in(Request req){

        UserService userService = new UserService();

        User userinfo = new Gson().fromJson(req.body(), User.class);
        System.out.println(req.body());
        User temporaryUser = userService.findByUsername(userinfo.getUsername()); //USER OBJECT FROM DB
        if(checkAuthData(userinfo, temporaryUser))
        {
            if (temporaryUser.getDateOfKeyExpiration().before(new Date())) {
                User userUpdated  = userKeyDefination(temporaryUser);
                userService.update(userUpdated);
                return userUpdated.getKey();
            }
            else { return temporaryUser.getKey(); }
        }
        else { return "wrong credientals"; }
    }
    private static User userKeyDefination(User user){
        user.setKey(Generator.randomize());
        user.setDateOfKeyExpiration(UtilToSQLConversion.init());
        return user;
    }

    private static boolean checkAuthData(User user, User temporaryUser){
        if(temporaryUser!=null && (temporaryUser.getPassword().equals(user.getPassword()))) { return true; }
        else return false;
    }

    private static boolean checkIfExists(User user, UserService userService){
        if (userService.findByUsername(user.getUsername())==null) {
            if (userService.findByEmail(user.getEmail())==null) {
                return false;
            }
        }
        return true;
    }
}
