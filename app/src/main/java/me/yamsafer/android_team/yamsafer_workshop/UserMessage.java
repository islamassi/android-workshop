package me.yamsafer.android_team.yamsafer_workshop;


import com.google.firebase.database.PropertyName;

/**
 * Created by islam on 3/10/18.
 */

public class UserMessage {

    private String imageUrl;

    private String sender;

    private String message;


    @PropertyName("photoUrl")
    public String getImageUrl() {

        return imageUrl;
    }

    @PropertyName("photoUrl")
    public void setImageUrl(String imageUrl) {

        this.imageUrl = imageUrl;
    }

    @PropertyName("messagesSender")
    public String getSender() {

        return sender;
    }

    @PropertyName("messagesSender")
    public void setSender(String sender) {

        this.sender = sender;
    }

    @PropertyName("text")
    public String getMessage() {

        return message;
    }

    @PropertyName("text")
    public void setMessage(String text) {

        this.message = text;
    }
}
