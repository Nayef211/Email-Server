public class TNode {
  
  private String id = "";
  private int recordNumber = -1;
  private TNode left = null;
  private TNode right = null;
  private TNode parent = null;
  
  public TNode (){
    id = "";
    recordNumber = -1;
    left = null;
    right = null;
    parent = null;
  }
  
  public TNode (String i, int rn, TNode l, TNode r, TNode p){ //used to assign values to the private variables
    id = i;
    recordNumber = rn;
    left = l;
    right = r;
    parent = p;
  }
  
  //Access methods
  //getMethods
  public String getId(){
    return id;
  }
  
  public int getRecordNumber(){
    return recordNumber;
  }
  
  public TNode getLeft(){
    return left;
  }
  
  public TNode getRight(){
    return right;
  }
  
  public TNode getParent(){
    return parent;
  }
  
  //setMethods
  public void setId(String i){
    id = i;
  }
  
  public void setRecordNumber(int rn){
    recordNumber = rn;
  }
  
  public void setLeft(TNode l){
    left = l;
  }
  
  public void setRight(TNode r){
    right = r;
  }
  
  public void setParent(TNode p){
    parent = p;
  }
  
  public String toString() {
    if (this == null){ //"this" is the object that is making the call to the method
      return "null";
    }
    else
    {
      return "Id = " + id + ", " + "Record Number = " + recordNumber;  
    }
  }
}