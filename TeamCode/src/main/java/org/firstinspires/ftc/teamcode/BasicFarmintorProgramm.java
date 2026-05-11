package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/*
Tasks:
- drivetrain
- intake
- transfer
- kickstand
- gate
- hood
 */

@TeleOp(name="Basic: Farmintor Programm", group="Linear OpMode")
@Disabled
public class BasicFarmintorProgramm extends LinearOpMode {
    private ElapsedTime running = new ElapsedTime(); //variables
    private DcMotor front_left = null;
    private DcMotor front_right = null;
    private DcMotor back_left = null;
    private DcMotor back_right = null;



    @Override
    public void runOpMode(){
        front_right = hardwareMap.get(DcMotor.class, "front_left_drive");
        front_left = hardwareMap.get(DcMotor.class, "front_right_drive" );
        back_left = hardwareMap.get(DcMotor.class, "back_left_drive");
        back_right = hardwareMap.get(DcMotor.class, "back_right_drive");


        front_left.setDirection(DcMotor.Direction.REVERSE);
        back_left.setDirection(DcMotor.Direction.REVERSE);
        front_right.setDirection(DcMotorSimple.Direction.FORWARD);
        back_right.setDirection(DcMotorSimple.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {
            double max;

            double axial = -gamepad1.left_stick_y; // axial - forward/back (left stick Y), "-"
            double lateral = gamepad1.left_stick_x;// lateral - the sideways movement (left, X)
            double pitch = gamepad1.right_stick_x;// yaw - the rotation (right, x)

            double front_right_power = axial + lateral + pitch;
            double front_left_power = axial - lateral - pitch;
            double back_left_power = axial - lateral + pitch;
            double back_right_power = axial + lateral - pitch;

            max = Math.max(Math.max(Math.max(Math.abs(front_left_power), Math.abs(front_left_power)), Math.abs(back_left_power)),Math.abs(back_right_power));

            if (max>1) {
                front_left_power /= max;
                front_right_power /= max;
                back_left_power /= max;
                back_right_power /= max;
            }

            front_left.setPower(front_left_power);
            front_right.setPower(front_right_power);
            back_left.setPower(back_left_power);
            back_right.setPower(back_right_power);

            telemetry.addData("status: ", "time" + running.toString());
            telemetry.update();

            //https://gm0.org/en/latest/docs/software/tutorials/mecanum-drive.html



        }



    }

}
