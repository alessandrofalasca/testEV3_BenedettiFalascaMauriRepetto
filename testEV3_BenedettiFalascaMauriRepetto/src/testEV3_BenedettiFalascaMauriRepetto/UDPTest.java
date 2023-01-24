package testEV3_BenedettiFalascaMauriRepetto;

import java.io.IOException;
import java.net.*;

public class UDPTest {
    EchoClient client;

    //Before
    public void setup(){
        new EchoServer().start();
        client = new EchoClient();
    }

    //Test
    public void whenCanSendAndReceivePacket_thenCorrect() {
        String echo = client.sendEcho("hello server");
        if ("hello server" == echo) {
        echo = client.sendEcho("server is working");
        }
        else {
        	echo.equals("hello server");
        };
    }

    //After
    public void tearDown() {
        client.sendEcho("end");
        client.close();
    }
}