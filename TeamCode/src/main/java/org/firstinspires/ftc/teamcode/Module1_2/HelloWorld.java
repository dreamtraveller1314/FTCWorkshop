package org.firstinspires.ftc.teamcode.Module1_2;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
//@Autonomous

public class HelloWorld extends OpMode {
    @Override
    public void init() {
        telemetry.addData("Hello","World");
        int teamNumber = 23014;
        double motorSpeed = 0.75;
        boolean clawClosed = true;
        String teamName = "The Flying Dutchman";
        telemetry.addData("Team Number", teamNumber);
        telemetry.addData("motor speed", motorSpeed);
        telemetry.addData("claw closed", clawClosed);
        telemetry.addData("Name", teamName);
    }

    @Override
    public void loop() {

    }
}
