package testEV3_BenedettiFalascaMauriRepetto;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Comandi{

	Socket clientSocket = null;
	ServerSocket serverSocket = null;
	DataInputStream receive = null;

	RegulatedMotor motorLeft = new EV3LargeRegulatedMotor(MotorPort.A);
	RegulatedMotor motorRight = new EV3LargeRegulatedMotor(MotorPort.B);
	RegulatedMotor bucket = new EV3MediumRegulatedMotor(MotorPort.C);

	public void Connetti() {
		try {
			serverSocket = new ServerSocket(7000);
			System.out.println("Server in ascolto");

			System.out.println("Aspettando una\n"
					+ "connessione...");

			clientSocket = serverSocket.accept();
			System.out.println("Client connesso!");

			receive = new DataInputStream(clientSocket.getInputStream());

			int n = 0;
			while(true) {
				try {
					n = receive.readInt();
				} catch(IOException b) {
					System.out.println(b);
				}

				switch(n) {
				case 1:
					System.out.println("cmd \"w\": avanti");
					motorLeft.setSpeed(900);
					motorRight.setSpeed(900);

					motorLeft.forward();
					motorRight.forward();

					break;

				case 2:
					System.out.println("cmd \"s\": indietro");
					motorLeft.setSpeed(-900);
					motorRight.setSpeed(-900);

					motorLeft.backward();
					motorRight.backward();

					break;

				case 3:
					System.out.println("cmd \"a\": sinistra");
					motorLeft.setSpeed(700);
					motorRight.setSpeed(900);

					motorLeft.forward();
					motorRight.forward();

					break;

				case 4:
					System.out.println("cmd \"d\": destra");
					motorLeft.setSpeed(900);
					motorRight.setSpeed(700);

					motorLeft.forward();
					motorRight.forward();

					break;

				case 5:
					System.out.println("cmd \"c\": stop");
					motorLeft.setSpeed(0);
					motorRight.setSpeed(0);

					break;

				case 6:
					System.out.println("VITTORIA REALE!!!");
					motorLeft.setSpeed(900);
					motorRight.setSpeed(0);

					motorLeft.forward();

					bucket.setSpeed(-900);
					bucket.backward();

					Delay.msDelay(500);
					
					bucket.stop();

					bucket.setSpeed(900);
					bucket.forward();
					
					Delay.msDelay(500);
					
					bucket.stop();

					break;

				case 7:
					System.out.println("Ruspaaa!!!");
					bucket.setSpeed(-900);
					bucket.backward();
					
					Delay.msDelay(500);
					
					bucket.stop();

					break;

				case 8:
					System.out.println("Ruspaaa!!!");
					bucket.setSpeed(900);
					bucket.forward();

					Delay.msDelay(500);
					
					bucket.stop();
				}
			}
		} catch(IOException a) {
			System.out.println(a);
		}	
	}
}
