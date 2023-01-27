package testEV3_BenedettiFalascaMauriRepetto;

import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.robotics.*;
import lejos.utility.*;

public class RobotCommands {
	
	RegulatedMotor mL = new EV3LargeRegulatedMotor(MotorPort.B);
	RegulatedMotor mR = new EV3LargeRegulatedMotor(MotorPort.C);
	
	
	public void avanti() {
		
		mL.setSpeed(720);
		mR.setSpeed(720);
		
		mL.forward();
		mR.forward();
		
		Delay.msDelay(5000);
		
		mL.stop();
		mR.stop();
	}
	
	public void indietro() {		
		mL.setAcceleration(-220);
		mR.setAcceleration(-220);
		
		mL.setSpeed(720);
		mR.setSpeed(720);
		
		mL.backward();
		mR.backward();
		
		Delay.msDelay(5000);
		
		mL.stop();
		mR.stop();
	}
	
	public void destra() {

		mL.setSpeed(720);
		mR.setSpeed(520);
		
		mL.backward();
		mR.backward();
		
		Delay.msDelay(5000);
		
		mL.stop();
		mR.stop();
	}
	
	public void sinistra() {
		
		mL.setSpeed(520);
		mR.setSpeed(720);
		
		mL.backward();
		mR.backward();
		
		Delay.msDelay(5000);
		
		mL.stop();
		mR.stop();	
	}
}