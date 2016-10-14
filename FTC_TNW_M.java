package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Shawn on 8/3/2016.
 */



//TEAM VALOR!!!!!


public class FTC_TNW_M extends OpMode {
    DcMotor rightFront;
    DcMotor leftFront;

    float rightPower = 0;
    float leftPower = 0;

    @Override
    public void init () {
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        leftFront.setDirection(DcMotor.Direction.REVERSE);




    }
    @Override
    public void loop (){




        {
            float left = gamepad1.left_stick_y;
            float right = gamepad1.right_stick_y;
            right = Range.clip(right, -1, 1);
            left = Range.clip(left, -1, 1);



//            HERE

            if (right > 0)
                rightPower = rightPower + (float) 0.01;

            if (right == 0)
                rightPower = 0;

            if (right < 0)
                rightPower = rightPower + (float) -0.01;


            if (left > 0)
                leftPower = leftPower + (float) 0.01;

            if (left == 0)
                leftPower = 0;

            if (left < 0)
                leftPower = leftPower + (float) -0.01;

//            'If the left joy is up, make sure the power doesnt go to high'
            if(left >0){

                if (leftPower > left)
                    leftPower = left;

                if (leftPower < 0.1)
                    leftPower = (float) 0.1;
            }
            if (left <0){

                if (leftPower < left)
                    leftPower = left;
                if (leftPower > -0.1)
                    leftPower = (float) -0.1;
            }

            if (right >0){

                if (rightPower > right)
                    rightPower = right;
                if (rightPower < 0.1)
                    rightPower = (float) 0.1;
            }

            if (right <0){

                if (rightPower < right)
                    rightPower = right;
                if (rightPower > -0.1)
                   rightPower = (float) -0.1;
            }




//            HERE

            rightFront.setPower(rightPower);
            leftFront.setPower(leftPower);
            telemetry.addData("01", "Left Drive: " + leftFront.getPower());
            telemetry.addData("02", "Right Drive: " + rightFront.getPower());
            telemetry.addData("03", "Gamepad1 Left: " + -gamepad1.left_stick_y);
            telemetry.addData("04", "Gamepad1 Right: " + -gamepad1.right_stick_y);

        }



    }
}
