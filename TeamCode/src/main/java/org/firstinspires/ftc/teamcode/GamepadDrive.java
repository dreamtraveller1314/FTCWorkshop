package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.DriveMechanism;

@TeleOp
public class GamepadDrive extends OpMode {
    DriveMechanism driveBase = new DriveMechanism();

    @Override
    public void init() {
        driveBase.init(hardwareMap);
    }

    @Override
    public void loop() {
        double throttle = -gamepad1.left_stick_y;
        double spin = gamepad1.right_stick_x;
        driveBase.drive(throttle, spin);
    }
}