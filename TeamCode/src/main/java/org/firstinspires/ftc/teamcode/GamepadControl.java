package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.MotorMechanism;

@TeleOp
public class GamepadControl extends OpMode {
    MotorMechanism mechanism = new MotorMechanism();
    @Override
    public void init(){
        mechanism.init(hardwareMap);
    }

    @Override
    public void loop() {
        double stick = gamepad1.left_stick_y;
        boolean buttonPress = gamepad1.a;
        double finalSpeed;

        if (buttonPress){
            finalSpeed=stick;
        }else{
            finalSpeed= mechanism.devideby2(stick);
        }
        mechanism.setPower(finalSpeed);
        telemetry.addData("Speed", finalSpeed);
    }
}
