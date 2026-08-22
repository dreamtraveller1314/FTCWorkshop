package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
//@Autonomous
public class HelloWorld extends OpMode {
    @Override
    public void init(){
        telemetry.addData("Hello", "World");
        int teamNumber = 28028;
        double motorSpeed = 0.75;
        boolean clawStatus = false;
        String teamName = "ABC Team";
        telemetry.addData ("Team Number", teamNumber);
        telemetry.addData ("Motor Speed", motorSpeed);
        telemetry.addData ("Claw Open?", clawStatus);
        telemetry.addData ("Team Name", teamName);
        if (motorSpeed>0){
            telemetry.addData ("Motor Direction", "Forward");
        } else-if(motorSpeed<0){
            telemetry.addData ("Motor Direction", "Backward");
        }else{
            telemetry.addData ("Motor Direction", "Stop");
        }
    }//dont forget to add motordirection variable
    public void loop(){

    }
}
