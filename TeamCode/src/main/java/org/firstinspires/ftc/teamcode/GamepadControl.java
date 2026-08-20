package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class GamepadControl extends OpMode {
    DcMotor motor;

    @Override
    public void init() {
        motor = hardwareMap.get(DcMotor.class, "motor");
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        telemetry.addData("Status", "Motor Configured");
    }

    @Override
    public void loop() {
        motor.setPower(0.5);
        telemetry.addData("Status", "Motor Spinning at 0.5");
    }
}
