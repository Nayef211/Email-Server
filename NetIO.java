import java.net.*;
import java.io.*;

public class NetIO {
  
  public static String myIPAddress (){
    String ipAddress = "";
    try {
      InetAddress myComputer = InetAddress.getLocalHost();
      ipAddress = myComputer.getHostAddress();
    }
    catch (Exception e) {
      System.out.println ("Error in getting ip address");
    }
    return ipAddress;
  }
  
  public static String myUserName (){
    String userName = "";
    try {
      InetAddress myComputer = InetAddress.getLocalHost();
      userName = System.getProperty("user.name");
    }
    catch (Exception e) {
      System.out.println ("Error in getting user name");
    }
    return userName;
  }
  
  public static int sendRequest (String message, String destinationIPAddress){
    String request = "";
    int errorCode = -1;
    try {
      Socket me = new Socket();
      me.connect(new InetSocketAddress (destinationIPAddress, 5000), 10000); //5000 is the port # (numbers from 1024 are reserved), 10000 is the timeout period in ms
      me.setSoTimeout (10000); // confirmation from the other end timeout
      
      DataOutputStream output = new DataOutputStream (me.getOutputStream());
      output.writeUTF (message);
      
      DataInputStream input = new DataInputStream(me.getInputStream());
      String confirmation = input.readUTF(); //waiting for confirmation from machine; if no confirmation is received, it will have a value of -1
      
      if (isANumber (confirmation))
        errorCode = Integer.parseInt(confirmation); //checking if the confirmation is valid
      
      me.close();
    }
    catch (IOException e){
      System.out.println("Error in sending message");
    }
    return errorCode; 
  }
  
  public static String receiveRequest (){
    String request = "";
    int errorCode = -1;
    
    try {
      ServerSocket server = new ServerSocket (5000, 100);//If more than one machine is sending to this machine it will go in a queue with a time of 100ms
      
      Socket me = server.accept();
      me.setSoTimeout (10000);
      
      //get input stream and receive request
      DataInputStream input = new DataInputStream(me.getInputStream());
      request = input.readUTF(); //universal text file
      
      // get client's ip-address
      Globals.clientIPAddress = me.getInetAddress().getHostAddress();
      
      //get output stream and send confirmation
      DataOutputStream output = new DataOutputStream(me.getOutputStream());
      output.writeUTF("0");
      
      me.close();
      server.close();
      errorCode = 0;
    }
    catch (IOException e){
      System.out.println("Error receiving message");
    }
         
    return request;
  }
  
  private static boolean isANumber (String s){
    boolean result = true;
    for (int i = 0; i<s.length() && result == true ;i++){
      result = Character.isDigit (s.charAt(i));   
    }
    return result;
  }
  
  public static void addToTransmissionString(int recordNumber) {
  Message message = new Message();
  message.readFromMessagesFile(recordNumber);
  Globals.transmissionString = Globals.transmissionString + message.getAsString() + Utils.intToBytesStr(-1);
 }

  
//192.168.1.102 
  
  public static void main (String args []){
    System.out.println (myIPAddress());
    System.out.println (myUserName());
  }

}