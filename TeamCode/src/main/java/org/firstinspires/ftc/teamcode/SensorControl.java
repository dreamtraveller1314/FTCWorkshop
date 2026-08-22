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
        boolean sensorPressed = robot.touchSensorpressed();
        if (sensorPressed == true){
            robot.setServoPosition(0.0);
        } else if (sensorPressed == false){
            robot.setServoPosition(0.5);
        }
        /*double distance = robot.distance();
        if (distance<2){
            robot.setServoPosition(0.0);
        }else{
            robot.setServoPosition(0.5);
        }*/
        telemetry.addData("Servo Position", robot.getServoPosition());
    }
}
