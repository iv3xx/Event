package com.example.app_Event_manager.model;

import com.example.app_Event_manager.model.enums.Gender;

import java.util.UUID;

public class Guest {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private Gender gender;
    private String comment;

    public Guest() {
        // для тестов
    }
    public Guest(UUID id, String firstName, String lastName, String email, int age, Gender gender, String comment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.comment = comment;
    }
    public boolean isChild() {
        return this.age < 18 || this.gender == Gender.Child;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
