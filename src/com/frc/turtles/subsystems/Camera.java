package com.frc.turtles.subsystems;

import com.frc.turtles.control.Controller;
import com.frc.zapi.ZMultiCamera;
import com.frc.zapi.ZSystem;

/**
 * Created by Zach Herridge on 4/7/2016.
 */
public class Camera extends ZSystem{

    private ZMultiCamera camera = new ZMultiCamera();
    private long lastToggleTime = 0;

    public Camera() {
        camera.start();
    }

    @Override
    public void autoLoop() {
        if (Controller.getButtonRightBumper() && (System.currentTimeMillis() - lastToggleTime) > 500){
            lastToggleTime = System.currentTimeMillis();
            camera.toggleCamera();
        }

        camera.sendImage();
    }

    @Override
    public void teleOpLoop() {
        camera.sendImage();
    }
}
