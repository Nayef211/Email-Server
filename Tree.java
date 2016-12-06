import java.io.*;

public class Tree {
  
  
  private TNode root = null;
  
  public Tree () {
    root = null;
  }
  
  public Tree (TNode r) {
    root = r;
  }
  
  //access methods  
  public TNode getRoot() {
    return root;
  }
  
  public void setRoot (TNode r) {
    root = r;
  }
  
  public void insertNode(TNode p) {
    insertNodeRec(p);
    balance(p);
  }
  
  private void insertNodeRec(TNode p) {
    if (root == null) {
      root = p;
    } else if(p.getId().compareTo(root.getId()) < 0) {
      if (root.getLeft() == null) {
        root.setLeft(p);
        p.setParent(root);
      } else {
        Tree tree = new Tree(root.getLeft());
        tree.insertNodeRec(p);
      }
    } else if(p.getId().compareTo(root.getId()) > 0) {
      if (root.getRight() == null) {
        root.setRight(p);
        p.setParent(root);
      } else {
        Tree tree = new Tree(root.getRight());
        tree.insertNodeRec(p);
      }
    } else {
      System.out.println("Error: Duplicated Id");
    }
    
  }
  
  
  public TNode findNode(String identification) {
    
    if (root == null) {
      return null;
    }
    else if (identification.compareTo(root.getId()) == 0){
      return root;
    }
    else if (identification.compareTo (root.getId())<0){
      Tree tree = new Tree (root.getLeft());
      return tree.findNode (identification);
    }
    else if (identification.compareTo (root.getId())>0){
      Tree tree = new Tree (root.getRight());
      return tree.findNode (identification);
    }
    else
    {
      return null;
    }
  }
  
  
  
  private static void setParentsChildLink(TNode p, TNode q){
    //check if p is a left or right child
    if (p.getParent().getLeft() == p) {
      p.getParent().setLeft(q);
    }
    else {
      p.getParent().setRight(q);
    }
  }
  
  public void printTree () {
    if (root == null){
    }
    else {
      Tree tree = new Tree (root.getLeft());
      
      tree.printTree();
      System.out.println (root);
      
      tree = new Tree (root.getRight());
      tree.printTree();
    }
  }
  
  public void findRoot (TNode p){
    while (p!= root){
      p = p.getParent();
    }
    System.out.println (p);
    
  }
  
  //putting the values of the tree into an array
  public void treeToArray () {
    if (root == null){
    }
    else {
      Tree tree = new Tree (root.getLeft());
      
      tree.printTree();
      System.out.println (root);
      
      tree = new Tree (root.getRight());
      tree.printTree();
    }
  }
  
  //Number of nodes in a tree
  public int nodeCount() {
    if (this.getRoot() == null) {
      return 0;
    }
    else {
      Tree lTree = new Tree(this.getRoot().getLeft());
      Tree rTree = new Tree(this.getRoot().getRight());
      
      return 1 + lTree.nodeCount() + rTree.nodeCount();
    }
  }
  
  //height of a tree
  public int height(){
    if (root == null){
      return 0;
    }
    else {
      int heightLeft = 0;
      int heightRight = 0;     
      
      Tree tree = new Tree (root.getLeft());
      heightLeft = tree.height ();
      
      tree = new Tree (root.getRight());
      heightRight = tree.height ();
      
      if (heightLeft>heightRight){
        return heightLeft+1;
      }
      else {
        return heightRight+1;
      }
    }
  }
  
  //deleting nodes
  public void deleteNode(TNode p) {
    TNode q = null;
    TNode r = null;
    // case 1
    if (p.getLeft() == null && p.getRight() == null) {
      r = p.getParent();
      if (p == root) {
        root = null;
      } else {
        setParentsChildLink(p, null);
      }
      // case 2, 3, 5, 6
    } else if((p.getLeft() != null && p.getRight() == null) || (p.getLeft() == null && p.getRight() != null)) {
      if (p.getLeft() != null) q = p.getLeft();
      else q = p.getRight();
      if (p == root) {
        root = q;
      } else {
        setParentsChildLink(p, q);
      }
      q.setParent(p.getParent());
      r =  q.getParent();
      // case 4, 7
    } else if(p.getLeft() != null && p.getRight() != null) {
      q = p.getLeft();
      // case 4, 7a
      if (q.getRight() == null) {
        if (p == root) {
          root = q;
        } else {
          setParentsChildLink(p, q);
        }
        q.setParent(p.getParent());
        q.setRight(p.getRight());
        q.getRight().setParent(q);
        r = q;
        // case 7b, c
      } else {
        while(q.getRight() != null) {
          q = q.getRight();
        }
        r =  q.getParent();
        setParentsChildLink(q, q.getLeft());
        if (q.getLeft() != null) q.getLeft().setParent(q.getParent());
        if (p == root) {
          root = q;
        } else {
          setParentsChildLink(p, q);
        }
        q.setParent(p.getParent());
        q.setLeft(p.getLeft());
        q.setRight(p.getRight());
        q.getLeft().setParent(q);
        q.getRight().setParent(q);
        
      }
    }
    balance(r);
    p.setLeft(null);
    p.setRight(null);
    p.setParent(null);
    p = null;
  }
  
  
  //***********AVL Tree Operations**************
  
  private TNode rightRotate() {
    //this.root is the same thing as this.getRoot() 
    TNode p = this.root.getLeft();
    p.setParent(this.root.getParent());
    this.root.setLeft(p.getRight());
    if (this.getRoot().getLeft() != null) {
      this.getRoot().getLeft().setParent(this.getRoot());
    }
    p.setRight(this.getRoot());
    p.getRight().setParent(p);
    
    return p;
    
  }
  
  
  //left rotation
  private TNode leftRotate() {
    TNode p = this.getRoot().getRight();
    p.setParent(this.getRoot().getParent());
    this.getRoot().setRight(p.getLeft());
    if (this.getRoot().getRight() != null) {
      this.getRoot().getRight().setParent(this.getRoot());
    }
    p.setLeft(this.getRoot());
    p.getLeft().setParent(p);
    
    return p;
  }
  
  //balance factor
  private int balanceFactor() {
    Tree lTree = new Tree(this.root.getLeft());
    Tree rTree = new Tree(this.root.getRight());
    return lTree.height() - rTree.height();
  }
  
  //balance tree
  private void balance (TNode p) {
    TNode ancestor = p;
    while (ancestor != null) {
      Tree ancestorTree = new Tree(ancestor);
      if (ancestorTree.balanceFactor() == -2) {
        Tree rTree = new Tree(ancestor.getRight());
        //CASE ONE
        if (rTree.balanceFactor() == -1 || rTree.balanceFactor() == 0) {
          if (ancestor == root) {
            root = ancestorTree.leftRotate();
          } else {
            if (ancestor.getParent().getLeft() == ancestor) {
              ancestor.getParent().setLeft(ancestorTree.leftRotate());
            } else {
              ancestor.getParent().setRight(ancestorTree.leftRotate());
            }
          }
          
          //CASE TWO  
        } else if (rTree.balanceFactor() == 1 || rTree.balanceFactor() == 0) {
          ancestor.setRight(rTree.rightRotate());
          if (ancestor == root) {
            root = ancestorTree.leftRotate();
          } else {
            if (ancestor.getParent().getLeft() == ancestor) {
              ancestor.getParent().setLeft(ancestorTree.leftRotate());
            } else {
              ancestor.getParent().setRight(ancestorTree.leftRotate());
            }
          }   
        }
        
      } else if (ancestorTree.balanceFactor() == 2) {
        Tree lTree = new Tree (ancestor.getLeft());
        //CASE THREE
        if (lTree.balanceFactor() == 1 || lTree.balanceFactor() == 0) {
          if (ancestor == root) {
            root = ancestorTree.rightRotate();
          } else { 
            if (ancestor.getParent().getLeft() == ancestor) {
              ancestor.getParent().setLeft(ancestorTree.rightRotate());
            } else {
              ancestor.getParent().setRight(ancestorTree.rightRotate());
            }
          }
          //CASE FOUR
        } else if (lTree.balanceFactor() == -1 || lTree.balanceFactor() == 0) {
          ancestor.setLeft(lTree.leftRotate());
          if (ancestor == root) {
            root = ancestorTree.rightRotate();
          } else {
            if (ancestor.getParent().getLeft() == ancestor) {
              ancestor.getParent().setLeft(ancestorTree.rightRotate());
            } else {
              ancestor.getParent().setRight(ancestorTree.rightRotate());
            }
          } 
        }     
      } // end of first initial if statement
      ancestor = ancestor.getParent();
    } // end of while loop
    
  } // end of method
  
  //prints the entire tree starting at the root and then one level at a time, from left to right.
  public void breadthFirstPrint() {
    int treeHeight = height();
    for (int level = 0; level <= treeHeight; level++) {
      printNodesOfOneLevel(root, level, 0);
    }
  }
  
  public void breadthFirstSave(String fileName){
    try
    {
      RandomAccessFile messageTree = new RandomAccessFile (fileName, "rw");
      
      for(int i = 0; i < height(); i ++)
        writeLevel(i,messageTree);
      
      messageTree.close();
    }
    catch (IOException e)
    {      
      System.out.println (e);
    }
  }
  
  public int breadthFirstRetrieve(String fileName) {
    Tree tree = new Tree();
    String ID = "";
    int recordNumber = 0;
    TNode p = null;
    byte[] b = new byte[Globals.RECEIVER_LEN];
    try {
      RandomAccessFile messageTree = new RandomAccessFile (fileName, "rw");
      long fileSize = messageTree.length();
      for (int i = 0; i < fileSize/2 ; i+= Globals.NODE_LEN) {
        messageTree.read(b);
        ID = new String(b);
        recordNumber = messageTree.readInt();
        p = new TNode (ID, recordNumber, null, null, null);
        tree.insertNode(p);
      }
      messageTree.close();
      return Globals.PROCESS_OK;
    }
    catch (IOException e) {  
      System.out.println ("Error in breadthFirstRetrieve method of Tree class");
      return Globals.PROCESS_ERR;
    }
  }
  
  
  public void writeLevel(int level, RandomAccessFile f){
    if(level == 0){ 
      try
      {
        if(root != null){
          f.write(root.getId().getBytes());
          f.writeInt(root.getRecordNumber());
        }
      }
      catch (IOException e)
      {      
        System.out.println (e);
      }  
    }else{
      Tree t = new Tree(root.getLeft());
      t.writeLevel(level-1,f);
      t = new Tree(root.getRight());
      t.writeLevel(level-1,f);
    }
    
  }
  
  private void printNodesOfOneLevel(TNode p, int level, int currentLevel) {
    if (p != null) {
      if (currentLevel == level) {
        System.out.print(p.getId() + " in level " + level);
        if (p.getParent() == null) {
          System.out.println(" Root");
        }
        else if (p.getParent().getLeft() == p) {
          System.out.println(" Left child of " + p.getParent().getId());
        }
        else {
          System.out.println(" Right child of " + p.getParent().getId());
        }
      }
      else {
        printNodesOfOneLevel(p.getLeft(), level, currentLevel + 1);
        printNodesOfOneLevel(p.getRight(), level, currentLevel + 1);
      }
    }
  }
  
  //printing a tree from the start node to the end node without going through the entire tree
  public void printTree(TNode start, TNode end) {
    
    if (start!= null && end!=null){ //If start and finish aren't null
      if (start.getId().compareTo(end.getId())<=0) { //If start's id is smaller than or equal to end's
        if ((start.getId().compareTo(root.getId()) <=0) && (root.getId().compareTo(end.getId()) <=0)) { //If start and end are on opposite sides of the root or the root
          TNode p = start;
          while (p != root) { //Used to print everything in between start and the root
            
            if (p.getId().compareTo(start.getId()) >= 0) { //Prints p if it is of a larger value than start
              System.out.println(p);
              Tree rTree = new Tree(p.getRight()); 
              rTree.printTree(); //Print the right subtree of p
            }
            
            if (p != root || p.getId().compareTo(start.getId()) < 0) { //If p isn't the root, after printing it's right subtree, p is moved up one level
              p = p.getParent();
            }
          }
          System.out.println (root); //By now p is the root, so the root is printed    
          p = root.getRight();
          
          while (p != null) {
            if ((p.getId().compareTo(end.getId()))<=0){ //While p is smaller than or equal to the end node it's 
              //left branch will be printed then it will be moved to the right
              
              Tree lTree = new Tree (p.getLeft());
              lTree.printTree();  
              
              System.out.println (p); //Prints p which is the root of lTree
              p = p.getRight(); 
            }
            else {
              p = p.getLeft(); //Prints the left branch of the end node when p == the end node
            }
          }
        }
        else if (end.getId().compareTo (root.getId()) < 0) {//If the end is on the left of the root then the left of the root branch will be printed 
          //recursively until the root of the recursively called tree's id is less than the end node
          Tree lTree = new Tree (root.getLeft());
          lTree.printTree(start, end);
        }
        else if  (start.getId().compareTo (root.getId()) > 0){ //If the end is on the right of the root then the right branch of the root will be printed
          //recursively until the root of the recursively called tree's id is less than the end node
          Tree rTree = new Tree (root.getRight());
          rTree.printTree(start, end);
        }
      }
    }
  }
  
  //finding the lower and upper TNodes to print tree
  public TNode findNode (String partialId, int where) //if where = 0, the lowest node is find but if where = 1, the highest node is found
  {
    if (partialId.length () == 26)
    {
      return findNode (partialId);
    }
    else if (root == null)
    {
      return null;
    }
    else
    {
      int partialLen = partialId.length ();
      String nodePartialId = root.getId ().substring (0, partialLen);
      
      if (partialId.compareTo (nodePartialId) < 0)
      {
        Tree lTree = new Tree (root.getLeft ());
        return lTree.findNode (partialId, where);
      }
      else if (partialId.compareTo (nodePartialId) > 0)
      {
        Tree rTree = new Tree (root.getRight ());
        return rTree.findNode (partialId, where);
      }
      else if (partialId.compareTo (nodePartialId) == 0) 
      {
        TNode p = root;
        TNode q = p;
        if (where == 0)
        {
          do
          {
            if (p.getId ().substring (0, partialLen).equals (partialId))
            {
              q = p;
              p = p.getLeft ();
            }
            else
              p = p.getRight ();
          }
          while (p != null);
        }
        else
        {
          do
          {
            if (p.getId ().substring (0, partialLen).equals (partialId))
            {
              q = p;
              p = p.getRight ();
            }
            else
              p = p.getLeft ();
          }
          while (p != null);
        }
        return q;
      }
      else{
        System.out.println("Fatal error in findNode(String, int)");
        return null;
      }
    }
  }
  
  public void buildFromMessagesFile(int whatId){
    Record r = new Record();
    
    for (int recordNumber = 0; recordNumber <= Globals.totalRecordsInMessageFile - 1; recordNumber++) {
      r.readFromMessagesFile (recordNumber); //read the record at recordNumber position from the messages file
      
      if(r.getData().charAt(Globals.MARKER_POS) == Globals.FIRST_RECORD_OF_MESSAGE){
        Message message = new Message();
        message.readFromMessagesFile(recordNumber);
        
        String key = "";
        
        if (whatId == Globals.SENDER_ID){
          key =  message.getId();
        }
        else if (whatId == Globals.RECEIVER_ID) {
          key = message.getReceiver() + message.getSender() + message.getDateTime();
        }
        else 
          System.out.println("Error in building index");
        
        TNode p = new TNode (key, recordNumber, null, null, null);
        this.insertNode(p);
      }
    }   
  }
  
  //This method creates a single string of all messages
  public void prepareTransmissionString () {
    if (root == null){
    }
    else {
      Tree tree = new Tree (root.getLeft());
      tree.prepareTransmissionString();
      
      NetIO.addToTransmissionString(root.getRecordNumber());
      
      tree = new Tree (root.getRight());
      tree.prepareTransmissionString();
    }
  }
  
  /*
   //printing a tree from the start node to the end node without going through the entire tree
   public void printTree(TNode start, TNode end) {
   
   if (start!= null && end!=null){ //If start and finish aren't null
   if (start.getId().compareTo(end.getId())<=0) { //If start's id is smaller than or equal to end's
   if ((start.getId().compareTo(root.getId()) <=0) && (root.getId().compareTo(end.getId()) <=0)) { //If start and end are on opposite sides of the root or the root
   TNode p = start;
   while (p != root) { //Used to print everything in between start and the root
   
   if (p.getId().compareTo(start.getId()) >= 0) { //Prints p if it is of a larger value than start
   System.out.println(p);
   Tree rTree = new Tree(p.getRight()); 
   rTree.printTree(); //Print the right subtree of p
   }
   
   if (p != root || p.getId().compareTo(start.getId()) < 0) { //If p isn't the root, after printing it's right subtree, p is moved up one level
   p = p.getParent();
   }
   }
   System.out.println (root); //By now p is the root, so the root is printed    
   p = root.getRight();
   
   while (p != null) {
   if ((p.getId().compareTo(end.getId()))<=0){ //While p is smaller than or equal to the end node it's 
   //left branch will be printed then it will be moved to the right
   
   Tree lTree = new Tree (p.getLeft());
   lTree.printTree();  
   
   System.out.println (p); //Prints p which is the root of lTree
   p = p.getRight(); 
   }
   else {
   p = p.getLeft(); //Prints the left branch of the end node when p == the end node
   }
   }
   }
   else if (end.getId().compareTo (root.getId()) < 0) {//If the end is on the left of the root then the left of the root branch will be printed 
   //recursively until the root of the recursively called tree's id is less than the end node
   Tree lTree = new Tree (root.getLeft());
   lTree.printTree(start, end);
   }
   else if  (start.getId().compareTo (root.getId()) > 0){ //If the end is on the right of the root then the right branch of the root will be printed
   //recursively until the root of the recursively called tree's id is less than the end node
   Tree rTree = new Tree (root.getRight());
   rTree.printTree(start, end);
   }
   }
   }
   } 
   **/
  
  //This method creates a single string of all messages that the client is requesting
  public void  prepareTransmissionString(TNode start, TNode end) {
    Tree rTree = new Tree();
    Tree lTree = new Tree();
    if (start!= null && end!=null){ //If start and finish aren't null
      if (start.getId().compareTo(end.getId())<=0) { //If start's id is smaller than or equal to end's
        if ((start.getId().compareTo(root.getId()) <=0) && (root.getId().compareTo(end.getId()) <=0)) { //If start and end are on opposite sides of the root or the root
          TNode p = start;
          while (p != null && p != root) {
            NetIO.addToTransmissionString(p.getRecordNumber()); 
            
            rTree = new Tree(p.getRight());
            rTree.prepareTransmissionString();
            
            do {
              p = p.getParent();
            } while (p != null && p.getId().compareTo(start.getId()) < 0);  //move up to ancestor that is within range                
          }
          NetIO.addToTransmissionString(p.getRecordNumber()); 
          p = root.getRight();
          
          while (p != null) {
            if ((p.getId().compareTo(end.getId()))<=0){ //While p is smaller than or equal to the end node it's 
              //left branch will be printed then it will be moved to the right
              
              lTree = new Tree (p.getLeft());
              lTree.prepareTransmissionString();  
              
              NetIO.addToTransmissionString(p.getRecordNumber());
              p = p.getRight(); 
            }
            else {
              p = p.getLeft(); 
            }
          }
        }
        else if (end.getId().compareTo (root.getId()) < 0) {//If the end is on the left of the root then the left of the root branch will be printed 
          //recursively until the root of the recursively called tree's id is less than the end node
          lTree = new Tree (root.getLeft());
          lTree.prepareTransmissionString(start, end);
        }
        else if  (start.getId().compareTo (root.getId()) > 0){ //If the end is on the right of the root then the right branch of the root will be printed
          //recursively until the root of the recursively called tree's id is less than the end node
          rTree = new Tree (root.getRight());
          rTree.prepareTransmissionString(start, end);
        }
      }
    }
  }
  
  
  
  public String toString() {
    if (root == null){
      return null;
    }
    else {
      return "" + root.getId();
    }
  }
}





