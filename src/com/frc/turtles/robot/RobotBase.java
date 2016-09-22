package com.frc.turtles.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;

/**
 * Created by Zach Herridge on 4/6/2016.
 */
public class RobotBase {


    public static final Victor LEFT_DRIVE_MOTOR = new Victor(5);
    public static final Victor RIGHT_DRIVE_MOTOR = new Victor(6);

    public static final Victor ELEVATOR_MOTOR = new Victor(2);
    public static final Victor INTAKE_MOTOR = new Victor(4);

    public static final Victor ANGLE_MOTOR = new Victor(0);
    public static final Victor ROTATION_MOTOR = new Victor(3);
    public static final Victor SHOOTER_MOTOR = new Victor(1);

    public static final Encoder ANGLE_ENCODER = new Encoder(0, 0);
    public static final Encoder ROTATION_ENCODER = new Encoder(0, 0);

}
