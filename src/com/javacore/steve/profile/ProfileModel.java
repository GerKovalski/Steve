package com.javacore.steve.profile;

import com.javacore.steve.common.BaseModel;

public class ProfileModel extends BaseModel {

    private int id;
    private String firstName;
    private String lastName;
    private boolean active;

    public static ProfileModel randomModel() {
        int rId = (int)(10*Math.random());
        boolean rActive = (rId % 2 == 0);
        String rFirstName = "Steve_" + rId;
        String rLastName = "Balmor_" + rId;
        return new ProfileModel(rId, rFirstName, rLastName, rActive);
    }

    public ProfileModel(int id, String firstName, String lastName, boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
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

    public boolean isActive() {
        return active;
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

    public void setActive(boolean active) {
        this.active = active;
    }

}
