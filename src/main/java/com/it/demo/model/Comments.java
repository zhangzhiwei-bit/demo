package com.it.demo.model;

import java.util.Date;

public class Comments {
    private String content;
    private String username;
    private String userurl;
    private String imageurls;
    private String position;
    private Date time;
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserurl() {
        return userurl;
    }
    public void setUserurl(String userurl) {
        this.userurl = userurl;
    }
    public String getImageurls() {
        return imageurls;
    }
    public void setImageurls(String imageurls) {
        this.imageurls = imageurls;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    @Override
    public String toString() {
        return "Comments [content=" + content + ", imageurls=" + imageurls + ", position=" + position + ", time=" + time
                + ", username=" + username + ", userurl=" + userurl + "]";
    }
    
}
