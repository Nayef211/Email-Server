public class AvailableList{
  
  private Available head = null;
  private Available tail = null;
  
  public AvailableList (){
    head = null;
    tail = null;
  }
  
  public Available getHead(){
    return head;
  }
  
  public Available getTail () {
    return tail;
  }
  
  public void setHead (Available p){
    head = p;
  }
  
  public void setTail (Available p){
    tail = p;
  }
  
  public int nextAvailableRecord(){
    int record = head.getRecordNumber();
    head = head.getNext();
    return record;
  }
  
  public void addRecord(int recordNumber) {
    if (head == null) { //if available list is empty
      head = new Available (recordNumber);
      tail = head;
    }
    else { //if list is not empty
      Available p = new Available (recordNumber);
      tail.setNext (p);
      tail = p;
    }
  }
  
  public void buildFromMessagesFile(){
    Record r = new Record();
    for (int i = 0; i<Globals.totalRecordsInMessageFile; i++){
      
      r.readFromMessagesFile (i);
      
      if (r.getData().charAt(0) == Globals.DELIMETER){
        addRecord (i);
        System.out.println (r.toString());
      }
    }
  }
  
  public static void printAvailablelist(){
    Available p = Globals.availableList.getHead();

      for (; p!= null; p = p.getNext()){
        System.out.println (p.toString());
      }
  }
}