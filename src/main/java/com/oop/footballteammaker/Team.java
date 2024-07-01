package com.oop.footballteammaker;

public class Team {
    private String name;
    private String phonenumber;
    private String university;
    private String tag;
    private String gender;

    public Team(String name, String phonenumber, String university, String tag, String gender) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.university = university;
        this.tag = tag;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", university='" + university + '\'' +
                ", tag='" + tag + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
