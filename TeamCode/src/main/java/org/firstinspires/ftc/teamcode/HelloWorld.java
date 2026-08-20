package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
//@Autonomous

public class HelloWorld extends OpMode {
    @Override
    public void init() {
        telemetry.addData("Hello","World");
        int teamNumber = 23014;
        double motorSpeed = 0.75; //change value here
        boolean clawClosed = true;
        String teamName = "The Flying Dutchman";
        telemetry.addData("Team Number", teamNumber);
        telemetry.addData("motor speed", motorSpeed);
        telemetry.addData("claw closed", clawClosed);
        telemetry.addData("Name", teamName);
        if (motorSpeed >0) {
            telemetry.addData("Motor Direction", "Forward");
        }
        else if (motorSpeed < 0 ) {
            telemetry.addData("Motor Direction", "Backward");
        } else {
            telemetry.addData("Motor Direction", "0");}
    }

    @Override
    public void loop() {

    }
}
