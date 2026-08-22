package org.firstinspires.ftc.teamcode.Module4;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.mechanisms.DriveMechanism;

@Autonomous
public class AutonomousMission extends OpMode {
    DriveMechanism robot = new DriveMechanism();
    private static final double TICKS_PER_REV = 537.7;
    private static final double GEAR_RATIO = 1.0;
    private static final double WHEEL_DIAMETER_INCHES = 3.779;
    private static final double COUNTS_PER_INCH = (TICKS_PER_REV * GEAR_RATIO) / (WHEEL_DIAMETER_INCHES * Math.PI);

    private enum State {
        START_FORWARD,
        DRIVE_FORWARD,
        START_TURN,
        TURN_90,
        START_SERVO,
        SERVO,
        FINISHED
    }

    private State state;
    private double timer;

    @Override
    public void init() {
        robot.init(hardwareMap);
        state = State.START_FORWARD;
    }

    @Override
    public void loop() {
        telemetry.addData("Active State", state);
        switch (state) {
            case START_FORWARD:
                int forwardTarget = (int) (24.0 * COUNTS_PER_INCH);
                robot.resetEncoders();
                robot.setTargetPosition(forwardTarget, forwardTarget);
                robot.setRunMode(DcMotor.RunMode.RUN_TO_POSITION);
                robot.setMotorPowers(0.4, 0.4);
                state = State.DRIVE_FORWARD;
                break;

            case DRIVE_FORWARD:
                if (!robot.isBusy() || robot.isTouchSensorPressed()) {
                    robot.setMotorPowers(0.0, 0.0);
                    robot.setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
                    state = State.START_TURN;
                }
                break;

            case START_TURN:
                robot.resetHeading();
                state = State.TURN_90;
                break;

            case TURN_90:
                double currentHeading = robot.getHeading();
                double targetAngle = -90.0;
                if (Math.abs(currentHeading - targetAngle) > 2.0) {
                    robot.setMotorPowers(0.3, -0.3);
                } else {
                    robot.setMotorPowers(0.0, 0.0);
                    timer = getRuntime();
                    state = State.START_SERVO;
                }
                break;

            case START_SERVO:
                robot.setServoPosition(1.0);
                state = State.SERVO;
                break;

            case SERVO:
                if (getRuntime() - timer > 1.0) {
                    robot.setServoPosition(0.0);
                    state = State.FINISHED;
                }
                break;

            case FINISHED:
                robot.setMotorPowers(0.0, 0.0);
                telemetry.addData("Mission Status", "Completed successfully!");
                break;

            default:
                robot.setMotorPowers(0.0, 0.0);
                break;
        }
    }
}

