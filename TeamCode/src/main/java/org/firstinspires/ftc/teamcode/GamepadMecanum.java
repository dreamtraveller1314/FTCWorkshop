package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.MecanumMechanism;

@TeleOp
public class GamepadMecanum extends OpMode {

    // Instantiate our helper drivetrain mechanism class [17]
    MecanumMechanism drive = new MecanumMechanism();

    // Doubles to store input states [17]
    private double forward;
    private double strafe;
    private double rotate;

    @Override
    public void init() {
        drive.init(hardwareMap);
    }

    @Override
    public void loop() {
        forward = -gamepad1.left_stick_y;
        strafe  = gamepad1.left_stick_x;
        rotate  = gamepad1.right_stick_x;

        drive.driveFieldRelative(forward, strafe, rotate);

        telemetry.addData("Forward Vector", forward);
        telemetry.addData("Strafe Vector", strafe);
        telemetry.addData("Rotation Vector", rotate);
    }
}
