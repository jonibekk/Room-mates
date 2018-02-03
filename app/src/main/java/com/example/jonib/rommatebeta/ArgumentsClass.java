package com.example.jonib.rommatebeta;

/**
 * Created by jonib on 2/3/2018.
 */

public class ArgumentsClass {

    private int imageView;
    private String room_name;
    private String users;
    private String description;


    public ArgumentsClass(int imageView, String room_name, String users, String description) {
        this.imageView = imageView;
        this.room_name = room_name;
        this.users = users;
        this.description = description;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
