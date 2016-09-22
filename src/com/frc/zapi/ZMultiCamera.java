package com.frc.zapi;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;

public class ZMultiCamera {

    private CameraServer camServer;
    private Image frame;

    private int cam0, cam1;
    private int currentCam = 0;

    public void start(){
        cam0 = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        cam1 = NIVision.IMAQdxOpenCamera("cam5", NIVision.IMAQdxCameraControlMode.CameraControlModeController);

        currentCam = cam0;
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        camServer = CameraServer.getInstance();

        changeCamera(cam0);
    }

    public void toggleCamera(){
        if(currentCam == cam0){
            changeCamera(cam1);
        }
        else{
            changeCamera(cam0);
        }
    }


    public void startCapture(int id){
        NIVision.IMAQdxStopAcquisition(currentCam);
        NIVision.IMAQdxConfigureGrab(id);
        NIVision.IMAQdxStartAcquisition(id);
    }

    public void changeCamera(int id){
        startCapture(id);
        currentCam = id;
    }

    public void stop(){
        NIVision.IMAQdxStopAcquisition(cam0);
        NIVision.IMAQdxStopAcquisition(cam1);
    }

    public void sendImage(){
        NIVision.IMAQdxGrab(currentCam, frame, 1);
        camServer.setImage(frame);
    }

}