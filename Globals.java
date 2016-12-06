/*****************************************************
  * Name: Nayef Ahmed
  * Date: November 11/2015
  * Course: ICS4U0
  * Assignment: Globals
  * ****************************************************/
import java.io.*;

public class Globals {
  //debug constants
  public static final boolean DEBUG_ON = false; 
  
  //error contsants
  public static final int PROCESS_OK = 0; //Returns value when the program runs successfully
  public static final int PROCESS_ERR = -1; //Returns value when there is an error
  
  public static final int END_OF_MESSAGE = -1; 
  public static final char DELIMETER = '@'; //Used to delete records
  
  public static final int APPEND = 1; //Modes for writing into the file
  public static final int MODIFY = 2;
  
  // position constants for message
  public static final int COMMAND_POS = 0;
  public static final int COMMAND_LEN = 1;
  public static final int SENDER_POS  = COMMAND_POS + COMMAND_LEN;
  public static final int SENDER_LEN  = 9;
  public static final int RECEIVER_POS = SENDER_POS + SENDER_LEN;
  public static final int RECEIVER_LEN  = 9;
  public static final int DATE_TIME_POS = RECEIVER_POS + RECEIVER_LEN;
  public static final int DATE_TIME_LEN = 8;  // long current milliseconds coded as eight bytes
  public static final int MARKER_POS = DATE_TIME_POS + DATE_TIME_LEN;
  public static final int MARKER_LEN = 1;
  public static final char END_OF_SUBJECT_MARKER = '~';
  public static final int END_OF_SUBJECT_MARKER_LEN = 1;
  
  public static final int SENDER_ID = 0;
  public static final int RECEIVER_ID = 1;
  
  // constants for records; note that the first record of a message will contain the
  // identification and marker; therefore, there will be more room for text in the
  // subsequent records
  
  public static final int TEXT_LEN = END_OF_SUBJECT_MARKER_LEN + 30; //length 31
  //length 59
  public static final int RECORD_DATA_LEN =   COMMAND_LEN   + //1
    SENDER_LEN    + //9
    RECEIVER_LEN  + //9
    DATE_TIME_LEN + //8
    MARKER_LEN    + //1
    TEXT_LEN;
  public static final int RECORD_LEN = RECORD_DATA_LEN + 4;  //length 63
  
  // message and record delimiters; characters used so that special ascii like 1, 2, 3, can be used    
  public static final char FIRST_RECORD_OF_MESSAGE = '+';       // we mark the start of a message with this marker in case we have to rebuild the indices
  public static final char DELETED = '*';                // this character will only be placed at front of every record in case
  // we need to rebuild the deleted linked list 
  
  // constants for linked list of available records
  public static int AVAILABLE_LIST_IS_EMPTY = -1; // no records deleted.
  
  // available list file
  public static final String AVAILABLE_LIST_FILE = "_available.kas";
  public static final int AVAILABLE_NODE_RECORD_NUMBER_LEN = 4;
  
  // binary tree file
  public static final String SENDER_TREE_FILE = "_stree.kas";  // tree by sender
  public static final String RECEIVER_TREE_FILE = "_rtree.kas";  // tree by recipient
  
  public static final int KEY_LEN = SENDER_LEN + RECEIVER_LEN + DATE_TIME_LEN;
  
  
  //global variables
  public static RandomAccessFile msg = null; //main messages fle
  public static int totalRecordsInMessageFile = 0; //updates every time a record is added
  public static AvailableList availableList = new AvailableList();
  
  //initialization constants
  public static final int NULL = 0;
  public static final String STR_NULL = "";
  public static final char BLANK = ' '; //Used for padding
  public static final char CR = '\n';
  
  public static final int IDENTIFICATION_LEN = SENDER_LEN + RECEIVER_LEN + DATE_TIME_LEN;
  
  public static final int NODE_LEN = IDENTIFICATION_LEN + 4; // 4 is the number of bytes in the recordnumber
  
  public static final char SEND_MESSAGE = 'S';
  
  public static final char OUT_BOX = 'O';
  public static final int END_OF_MESSAGES_TRANSMISION = -2;
  
  public static final char IN_BOX = 'I';
  
  public static String clientIPAddress = ""; //10.104.82.69
  public static String transmissionString = "";
  
  
}



