package testEV3_BenedettiFalascaMauriRepetto;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class Comandi{

	Socket clientSocket = null;
	ServerSocket serverSocket = null;
	DataInputStream receive = null;
	
	RegulatedMotor motorLeft = new EV3LargeRegulatedMotor(MotorPort.A);
	RegulatedMotor motorRight = new EV3LargeRegulatedMotor(MotorPort.B);
	
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
						motorLeft.setSpeed(500);
						motorRight.setSpeed(500);
						
						motorLeft.forward();
						motorRight.forward();
						
						break;
					case 2:
						System.out.println("cmd \"s\": indietro");
						motorLeft.setSpeed(-500);
						motorRight.setSpeed(-500);
						
						motorLeft.backward();
						motorRight.backward();

						break;
					case 3:
						System.out.println("cmd \"a\": sinistra");
						motorLeft.setSpeed(500);
						motorRight.setSpeed(700);
						
						motorLeft.forward();
						motorRight.forward();
	
						break;
					case 4:
						System.out.println("cmd \"d\": destra");
						motorLeft.setSpeed(700);
						motorRight.setSpeed(500);
						
						motorLeft.forward();
						motorRight.forward();

						break;
					case 5:
						System.out.println("Server sta chiudendo la connessione!");
						clientSocket.close();
						receive.close();
				}
			}	
		} catch(IOException a) {
			System.out.println(a);
		}	
	}
}
