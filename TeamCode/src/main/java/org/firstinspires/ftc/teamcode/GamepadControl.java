package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.mechanisms.MotorMechanism;

@TeleOp
public class GamepadControl extends OpMode {
    MotorMechanism mechanism = new MotorMechanism();

    @Override
    public void init() {
        mechanism.init(hardwareMap);
        telemetry.addData("Status", "Clean OOP Initialized");
    }

    @Override
    public void loop() {
        double stick = gamepad1.left_stick_y;
        boolean buttonPressed = gamepad1.a;
        double finalSpeed;

        if (buttonPressed) {
            finalSpeed = stick;
            telemetry.addData("Speed Mode", "Precision (Squared Input)");
        } else {
            finalSpeed = mechanism.devideby2(stick);
            telemetry.addData("Speed Mode", "Normal (Linear Input)");
        }
        if (gamepad1.x) {
            mechanism.setZeroBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }else if(gamepad1.y){
            mechanism.setZeroBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        }

        mechanism.setPower(finalSpeed);
        telemetry.addData("Raw Stick Y", stick);
        telemetry.addData("Output Motor Power", finalSpeed);
    }
}