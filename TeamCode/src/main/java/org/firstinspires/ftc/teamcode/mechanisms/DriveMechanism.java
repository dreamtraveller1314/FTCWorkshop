package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveMechanism {
    private DcMotor LeftMotor, RightMotor; //frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor;

    public void init(HardwareMap hwMap) {
        LeftMotor = hwMap.get(DcMotor.class, "left_motor");
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
}
