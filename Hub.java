/*****************************************************
  * Name: Nayef Ahmed
  * Date: November 11/2015
  * Course: ICS4U0
  * Assignment: Globals
  * ****************************************************/
import java.util.*;

public class Hub {
  public static void main (String[] args) {
    
    //System.out.println(Utils.longToBytesStr(4702942340726470000L)); 
    //System.out.println(Utils.bytesStrToLong("AD5$B%5p")); 
    //System.out.println(Utils.bytesStrToLong(Utils.longToBytesStr(4702942340726470000L)));
    
    Scanner in = new Scanner (System.in);
    
    Record r = new Record();
    int recordNumber = 0;
    Message m = new Message ();
    
    Tree senderIndex = new Tree ();
    Tree receiverIndex = new Tree ();
    
    FileIO.retrieveAvailableList("deletedrecords.kas");
    
    if (FileIO.openMessagesFile("messages.kas") == Globals.PROCESS_OK){
      int option;
       
      do {
        System.out.println("1. Add a record");
        System.out.println("2. Read and print a record");
        System.out.println("3. Print all records");
        System.out.println("4. Delete a record");
        System.out.println("5. Print all deleted records");
        System.out.println("6. Add message");
        System.out.println("7. Rebuild all deleted records from file");
        System.out.println("8. Generate a number of new messages");
        System.out.println("9. Rebuild all receiver and sender indices");
        System.out.println("10. Print receiver and sender indices");
        System.out.println("99. Quit program");
        
        option = in.nextInt();
        
        switch(option) {
          
          // write a record with text supplied by the user
          case 1 :
            
            System.out.println ("Please enter the text that will be placed in the record: ");
            
            in.nextLine();
            String txt = in.nextLine();
            
            Record r1 = new Record (txt, -1); //this will set the record to the given text and the marker as -1
            r1.writeToMessagesFile(Globals.totalRecordsInMessageFile, Globals.APPEND); //add the record to the messages file
            
            break;
            
            // read and print record from a given record number
            // record number must be in the range
            // [0, Globals.totalRecordsInMessageFile - 1]
          case 2 :
            
            System.out.println ("Please enter a record number: ");
            int rAddNumber = in.nextInt();
            
            if (rAddNumber<Globals.totalRecordsInMessageFile){
              
              r.readFromMessagesFile(rAddNumber);
              // the data is now in the record r
              // this uses our newly written toString() method
              
              System.out.println(r);
            }
            else {
              System.out.println("Error; The record does not exist.");
            }
            break;
            
            // read and print all records of the file
          case 3 :  
            
            for (recordNumber = 0; recordNumber < Globals.totalRecordsInMessageFile; recordNumber++) {
            
            r.readFromMessagesFile(recordNumber);
            System.out.println(r.toString());
          }
            
            break;
  
          case 4 :
            
            System.out.println ("Please enter a record number: ");
            int rDelNumber = in.nextInt();
            
            if (rDelNumber<Globals.totalRecordsInMessageFile){
              
              m.deleteFromMessagesFile(rDelNumber);
              // the first charcter in the record is replaced with a delimeter
              
            }
            else {
              System.out.println("Error; The record does not exist.");
            }
            
            break;
          case 5 :           
            AvailableList.printAvailablelist();
            
            break;
            //Add a message
          case 6 :
            String command = "C";
            String sender = "987654321"; //9 char
            String receiver = "ABCDEFGHI"; //9 char
            String timeReceived = "88889999"; //8 char
            String subject = "Suject test 4 to overflow a record"; //any size
            String text = "This is test four to take many records"; //any size  
            
            String entireMessage = 
              command +
              sender +
              receiver +
              timeReceived +
              Globals.FIRST_RECORD_OF_MESSAGE +
              subject +
              Globals.END_OF_SUBJECT_MARKER +
              text;
            
            Message message = new Message(entireMessage);
            recordNumber = message.writeToMessagesFile();
            
            break;
            
          case 7 :
            Globals.availableList.buildFromMessagesFile();
            break;
            
          case 8:
            
            for (int messageNumber = 0; messageNumber < 10; messageNumber++){
            String sender1 = "" + messageNumber;
            sender1 = sender1.substring(sender1.length() - 1);
            sender1 = Utils.leftPad (sender1, 9, '0');
            String receiver1 = "" + (messageNumber + 1);
            receiver1 = receiver1.substring(receiver1.length() - 1);
            receiver1 = Utils.leftPad (receiver1, 9, '0');
            String timeStamp1 = Utils.leftPad("" + messageNumber, 8, '0');
            
            subject = "Subject number " + messageNumber;
            text = "Hello how are you today. This is testing messageNumber " + messageNumber;
            
            m.setMessage ('C' + 
                          sender1 + 
                          receiver1 + 
                          timeStamp1 + 
                          Globals.FIRST_RECORD_OF_MESSAGE + 
                          subject + 
                          Globals.END_OF_SUBJECT_MARKER + 
                          text);
            
            m.writeToMessagesFile();
          }
            break;
            
          case 9:    
            
            senderIndex.buildFromMessagesFile(Globals.SENDER_ID);
            receiverIndex.buildFromMessagesFile(Globals.RECEIVER_ID);
            break;
            
          case 10:
            
            System.out.println("Sender Indices:");
            senderIndex.printTree();
            System.out.println("Receiver Indices:");
            receiverIndex.printTree();
            break;
        }
      }
      while (option != 99);
      
      FileIO.saveAvailableList("deletedrecords.kas");
      FileIO.closeMessagesFile();
    }
    else{
      System.out.println("Error opening file; From main() method");
    }
    
    in.close();
  }
}