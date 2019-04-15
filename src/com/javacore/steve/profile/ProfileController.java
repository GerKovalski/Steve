package com.javacore.steve.profile;

import com.javacore.steve.common.ConsoleCanvas;

public class ProfileController {

    private ProfileModel profileModel;
    private ProfileView profileView;
    private ProfileStore profileStore;
    private ConsoleCanvas canvas;

    {
        profileStore.INSTANCE.loadData();
        profileView = new ProfileView();
        canvas = new ConsoleCanvas();
    }

    public void showProfile(int id) {
        ProfileModel model = profileStore.INSTANCE.getProfile(id);
        if (model == null) {
            System.out.println("Profile not found.");
        } else {
            profileView.setModel(model);
            profileView.draw(canvas);
        }
    }

    public ProfileModel getProfileModel() {
        return profileModel;
    }

    public void setProfileModel(ProfileModel profileModel) {
        this.profileModel = profileModel;
    }

    public ProfileView getProfileView() {
        return profileView;
    }

    public void setProfileView(ProfileView profileView) {
        this.profileView = profileView;
    }
}
