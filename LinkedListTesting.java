public class LinkedListTesting {
  public static void main(String[] args) {
    /* 
     //Practise
     Available p = new Available(17); //
     //making the head
     Available head = p; //beginning of list id 17
     p = new Available(20); //p is now pointing to 20, not 17
     
     head.setNext(p); //head is pointed to 20 which is where p is pointed
     p = newAvailable(4); //p now pointing to 4
     
     head.getNext().setNext(p);//by doing get next: get the Available that is next to head, which is the second Available within the list
     //points from second to third by doing setNext
     Available tail = p;
     
     
     for (p = head; p!= nulls; p = p.getNext()){
     System.out.println(p);
     }
     */
    
    //Excercise 1 
    /* Create list
     * Print list
     * Delete note from front
     * Delete element not in front
     */
    
    Available p = new Available (3);
    Available head = p;
    p = new Available (4);
    head.setNext (p);
    
    p = new Available (2);
    head.getNext().setNext (p);
    
    p = new Available (9);
    head.getNext().getNext().setNext (p);
    
    p = new Available (1);
    head.getNext().getNext().getNext().setNext (p);
    
    p = new Available (7);
    head.getNext().getNext().getNext().getNext().setNext (p);
    
    p = new Available (6);
    head.getNext().getNext().getNext().getNext().getNext().setNext (p);
  
    Available tail = p;
  }
  
  public static int nextAvailableRecord(Available head){
    int recordNumber = -1;
    recordNumber = head.getNext().getRecordNumber();
    return recordNumber;
  }
  
}