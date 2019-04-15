package com.javacore.steve.profile;

import java.util.HashMap;
import java.util.Map;

public enum  ProfileStore {
    INSTANCE;

    Map<Integer, ProfileModel> profilesDataBase;

    {
        profilesDataBase = new HashMap<>();
    }

    public void loadData() {
        profilesDataBase.clear();
        for (int i = 0; i < 50; i++) {
            ProfileModel model = ProfileModel.randomModel();
            profilesDataBase.put(model.getId(), model);
        }
    }

    public ProfileModel getProfile(int id) {
        return profilesDataBase.get(id);
    }

}
