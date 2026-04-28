package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Basic: Farmintor Programm", group="Linear OpMode")
@Disabled
public class BasicFarmintorProgramm extends LinearOpMode {
    private ElapsedTime running = new ElapsedTime();
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





    }
}
