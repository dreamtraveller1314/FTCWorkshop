package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class GamepadControl extends OpMode {
    DcMotor motor;
    @Override
    public void init(){
        motor = hardwareMap.get(DcMotor.class,"motor"); //motor name in driver hub
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop() {
        double speed = gamepad1.left_stick_y;
        motor.setPower(speed);
        telemetry.addData("Speed", speed);
    } //range motor speed 1 to -1
}
