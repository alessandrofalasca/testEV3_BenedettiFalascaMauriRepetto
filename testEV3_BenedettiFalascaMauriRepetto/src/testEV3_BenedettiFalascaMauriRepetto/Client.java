package testEV3_BenedettiFalascaMauriRepetto;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class Client implements KeyListener {

	DataOutputStream send;

	public Client() {
		try {
			Socket socket = new Socket("10.0.1.1", 7000);

			System.out.println("Connesso!");

			send = new DataOutputStream(socket.getOutputStream());		

		} catch(UnknownHostException b) {
			System.out.println(b);
		} catch(IOException a) {
			System.out.println(a);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyChar() == 'w') {
			try {
				send.writeInt(1);
			} catch(IOException c) {
				System.out.println(c);
			}
		}

		if(e.getKeyChar() == 's') {
			try {
				send.writeInt(2);
			} catch(IOException d) {
				System.out.println(d);
			}
		}

		if(e.getKeyChar() == 'a') {
			try {
				send.writeInt(3);
			} catch(IOException g) {
				System.out.println(g);
			}
		}

		if(e.getKeyChar() == 'd') {
			try {
				send.writeInt(4);	
			} catch(IOException f) {
				System.out.println(f);
			}
		}

		if(e.getKeyChar() == 'c') {
			try {
				send.writeInt(5);	
			} catch(IOException h) {
				System.out.println(h);
			}
		}

		if(e.getKeyChar() == 'v') {
			try {
				send.writeInt(6);	
			} catch(IOException i) {
				System.out.println(i);
			}
		}


		if(e.getKeyChar() == 'k') {
			try {
				send.writeInt(7);	
			} catch(IOException j) {
				System.out.println(j);
			}
		}
		
		if(e.getKeyChar() == 'l') {
			try {
				send.writeInt(8);	
			} catch(IOException p) {
				System.out.println(p);
			}
		}
		
		if(e.getKeyChar() == 'r') {
			try {
				send.writeInt(9);	
			} catch(IOException p) {
				System.out.println(p);
			}
		}
		if(e.getKeyChar() == 'o') {
			try {
				send.writeInt(10);	
			} catch(IOException u) {
				System.out.println(u);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

	public static void main(String args[])
	{
		Frame f = new Frame("Controller");
		f.setLayout(new FlowLayout());
		f.setSize(500, 500);
		Label l = new Label();
		l.setText("Comanda il tuo robottino usando i tasti WASD!");
		f.add(l);
		f.setVisible(true);

		Client client = new Client();
		f.addKeyListener(client);
	}
}