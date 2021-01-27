package com.example.resipesbook.Authentication;

public class UserData {
    private String Email;
    private String Uid;

    public UserData(String email, String uid) {
        Email = email;
        Uid = uid;
    }

    public String getEmail() {
        return Email;
    }

    public String getUid() {
        return Uid;
    }
    public UserData() {
    }
}
