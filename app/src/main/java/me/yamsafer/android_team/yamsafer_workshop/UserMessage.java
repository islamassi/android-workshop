package me.yamsafer.android_team.yamsafer_workshop;

/**
 * Created by islam on 3/10/18.
 */

public class UserMessage {

    private String photoUrl;

    private String messagesSender;

    private String text;


    public String getPhotoUrl() {

        return photoUrl;
    }


    public void setPhotoUrl(String photoUrl) {

        this.photoUrl = photoUrl;
    }


    public String getMessagesSender() {

        return messagesSender;
    }


    public void setMessagesSender(String messagesSender) {

        this.messagesSender = messagesSender;
    }


    public String getText() {

        return text;
    }


    public void setText(String text) {

        this.text = text;
    }
}
