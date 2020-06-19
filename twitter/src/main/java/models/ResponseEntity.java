package models;

import com.google.gson.Gson;

import java.util.List;

public class ResponseEntity {
    private Integer status;
    private String message;
    private List<Feed> feedList;

    public ResponseEntity(){}

    public ResponseEntity(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
    public ResponseEntity(Integer status, String message, List<Feed> feedList) {
        this.status = status;
        this.message = message;
        this.feedList = feedList;
    }
    public String toGson(){
        return new Gson().toJson(this);
    }
}
