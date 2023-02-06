package testEV3_BenedettiFalascaMauriRepetto;

import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.robotics.*;

public class RobotCommands {
	
	//RegulatedMotor ruspa = new EV3LargeRegulatedMotor(MotorPort.A);
	RegulatedMotor motorLeft = new EV3LargeRegulatedMotor(MotorPort.A);
	RegulatedMotor motorRight = new EV3LargeRegulatedMotor(MotorPort.B);
	
	public void avanti() {
		
		motorLeft.setSpeed(500);
		motorRight.setSpeed(500);
		
		motorLeft.forward();
		motorRight.forward();
		
		motorLeft.stop();
		motorRight.stop();
	}
	
	public void indietro() {
		
		//motorLeft.setSpeed(-500);
		//motorRight.setSpeed(-500);
		
		motorLeft.backward();
		motorRight.backward();
		
		motorLeft.stop();
		motorRight.stop();
	}
	
	public void destra() {

		motorLeft.setSpeed(700);
		motorRight.setSpeed(500);
		
		motorLeft.forward();
		motorRight.forward();
		
		motorLeft.stop();
		motorRight.stop();
	}
	
	public void sinistra() {
		
		motorLeft.setSpeed(500);
		motorRight.setSpeed(700);
		
		motorLeft.forward();
		motorRight.forward();
		
		motorLeft.stop();
		motorRight.stop();	
	}
}