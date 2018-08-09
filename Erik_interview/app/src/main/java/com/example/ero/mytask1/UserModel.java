package com.example.ero.mytask1;

public class UserModel {
    private String title;
    private String imageUrl;
    private String phone;
    private String email;
    private boolean femail;

    public UserModel(String title, String imageUrl, String phone, String email, boolean femail) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.phone = phone;
        this.email = email;
        this.femail = femail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserModel(boolean girl) {
        this.femail = girl;
    }

    public boolean isFemail() {
        return femail;
    }

    public void setFemail(boolean femail) {
        this.femail = femail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
