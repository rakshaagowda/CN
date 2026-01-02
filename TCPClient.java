package CN_LAB;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception{
  Socket sock = new Socket("127.0.0.1",3300);
  System.out.println("Enter the filename : ");
  BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
  String fname = keyRead.readLine();
  OutputStream ostream = sock.getOutputStream();
  PrintWriter pwrite = new PrintWriter(ostream,true);
  pwrite.println(fname);
  InputStream istream = sock.getInputStream();
  BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));
  String str;

  while((str=socketRead.readLine())!=null){
   System.out.println(str);
  }

  pwrite.close();
  socketRead.close();
  keyRead.close();
 }
}
