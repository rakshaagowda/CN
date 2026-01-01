package CN_LAB;
import java.io.*;
import java.net.*;
public class UDPClient {
    public static void main(String args[]) throws Exception{
        BufferedReader inFormUser =  new BufferedReader( new InputStreamReader(System.in));
        DatagramSocket  clientsocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData =  new byte[1024];
        byte[] receivedData =  new byte[1024];
        System.out.print("Enter message: ");
        String sentence =  inFormUser.readLine();
        sendData=sentence.getBytes();
        DatagramPacket sendPacket =  new DatagramPacket(sendData,sendData.length,IPAddress,5454);
        clientsocket.send(sendPacket);;
        DatagramPacket receivedPacket =  new DatagramPacket(receivedData,receivedData.length);
        clientsocket.receive(receivedPacket);
        String modified = new String(receivedPacket.getData());
        System.out.println("FROM SERVER: " + modified);
        clientsocket.close(); 

    }
}
