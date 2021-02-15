package com.example.whatsapp;

public class user {
    String profilepic , username, email , password , lastmessage, userId;

    public user(String profilepic, String username, String email, String password, String lastmessage, String userId) {
        this.profilepic = profilepic;
        this.username = username;
        this.email = email;
        this.password = password;
        this.lastmessage = lastmessage;
        this.userId = userId;
    }

    public user(){}

    public user( String username, String email, String password) {

        this.username = username;
        this.email = email;
        this.password = password;

    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastmessage() {
        return lastmessage;
    }

    public void setLastmessage(String lastmessage) {
        this.lastmessage = lastmessage;
    }

    public String getUserId(String key) {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
