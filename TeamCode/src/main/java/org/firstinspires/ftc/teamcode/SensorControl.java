package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.mechanisms.DriveMechanism;

@TeleOp
public class SensorControl extends OpMode {
    DriveMechanism robot = new DriveMechanism();

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.x) {
            robot.setServoPosition(0.0);
        } else if (gamepad1.y) {
            robot.setServoPosition(0.5);
        }

        telemetry.addData("Servo Position", robot.getServoPosition());
    }
}