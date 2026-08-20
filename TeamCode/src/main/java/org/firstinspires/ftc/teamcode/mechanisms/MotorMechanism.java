package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MotorMechanism {
    private DcMotor motor;
    public void init(HardwareMap hwMap) {
        motor = hwMap.get(DcMotor.class, "motor"); //left_motor/right_motor
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setPower(double speed) {
        motor.setPower(speed);
    }

    public double devideby2(double input) {
        double output = input/2;
        return output;
    }

    public void setZeroBehavior (DcMotor.ZeroPowerBehavior zerobehavior){
        motor.setZeroPowerBehavior(zerobehavior);
    }
}
