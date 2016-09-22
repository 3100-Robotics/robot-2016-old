package com.frc.turtles.robot;

import com.frc.turtles.subsystems.*;
import com.frc.zapi.ZRobot;
import com.frc.zapi.ZTable;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * Created by Zach Herridge on 4/6/2016.
 */
public class Robot2015 extends IterativeRobot {

    public static final Intake INTAKE = new Intake();
    public static final DriverTrain DRIVER_TRAIN = new DriverTrain();
    public static final Turret TURRET = new Turret();
    public static final TableUpdater TABLE_UPDATER = new TableUpdater();
    public static final Camera CAMERA = new Camera();

    public static final ZTable TABLE = new ZTable("3100Robotics");

    public static final ZRobot robot = new ZRobot();
    
    @Override
    public void robotInit() {
        robot.addSubSystem(TABLE_UPDATER, DRIVER_TRAIN, TURRET, INTAKE, CAMERA);
    }

    @Override
    public void autonomousPeriodic() {
        robot.loop(true);
    }

    @Override
    public void teleopPeriodic() {
        robot.loop(false);
    }
    
    @Override
    public void teleopInit() {
        INTAKE.setSystem(false);
        TURRET.toggleShot(false);
    }
}
