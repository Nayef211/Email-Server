import java.util.*;


public class PrintTest {
  public static void main(String[] args) {
    Tree tree = new Tree();
    TNode p = new TNode();
    TNode q = new TNode();
    
    Scanner in = new Scanner(System.in);
    int option = 0;
    
    //Row 1
    p = new TNode("08", 1, null, null, null);
    tree.insertNode(p);
    //Row 2
    p = new TNode("04", 2, null, null, null);
    tree.insertNode(p);
    p = new TNode("12", 3, null, null, null);
    tree.insertNode(p);
    //Row 3
    p = new TNode("02", 4, null, null, null);
    tree.insertNode(p);
    p = new TNode("06", 5, null, null, null);
    tree.insertNode(p);
    p = new TNode("10", 6, null, null, null);
    tree.insertNode(p);
    p = new TNode("14", 7, null, null, null);
    tree.insertNode(p);
    //Row 4
    p = new TNode("01", 8, null, null, null);
    tree.insertNode(p);
    p = new TNode("03", 9, null, null, null);
    tree.insertNode(p);
    p = new TNode("07", 11, null, null, null);
    tree.insertNode(p);
    p = new TNode("09", 12, null, null, null);
    tree.insertNode(p);
    p = new TNode("11", 13, null, null, null);
    tree.insertNode(p);
    p = new TNode("13", 14, null, null, null);
    tree.insertNode(p);
    
    do {
      System.out.println("Printing from one node to another within a tree tests.\n" +
                         "11: Both start and end are the same node and start is the root of the tree.\n" +
                         "12: Both start and end are the same node and start is any node to the left of the root of the tree.\n" +
                         "13: Both start and end are the same node and start is any node to the right of the root of the tree.\n" +
                         "21: Start and end are different nodes and they are both located to the left of the root of the tree.\n" +
                         "22: Start and end are different nodes and they are both located to the right of the root of the tree.\n" +
                         "23: Start and end are different nodes and start is located to the " +
                         "left of the root and end is located to the right of the tree.\n" +
                         "00: See What the tree looks like.\n" +
                         "99: A full print of the tree's nodes.\n");
      
      option = in.nextInt();
      
      switch(option) {
        case 11:
          System.out.println("Both start and end are the same node and start is the root of the tree."); 
          p = tree.getRoot();
          System.out.println("Using node " + p.getId());
          tree.printTree(p, p);
          break;
          
        case 12:
          System.out.println("Both start and end are the same node and start is any node to the left of the root of the tree.");
          p = tree.getRoot().getLeft().getLeft();
          System.out.println("Using node " + p.getId());
          tree.printTree(p, p);
          break;
          
        case 13:
          System.out.println("Both start and end are the same node and start is any node to the right of the root of the tree.");
          p = tree.getRoot().getRight().getRight();
          System.out.println("Using node " + p.getId());
          tree.printTree(p, p);
          break;
          
        case 21:
          System.out.println("Start and end are different nodes and they are both located to the left of the root of the tree.");
          p = tree.findNode("01"); //tree.getRoot().getLeft().getLeft();
          q = tree.findNode("07"); //tree.getRoot().getLeft().getRight();
          System.out.println("Using nodes " + p.getId() + " to " + q.getId() + ".");
          tree.printTree(p, q);
          break;
          
        case 22:
          System.out.println("Start and end are different nodes and they are both located to the right of the root of the tree.");
          p = tree.findNode("09"); //tree.getRoot().getRight().getLeft();
          q = tree.findNode("15"); //tree.getRoot().getRight().getRight();
          System.out.println("Using nodes " + p.getId() + " to " + q.getId() + ".");
          tree.printTree(p, q);
          break;
        case 23:
          System.out.println("Start and end are different nodes and start is located to the " +
                             "left of the root and end is located to the right of the tree.");
          p = tree.findNode("01"); //tree.getRoot().getLeft();
          q = tree.findNode("14"); //tree.getRoot().getRight();
          System.out.println("Using nodes " + p.getId() + " to " + q.getId() + ".");
          tree.printTree(p, q);
          break;
          
        case 00:
          System.out.println("The tree looks like this:\n" +
                       "                 08\n" +
                       "         04              12\n" +
                       "     02      06      10      14\n" +
                       "   01  03  05  07  09  11  13  15\n");
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

/*
public class PrintTest {
  public static void main (String args[]){
    
    Tree tree = new Tree();
    TNode p;
    
    p = new TNode("50", 0, null, null, null);
    tree.insertNode(p);
    
    p = new TNode("40", 0, null, null, null);
    tree.insertNode(p);
    
    p = new TNode("60", 0, null, null, null);
    tree.insertNode(p);
    
    p = new TNode("30", 0, null, null, null);
    tree.insertNode(p);
    
    p = new TNode("45", 0, null, null, null);
    tree.insertNode(p);
    
    p = new TNode("55", 0, null, null, null);
    tree.insertNode(p);
    
    p = new TNode("70", 0, null, null, null);
    tree.insertNode(p);
    
    p = new TNode("20", 0, null, null, null);
    tree.insertNode(p);
    
    p = new TNode("42", 0, null, null, null);
    tree.insertNode(p);
    
    p = new TNode("48", 0, null, null, null);
    tree.insertNode(p);
    
    p = new TNode("58", 0, null, null, null);
    tree.insertNode(p);
    
    p = new TNode("75", 0, null, null, null);
    tree.insertNode(p);
    
    p = new TNode("80", 0, null, null, null);
    tree.insertNode(p);
    
    
    //Case 1. Both start and end are the same node and:
    //a. start is the root of the tree
    // tree.printTree(tree.findNode("50") , tree.findNode("50"));
    //b. start is any node to the left of the root of the tree
    //tree.printTree(tree.findNode("42") , tree.findNode("42"));
    //c. start is any node to the right of the root of the tree
    //tree.printTree(tree.findNode("57") , tree.findNode("57"));
    
    //Case 2. Start and end are different nodes and:
    //a. they are both located to the left of the root of the tree
    //tree.printTree(tree.findNode("30") , tree.findNode("44"));
    //b. they are both located to the right of the root of the tree
    //tree.printTree(tree.findNode("55") , tree.findNode("80"));
    //c. start is located to the left of the root and end is located to the right of the tree
    tree.printTree(tree.findNode("20") , tree.findNode("80"));
  }
}
*/