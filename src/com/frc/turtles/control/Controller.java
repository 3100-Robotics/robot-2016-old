package com.frc.turtles.control;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Created by Zach Herridge on 4/6/2016.
 */
public class Controller {

    private static Joystick gameController = new Joystick(1);

    public static double getRightStickX(){
        return gameController.getRawAxis(4);
    }

    public static double getRightStickY(){
        return gameController.getRawAxis(5);
    }

    public static double getLeftStickX(){
        return gameController.getRawAxis(0);
    }

    public static double getLeftStickY(){
        return gameController.getRawAxis(1);
    }

    public static boolean getButtonA(){
        return gameController.getRawButton(1);
    }

    public static boolean getButtonX(){
        return gameController.getRawButton(3);
    }

    public static boolean getButtonY(){
        return gameController.getRawButton(4);
    }

    public static boolean getButtonB(){
        return gameController.getRawButton(2);
    }

    public static boolean getButtonRightBumper(){
        return gameController.getRawButton(6);
    }

    public static boolean getButtonLeftBumper(){
        return gameController.getRawButton(5);
    }

    public static int getDPad(){
        return gameController.getPOV(-1);
    }

    public static double getRightTrigger(){
        return gameController.getRawAxis(3);
    }

    public static double getLeftTrigger(){
        return gameController.getRawAxis(2);
    }



}
