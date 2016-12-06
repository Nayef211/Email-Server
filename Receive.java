public class Receive {
  public static void main (String [] args) {
    do {
    System.out.print("waiting...");
    String message = NetIO.receiveRequest();
    System.out.println (message);
    }
    while (true);
    }
  }