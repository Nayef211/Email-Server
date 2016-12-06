//
public class NewHub
{
  public static void main (String[] args)
  {
    boolean shutdown = false;
    Tree receiverIndex = new Tree();
    Tree senderIndex = new Tree();
    int error = FileIO.openMessagesFile("messages.kas"); 
    int recordNumber = 0;
    String identification = "";
    TNode p = new TNode();
    TNode q = new TNode();
    Message message = new Message();
    
    if (error == Globals.PROCESS_OK) {
      error = senderIndex.breadthFirstRetrieve(Globals.SENDER_TREE_FILE);
      if (error == Globals.PROCESS_OK) {
        error = receiverIndex.breadthFirstRetrieve(Globals.RECEIVER_TREE_FILE);
        if (error == Globals.PROCESS_OK) {
          error = FileIO.retrieveAvailableList(Globals.AVAILABLE_LIST_FILE);
          if (error == Globals.PROCESS_OK) {
            
            do {
              String request = NetIO.receiveRequest();
              switch (request.charAt(0)) {
                
                //receive one messages from client
                case Globals.SEND_MESSAGE: // = 'S'
                  request = Utils.setReceivingTime(request);
                  message = new Message (request);
                  message.setMessage(request);
                  
                  //writes message received to file and gets record number
                  recordNumber = message.writeToMessagesFile();
                  
                  //prints message received
                  message.printFromMessagesFile(recordNumber);
                  
                  //updating sender index
                  identification =  message.getSenderNodeId();
                  p = new TNode(identification, recordNumber, null, null, null);
                  senderIndex.insertNode(p);
                  senderIndex.breadthFirstSave(Globals.SENDER_TREE_FILE);
                  
                  //updating receiver index
                  identification = message.getReceiverNodeId();
                  p = new TNode(identification, recordNumber, null, null, null);
                  receiverIndex.insertNode(p);
                  receiverIndex.breadthFirstSave(Globals.RECEIVER_TREE_FILE);
                  
                  break;
                  
                  // client is requesting for all the messages that they have received
                case Globals.IN_BOX:
                  identification = request.substring(Globals.SENDER_POS, Globals.RECEIVER_POS);
                  
                  p = receiverIndex.findNode (identification, 0);
                  q = receiverIndex.findNode (identification, 1);
                  
                  receiverIndex.prepareTransmissionString(p, q);
                  
                  Globals.transmissionString += Utils.intToBytesStr(Globals.END_OF_MESSAGES_TRANSMISION);
                  
                  //Printing TNodes and transmission string
                  System.out.println(Globals.transmissionString);
                  
                  //Send transmission string to client
                  NetIO.sendRequest(Globals.transmissionString, Globals.clientIPAddress);
                  
                  Globals.transmissionString = "";
                  
                  break;
                  
                  //If client  is requesting for all the messages that they have sent
                case Globals.OUT_BOX: // = 'O'
                  identification = request.substring(Globals.SENDER_POS, Globals.RECEIVER_POS);
                  
                  p = senderIndex.findNode (identification, 0);
                  q = senderIndex.findNode (identification, 1);
                  
                  senderIndex.prepareTransmissionString(p, q);
                  Globals.transmissionString += Utils.intToBytesStr(Globals.END_OF_MESSAGES_TRANSMISION);
                  
                  //Printing TNodes and transmission string
                  System.out.println(Globals.transmissionString.substring(0,15));
                  
                  //Send transmission string to client
                  NetIO.sendRequest(Globals.transmissionString, Globals.clientIPAddress);
                  
                  Globals.transmissionString = "";
                  
                  break;
                  
                default:
                  System.out.println ("Unknown request");
              }
            } while (!shutdown);
            
            FileIO.closeMessagesFile();
            
          }
          else {
            System.out.println("Error in retrieving available list");
            FileIO.closeMessagesFile();
            
          }
        }
        else{
          System.out.println("Error in retrieving receiver index");
          FileIO.closeMessagesFile();
          
        }
      }
      else{
        System.out.println("Error in retrieving sender index");
        FileIO.closeMessagesFile();
      }
    }
    else
      System.out.println("Error in opening messages file");
  }
}