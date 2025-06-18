package com.example.boot.vo;

public class User {
    private String uid;
    private String upw;
    private String unm;
    private String utel;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUpw() {
        return upw;
    }

    public void setUpw(String upw) {
        this.upw = upw;
    }

    public String getUnm() {
        return unm;
    }

    public void setUnm(String unm) {
        this.unm = unm;
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", upw='" + upw + '\'' +
                ", unm='" + unm + '\'' +
                ", utel='" + utel + '\'' +
                '}';
    }
}
