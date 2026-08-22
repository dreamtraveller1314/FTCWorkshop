package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class DriveMechanism {
    private DcMotor LeftMotor, RightMotor; //frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor;
    private Servo servo;
    private DigitalChannel touchSensor;
    //private DistanceSensor distanceSensor;
    private IMU imu;

    public void init(HardwareMap hwMap) {
        LeftMotor = hwMap.get(DcMotor.class, "left_motor"); //driver hub configure
        RightMotor = hwMap.get(DcMotor.class, "right_motor");
        //backLeftMotor = hwMap.get(DcMotor.class, "back_left_motor");
        //backRightMotor = hwMap.get(DcMotor.class, "back_right_motor");

        LeftMotor.setDirection(DcMotor.Direction.REVERSE);
        //backLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        LeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        LeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        servo = hwMap.get(Servo.class, "servo"); //depends on the driver hub configure name
        touchSensor = hwMap.get(DigitalChannel.class , "touch_sensor");
        touchSensor.setMode(DigitalChannel.Mode.INPUT);
        //distanceSensor = hwMap.get(DistanceSensor.class, "distance_sensor");

        imu = hwMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot revOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD);
        imu.initialize(new IMU.Parameters(revOrientation));
    }

    public void drive(double throttle, double spin) {
        double leftPower = throttle + spin;
        double rightPower = throttle - spin;
        double largest = Math.max(Math.abs(leftPower), Math.abs(rightPower));
        if (largest > 1.0) {
            leftPower /= largest;
            rightPower /= largest;
        }

        LeftMotor.setPower(leftPower);
        RightMotor.setPower(rightPower);
        //backLeftMotor.setPower(leftPower);
        //backRightMotor.setPower(rightPower);
    }

    public void setServoPosition (double position){
        servo.setPosition(position);
    }

    public double getServoPosition (){
        return servo.getPosition();
    }

    public boolean touchSensorpressed(){
        return !touchSensor.getState();
    }

    /*public double distance(){
        return distanceSensor.getDistance(DistanceUnit.CM);
    }*/

    public double getHeading(){
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
    }
}