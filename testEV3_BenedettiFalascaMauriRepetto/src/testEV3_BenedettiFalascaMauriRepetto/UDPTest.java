package testEV3_BenedettiFalascaMauriRepetto;

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
        if(echo.equals("hello server") == true) {
        	echo = client.sendEcho("server is working");
        }
        else {
        	echo.equals("hello server not working");
        }
    }

    //After
    public void tearDown() {
        client.sendEcho("end");
        client.close();
    }
}