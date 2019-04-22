package com.javacore.steve.profile;

import com.javacore.steve.common.BaseModel;

import java.util.Date;

public class ProfileModel extends BaseModel {

    private int id;
    private String firstName;
    private String lastName;
    private String nickName;
    private int numberOfCrimes;
    private Date dateOfBirth;
    private boolean deceased;
    private String description;
    private String placeOfBirth;
    private Date getDateOfDeath;
    private String placeOfDeath;

    public static ProfileModel randomModel() {
        int rId = (int)(10*Math.random());
        String rFirstName = "Steve_" + rId;
        String rLastName = "Balmor_" + rId;
        return new ProfileModel(rId, rFirstName, rLastName);
    }

    public ProfileModel(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
