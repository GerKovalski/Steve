package com.javacore.steve.profile;

import com.javacore.steve.common.BaseView;
import com.javacore.steve.common.Canvas;

public class ProfileView extends BaseView {
    @Override
    public void draw() {
        System.out.println("Criminal profile view");
        System.out.println("ID: " + ((ProfileModel) model).getId());
        System.out.println("Name: " + ((ProfileModel) model).getName());
        System.out.println("Active: " + ((ProfileModel) model).isActive());
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText("Criminal profile view");
        canvas.drawText("ID: " + ((ProfileModel) model).getId());
        canvas.drawText("Name: " + ((ProfileModel) model).getName());
        canvas.drawText("Active: " + ((ProfileModel) model).isActive());
        canvas.drawSquare(6);
    }
}
