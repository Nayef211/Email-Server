import java.util.*;

public class TreeMain {
  public static void main (String [] args) {
    
    /*
     String list [] = new String [500]; 
     Random r = new Random();
     
     boolean repeated = false;
     //initializing all values to "0"
     for (int i = 0; i<list.length;i++){
     list [i] = "0";
     }
     
     //***************Task 1 - Insert Ranodm Node********************
     //initializing values to a random 6 digit integer
     for (int i = 0; i<list.length;i++){ 
     while (list[i].equals("0")){
     String value = "" + (r.nextInt (900000) + 100000);  
     
     //checking if there is repetition
     for (int j = 0; j<i;j++){
     if (list [j].equals(value))
     repeated = true;
     }
     
     if (!repeated){
     list [i] = value;
     }
     }      
     }
     
     //inserting first 20 values into array
     Tree tree = new Tree ();
     TNode p = null;
     
     for (int i = 0; i <20; i++){
     p = new TNode (list [i], Integer.parseInt(list [i]) * 10, null, null, null);
     tree.insertNode (p);
     } 
     
     //***************Task 2 - Delete and Insert Randomly********************
     for (int i = 0; i < 480; i++) {
     tree.deleteNode (tree.findNode (list[i]));
     TNode l = new TNode (list[i+20], Integer.parseInt(list[i+20])*10 , null, null, null) ;
     tree.insertNode(l);
     }
     tree.printTree();   
     */
    
    //Testing printing
    
    Tree tree = new Tree();
    TNode p = new TNode();
    TNode q = new TNode();
    
    Scanner in = new Scanner(System.in);
    int option = 0;
    
    //Row 1
    p = new TNode("080", 1, null, null, null);
    tree.insertNode(p);
    //Row 2
    p = new TNode("040", 2, null, null, null);
    tree.insertNode(p);
    p = new TNode("120", 3, null, null, null);
    tree.insertNode(p);
    //Row 3
    p = new TNode("020", 4, null, null, null);
    tree.insertNode(p);
    p = new TNode("060", 5, null, null, null);
    tree.insertNode(p);
    p = new TNode("100", 6, null, null, null);
    tree.insertNode(p);
    p = new TNode("140", 7, null, null, null);
    tree.insertNode(p);
    //Row 4
    p = new TNode("010", 8, null, null, null);
    tree.insertNode(p);
    p = new TNode("030", 9, null, null, null);
    tree.insertNode(p);
    //p = new TNode("050", 10, null, null, null);
    //tree.insertNode(p);
    p = new TNode("070", 11, null, null, null);
    tree.insertNode(p);
    p = new TNode("090", 12, null, null, null);
    tree.insertNode(p);
    p = new TNode("110", 13, null, null, null);
    tree.insertNode(p);
    p = new TNode("130", 14, null, null, null);
    tree.insertNode(p);
    //p = new TNode("150", 15, null, null, null);
    //tree.insertNode(p);
    //Added Nodes
    //p = new TNode("160", 16, null, null, null);
    //tree.insertNode(p);
    
    do {
      System.out.println("------------------------------Printing from one node to another within a tree tests.------------------------------\n" +
                         "11: Both start and end are the same node and start is the root of the tree.\n" +
                         "12: Both start and end are the same node and start is any node to the left of the root of the tree.\n" +
                         "13: Both start and end are the same node and start is any node to the right of the root of the tree.\n" +
                         "21: Start and end are different nodes and they are both located to the left of the root of the tree.\n" +
                         "22: Start and end are different nodes and they are both located to the right of the root of the tree.\n" +
                         "23: Start and end are different nodes and start is located to the " +
                         "left of the root and end is located to the right of the tree.\n" +
                         "00: See What the tree looks like.\n" +
                         "99: A full print of the tree's nodes.\n" +
                         "-1: Exit.\n");
      
      option = in.nextInt();
      
      switch(option) {
        case 11:
          System.out.println("Both start and end are the same node and start is the root of the tree."); 
          p = tree.getRoot();
          System.out.println("Using node " + p.getId());
          System.out.println("----------------------------");
          System.out.println("Output should be:\n" +
                             "id: 080 \tRecord Number: 1\n");
          System.out.println("Output is:");
          tree.printTree(p, p);
          System.out.println();
          break;
          
        case 12:
          System.out.println("Both start and end are the same node and start is any node to the left of the root of the tree.");
          p = tree.findNode("020");
          System.out.println("----------------------------");
          System.out.println("Output should be:\n" +
                             "id: 020 \tRecord Number: 4\n");
          System.out.println("Output is:");
          tree.printTree(p, p);
          System.out.println();
          break;
          
        case 13:
          System.out.println("Both start and end are the same node and start is any node to the right of the root of the tree.");
          p = tree.findNode("130");
          System.out.println("----------------------------");
          System.out.println("Output should be:\n" +
                             "id: 130 \tRecord Number: 14\n");
          System.out.println("Output is:");
          tree.printTree(p, p);
          System.out.println();
          break;
          
        case 21:
          System.out.println("Start and end are different nodes and they are both located to the left of the root of the tree.");
          p = tree.findNode("030");
          q = tree.findNode("070");
          System.out.println("Using nodes " + p.getId() + " to " + q.getId() + ".");
          System.out.println("----------------------------");
          System.out.println("Output should be:\n" +
                             "id: 030 \tRecord Number: 9\n" +
                             "id: 040 \tRecord Number: 2\n" +
                             "id: 060 \tRecord Number: 5\n" +
                             "id: 070 \tRecord Number: 11\n");
          System.out.println("Output is:");
          tree.printTree(p, q);
          System.out.println();
          break;
          
        case 22:
          System.out.println("Start and end are different nodes and they are both located to the right of the root of the tree.");
          p = tree.findNode("100");
          q = tree.findNode("130");
          System.out.println("Using nodes " + p.getId() + " to " + q.getId() + ".");
          System.out.println("----------------------------");
          System.out.println("Output should be:\n" +
                             "id: 100 \tRecord Number: 6\n" +
                             "id: 110 \tRecord Number: 13\n" +
                             "id: 120 \tRecord Number: 3\n" +
                             "id: 130 \tRecord Number: 14\n");
          System.out.println("Output is:");
          tree.printTree(p, q);
          System.out.println();
          break;
        case 23:
          System.out.println("Start and end are different nodes and start is located to the " +
                             "left of the root and end is located to the right of the tree.");
          p = tree.findNode("030");
          q = tree.findNode("130");
          System.out.println("Using nodes " + p.getId() + " to " + q.getId() + ".");
          System.out.println("----------------------------");
          System.out.println("Output should be:\n" +
                             "id: 030 \tRecord Number: 9\n" +
                             "id: 040 \tRecord Number: 2\n" +
                             "id: 060 \tRecord Number: 5\n" +
                             "id: 070 \tRecord Number: 11\n" +
                             "id: 080 \tRecord Number: 1\n" +
                             "id: 090 \tRecord Number: 12\n" +
                             "id: 100 \tRecord Number: 6\n" +
                             "id: 110 \tRecord Number: 13\n" +
                             "id: 120 \tRecord Number: 3\n" +
                             "id: 130 \tRecord Number: 14\n");
          System.out.println("Output is:");
          tree.printTree(p, q);
          System.out.println();
          break;
          
        case 00:
          System.out.println("The tree looks like this:\n" +
                             "                     080\n" +
                             "         040                     120\n" +
                             "   020         060         100         140\n" +
                             "010   030   ---   070   090   110   130   ---\n");
          break;
          
        case 99:
          System.out.println("Here is the Tree:");
          tree.printTree();
          break;
      }
      System.out.println();
    } while (option != -1);
  }
}