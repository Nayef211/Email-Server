/*****************************************************
  * Name: Nayef Ahmed
  * Date: November 21/2015
  * Course: ICS4U0
  * Assignment: Record
  * Methods for the record class used to read and modify records within the messages.kas file
  * ***************************************************/

import java.io.*;
public class Record {
  private byte [] data = new byte [Globals.RECORD_DATA_LEN];
  private int next = Globals.END_OF_MESSAGE;
  
  public Record() {
    for (int i = 0; i < Globals.RECORD_DATA_LEN; i++) {
      data[i] = Globals.BLANK;
    }
    next = Globals.END_OF_MESSAGE;
  }
  
  //Recieves a message and a next record
  public Record (String s, int nextRecord) {
    setValues(s, nextRecord);
  }
  
  public String getData() {
    String s = "";
    for (int i = 0; i < Globals.RECORD_DATA_LEN; i++) {
      s += (char) data[i];
    }
    return s;
  }
  
  public int getNext() {
    return next;
  }
  
  //Takes the string and puts it in organized records 
  public void setValues (String txt, int nextRecord) {
    int i = 0;
    for (i = 0; i<txt.length(); i++) {
      data[i] = (byte) txt.charAt(i);
    }
    //padding the rest of the record
    for (; i < Globals.RECORD_DATA_LEN; i++) {//the i points to the last location
      data[i] = (byte) Globals.BLANK;
    }
    next = nextRecord;
  }
  
  public int writeToMessagesFile (int recordNumber, int mode) { //mode tells us if we can overwrite a line or we are appending
    try {
      Globals.msg.seek(recordNumber * Globals.RECORD_LEN);
      Globals.msg.write(data);
      Globals.msg.writeInt(next); //puts 4 bytes for the integer placed in the record
      
      if (mode == Globals.APPEND) {
        Globals.totalRecordsInMessageFile++; 
      }
      return Globals.PROCESS_OK;
    }
    catch (IOException e) {
      return Globals.PROCESS_ERR;
    }
  }
  
  public int readFromMessagesFile(int recordNumber){
    try {
      Globals.msg.seek(recordNumber * Globals.RECORD_LEN);
      Globals.msg.read(data);
      next = Globals.msg.readInt();
      
      return Globals.PROCESS_OK;
    }
    catch (IOException e) {
      return Globals.PROCESS_ERR;
    }
  }
  
  //Deletion of records
  public void deleteFromMessagesFile(int recordNumber){
      char delimiter = '@';      
       
      if (readFromMessagesFile(recordNumber) == Globals.PROCESS_OK){
        data [0] = (byte)delimiter;
        if (writeToMessagesFile (recordNumber, 0) == Globals.PROCESS_OK){
          Globals.availableList.addRecord(recordNumber);
        }
        else {
          System.out.println ("An error has occurred in the writing operation");
        }
      }
      else {
        System.out.println ("An error has occurred in the reading operation ");
      }
  }
  
  public String toString() {
    return getData() + next;
  }
}

