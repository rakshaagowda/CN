package CN_LAB;
import java.net.*;
//import java.io.*;
public class UDPServer {
    // UDP server implpementation goes here
    public static void main(String[] args) throws Exception {
        System.out.println("UDP Server is running...");
        // Additional server code would be implemented here
        DatagramSocket serversocket = new DatagramSocket(5454);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true){
            DatagramPacket receivePacket =  new DatagramPacket(receiveData, receiveData.length);
            serversocket.receive(receivePacket);
            String sentence =  new String(receivePacket.getData());
            System.out.println("RECEIVED: " + sentence);
            InetAddress IPAddress  = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String caps = sentence.toUpperCase();
            sendData = caps.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
            serversocket.send(sendPacket);
        } 

    
    }
}