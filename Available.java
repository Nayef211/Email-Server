 /*****************************************************
  * Name: Nayef Ahmed
  * Date: November 30/2015
  * Course: ICS4U0
  * Assignment: Available
  * Creates a linked list for deleted entries within the messages.kas file
  * ***************************************************/

public class Available {
  
  private int recordNumber = -1;
  private Available next = null;
  
  public Available () {
    recordNumber = -1;
    next = null;
  }
  
  public Available (int r) {
    recordNumber = r;
    next = null;   
  }
  
  public int getRecordNumber() {
    return recordNumber;
  }
  
  public void setRecordNumber(int r) {
    recordNumber = r;
  }
  
  public Available getNext() {
    return next;
  }
  
  public void setNext (Available p){
  next = p;
  }
  
  public String toString () {
   return "" + recordNumber;
  }
}