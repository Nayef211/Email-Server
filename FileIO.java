/*****************************************************
  * Name: Nayef Ahmed
  * Date: November 11/2015
  * Course: ICS4U0
  * Assignment: Globals
  * **************************************************/
import java.io.*;

public class FileIO {
  public static int openMessagesFile (String fileName){ 
    try {
      Globals.msg = new RandomAccessFile (fileName, "rw");
      
      //updates the total number of records within the file
      Globals.totalRecordsInMessageFile = (int) Globals.msg.length() / Globals.RECORD_DATA_LEN;
      return Globals.PROCESS_OK;
    }
    catch (IOException e){
      return Globals.PROCESS_ERR;
    }
  }
  
  
  public static int closeMessagesFile() {
    try {
      Globals.msg.close();
      return Globals.PROCESS_OK;
    }
    catch (IOException e) {
      return Globals.PROCESS_ERR;
    }
  }
  
  public static int saveAvailableList(String fileName){
    try {
      RandomAccessFile savedList = new RandomAccessFile (fileName, "rw");
      
      for (Available p = Globals.availableList.getHead(); p!= null; p = p.getNext()){
        savedList.writeInt(p.getRecordNumber());
      }
      
      savedList.close();
      return Globals.PROCESS_OK;
    }
    catch (IOException e){
      return Globals.PROCESS_ERR;
    }
  }
  
  public static int retrieveAvailableList(String fileName){
    try {
      RandomAccessFile f = new RandomAccessFile (fileName, "rw");
      
      long fSize = f.length();
      
      for (int r = 0; r < fSize/4; r++ ) {
        Globals.availableList.addRecord(f.readInt());
      }
      
      f.close();
      return Globals.PROCESS_OK;
    }
    catch (IOException e){
      return Globals.PROCESS_ERR;
    }
  } 
} 



