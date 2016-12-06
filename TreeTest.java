import java.util.*;

public class TreeTest {
    public static int testIdListSize = -1;
    public static int testTreeSize = -1;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option = 99;
               
        do {
            Tree tree = new Tree();    
            TNode p = null;
            
            System.out.println("****************** TREE TESTING OPTIONS ****************** ");
            System.out.println("11. Case 1 (root)               41. Case 4 (root)");
            System.out.println("12. Case 1 (not root)           42. Case 4 (not root)");
            System.out.println("21. Case 2 (root)               71. Case 7a (root)");
            System.out.println("22. Case 2 (not root)           72. Case 7a (not root)");
            System.out.println("31. Case 3 (root))              73. Case 7b (root)");
            System.out.println("32. Case 3 (not root)           74. Case 7b (not root)");
            System.out.println("51. Case 5 (root)               75. Case 7c (root)");
            System.out.println("52. Case 5 (not root)           76. Case 7c (not root)");
            System.out.println("61. Case 6 (root)");
            System.out.println("62. Case 6 (not root) ");
            System.out.println();
            System.out.println("80. Create tree with random id nodes, delete & insert ");
            System.out.println("    nodes a number of times, print tree (March 3: Tasks 1, 2 & 3)");            
            //System.out.println("81. Generate a random tree. Then find a node from a given id");
            //System.out.println("90. Test tree heights");
            
            System.out.println("99. Quit");   
            
            System.out.println();
            System.out.print("Option -> ");
            option = in.nextInt();
            
            switch(option) {
                case 11 :                    
                    System.out.println("RESULT SHOULD BE:");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("***");
                    System.out.println("***");
                    
                    System.out.println("TESTING PROGRAM OUTPUTS: ");
                    p = new TNode("40", 444, null, null, null);
                    tree.insertNode(p);
                    tree.printTree();
                    System.out.println("***");
                    p = tree.findNode("40");
                    tree.deleteNode(p);
                    tree.printTree();
                    System.out.println("***");
                    
                    break;

                case 12 :
                    System.out.println("RESULT SHOULD BE:");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("***");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("***");
                    
                    System.out.println("TESTING PROGRAM OUTPUTS: ");
                    p = new TNode("40", 444, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("30", 333, null, null, null);
                    tree.insertNode(p);
                    tree.printTree();
                    System.out.println("***");
                    p = tree.findNode("30");
                    tree.deleteNode(p);
                    tree.printTree(); 
                    System.out.println("***");
                    
                    break;

                case 21 :
                    System.out.println("RESULT SHOULD BE:");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("***");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("***");
                    
                    System.out.println("TESTING PROGRAM OUTPUTS: ");
                    p = new TNode("40", 444, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("30", 333, null, null, null);
                    tree.insertNode(p);
                    tree.printTree();
                    System.out.println("***");
                    p = tree.findNode("40");
                    tree.deleteNode(p);
                    tree.printTree(); 
                    System.out.println("***");
                    
                    break;

                case 22 :
                    System.out.println("RESULT SHOULD BE:");
                    System.out.println("Id: 20 Record number: 222");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("***");
                    System.out.println("Id: 20 Record number: 222");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("***");
                    
                    System.out.println("TESTING PROGRAM OUTPUTS: ");
                    p = new TNode("40", 444, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("30", 333, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("20", 222, null, null, null);
                    tree.insertNode(p);
                    tree.printTree();
                    System.out.println("***");
                    p = tree.findNode("30");
                    tree.deleteNode(p);
                    tree.printTree(); 
                    System.out.println("***");
                    
                    break;

                case 31 :
                    System.out.println("RESULT SHOULD BE:");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("***");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("***");
                    
                    System.out.println("TESTING PROGRAM OUTPUTS: ");
                    p = new TNode("40", 444, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("50", 555, null, null, null);
                    tree.insertNode(p);
                    tree.printTree();
                    System.out.println("***");
                    p = tree.findNode("40");
                    tree.deleteNode(p);
                    tree.printTree(); 
                    System.out.println("***");
                    
                    break;

                case 32 :
                    System.out.println("RESULT SHOULD BE:");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("Id: 60 Record number: 666");
                    System.out.println("***");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("Id: 60 Record number: 666");
                    System.out.println("***");
                    
                    System.out.println("TESTING PROGRAM OUTPUTS: ");
                    p = new TNode("40", 444, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("50", 555, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("60", 666, null, null, null);
                    tree.insertNode(p);
                    tree.printTree();
                    System.out.println("***");
                    p = tree.findNode("50");
                    tree.deleteNode(p);
                    tree.printTree(); 
                    System.out.println("***");
                    
                    break;

                case 51 :
                    System.out.println("RESULT SHOULD BE:");
                    System.out.println("Id: 25 Record number: 225");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 35 Record number: 335");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("***");
                    System.out.println("Id: 25 Record number: 225");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 35 Record number: 335");
                    System.out.println("***");
                    
                    System.out.println("TESTING PROGRAM OUTPUTS: ");
                    p = new TNode("40", 444, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("30", 333, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("25", 225, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("35", 335, null, null, null);
                    tree.insertNode(p);
                    tree.printTree();
                    System.out.println("***");
                    p = tree.findNode("40");
                    tree.deleteNode(p);
                    tree.printTree(); 
                    System.out.println("***");
                    
                    break;

                case 52 :
                    System.out.println("RESULT SHOULD BE:");
                    System.out.println("Id: 25 Record number: 225");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 35 Record number: 335");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("***");
                    System.out.println("Id: 25 Record number: 225");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 35 Record number: 335");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("***");
                    
                    System.out.println("TESTING PROGRAM OUTPUTS: ");
                    p = new TNode("50", 555, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("40", 444, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("30", 333, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("25", 225, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("35", 335, null, null, null);
                    tree.insertNode(p);
                    tree.printTree();
                    System.out.println("***");
                    p = tree.findNode("40");
                    tree.deleteNode(p);
                    tree.printTree(); 
                    System.out.println("***");
                    
                    break;

                case 61 :
                    System.out.println("RESULT SHOULD BE:");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("Id: 45 Record number: 445");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("Id: 60 Record number: 666");
                    System.out.println("***");
                    System.out.println("Id: 45 Record number: 445");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("Id: 60 Record number: 666");
                    System.out.println("***");
                    
                    System.out.println("TESTING PROGRAM OUTPUTS: ");
                    p = new TNode("40", 444, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("50", 555, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("45", 445, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("60", 666, null, null, null);
                    tree.insertNode(p);
                    tree.printTree();
                    System.out.println("***");
                    p = tree.findNode("40");
                    tree.deleteNode(p);
                    tree.printTree(); 
                    System.out.println("***");
                    
                    break;

                case 62 :
                    System.out.println("RESULT SHOULD BE:");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("Id: 45 Record number: 445");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("Id: 60 Record number: 666");
                    System.out.println("***");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 45 Record number: 445");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("Id: 60 Record number: 666");
                    System.out.println("***");
                    
                    System.out.println("TESTING PROGRAM OUTPUTS: ");
                    p = new TNode("30", 333, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("40", 444, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("50", 555, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("45", 445, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("60", 666, null, null, null);
                    tree.insertNode(p);
                    tree.printTree();
                    System.out.println("***");
                    p = tree.findNode("40");
                    tree.deleteNode(p);
                    tree.printTree(); 
                    System.out.println("***");
                    
                    break;

                case 41 :
                    System.out.println("RESULT SHOULD BE:");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("***");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("***");
                    
                    System.out.println("TESTING PROGRAM OUTPUTS: ");
                    p = new TNode("40", 444, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("30", 333, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("50", 555, null, null, null);
                    tree.insertNode(p);
                    tree.printTree();
                    System.out.println("***");
                    p = tree.findNode("40");
                    tree.deleteNode(p);
                    tree.printTree(); 
                    System.out.println("***");
                    
                    break;

                case 42 :
                    System.out.println("RESULT SHOULD BE:");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("Id: 45 Record number: 445");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("***");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 45 Record number: 445");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("***");
                    
                    System.out.println("TESTING PROGRAM OUTPUTS: ");
                    p = new TNode("50", 555, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("40", 444, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("45", 445, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("30", 333, null, null, null);
                    tree.insertNode(p);
                    tree.printTree();
                    System.out.println("***");
                    p = tree.findNode("40");
                    tree.deleteNode(p);
                    tree.printTree(); 
                    System.out.println("***");
                    
                    break;

                case 71 :
                    System.out.println("RESULT SHOULD BE:");
                    System.out.println("Id: 20 Record number: 222");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("***");
                    System.out.println("Id: 20 Record number: 222");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("***");
                    
                    System.out.println("TESTING PROGRAM OUTPUTS: ");
                    p = new TNode("40", 444, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("30", 333, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("50", 555, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("20", 222, null, null, null);
                    tree.insertNode(p);
                    tree.printTree();
                    System.out.println("***");
                    p = tree.findNode("40");
                    tree.deleteNode(p);
                    tree.printTree(); 
                    System.out.println("***");
                    
                    break;
                    
                case 72 :
                    System.out.println("RESULT SHOULD BE:");
                    System.out.println("Id: 10 Record number: 111");
                    System.out.println("Id: 20 Record number: 222");
                    System.out.println("Id: 25 Record number: 225");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("***");
                    System.out.println("Id: 10 Record number: 111");
                    System.out.println("Id: 20 Record number: 222");
                    System.out.println("Id: 25 Record number: 225");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("***");
                    
                    System.out.println("TESTING PROGRAM OUTPUTS: ");
                    p = new TNode("20", 222, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("40", 444, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("30", 333, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("50", 555, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("25", 225, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("10", 111, null, null, null);
                    tree.insertNode(p);
                    tree.printTree();
                    System.out.println("***");
                    p = tree.findNode("40");
                    tree.deleteNode(p);
                    tree.printTree(); 
                    System.out.println("***");
                    
                    break;

                case 73 :
                    System.out.println("RESULT SHOULD BE:");
                    System.out.println("Id: 10 Record number: 111");
                    System.out.println("Id: 20 Record number: 222");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("***");
                    System.out.println("Id: 10 Record number: 111");
                    System.out.println("Id: 20 Record number: 222");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("***");
                    
                    System.out.println("TESTING PROGRAM OUTPUTS: ");
                    p = new TNode("40", 444, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("20", 222, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("50", 555, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("30", 333, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("10", 111, null, null, null);
                    tree.insertNode(p);
                    tree.printTree();
                    System.out.println("***");
                    p = tree.findNode("40");
                    tree.deleteNode(p);
                    tree.printTree(); 
                    System.out.println("***");
                    
                    break;
                    
                case 74 :
                    System.out.println("RESULT SHOULD BE:");
                    System.out.println("Id: 02 Record number: 2");
                    System.out.println("Id: 05 Record number: 5");
                    System.out.println("Id: 10 Record number: 111");
                    System.out.println("Id: 20 Record number: 222");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("***");
                    System.out.println("Id: 02 Record number: 2");
                    System.out.println("Id: 05 Record number: 5");
                    System.out.println("Id: 10 Record number: 111");
                    System.out.println("Id: 20 Record number: 222");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 50 Record number: 555");
                    System.out.println("***");
                    
                    System.out.println("TESTING PROGRAM OUTPUTS: ");
                    p = new TNode("05", 5, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("02", 2, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("40", 444, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("20", 222, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("50", 555, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("30", 333, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("10", 111, null, null, null);
                    tree.insertNode(p);
                    tree.printTree();
                    System.out.println("***");
                    p = tree.findNode("40");
                    tree.deleteNode(p);
                    tree.printTree(); 
                    System.out.println("***");
                    
                    break;
                    
                case 75 :
                    System.out.println("RESULT SHOULD BE:");
                    System.out.println("Id: 10 Record number: 111");
                    System.out.println("Id: 20 Record number: 222");
                    System.out.println("Id: 25 Record number: 225");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 32 Record number: 132");
                    System.out.println("Id: 33 Record number: 133");
                    System.out.println("Id: 34 Record number: 134");
                    System.out.println("Id: 35 Record number: 335");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("Id: 60 Record number: 666");
                    System.out.println("Id: 80 Record number: 888");
                    System.out.println("Id: 90 Record number: 999");
                    System.out.println("***");
                    System.out.println("Id: 10 Record number: 111");
                    System.out.println("Id: 20 Record number: 222");
                    System.out.println("Id: 25 Record number: 225");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 32 Record number: 132");
                    System.out.println("Id: 33 Record number: 133");
                    System.out.println("Id: 34 Record number: 134");
                    System.out.println("Id: 35 Record number: 335");
                    System.out.println("Id: 60 Record number: 666");
                    System.out.println("Id: 80 Record number: 888");
                    System.out.println("Id: 90 Record number: 999");
                    System.out.println("***");
                    
                    System.out.println("TESTING PROGRAM OUTPUTS: ");
                    p = new TNode("40", 444, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("20", 222, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("80", 888, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("10", 111, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("30", 333, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("60", 666, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("90", 999, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("25", 225, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("35", 335, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("33", 133, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("32", 132, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("34", 134, null, null, null);
                    tree.insertNode(p);
                    tree.printTree();
                    System.out.println("***");
                    p = tree.findNode("40");
                    tree.deleteNode(p);
                    tree.printTree(); 
                    System.out.println("***");
                    
                    break;
                    
                case 76 :
                    System.out.println("RESULT SHOULD BE:");
                    System.out.println("Id: 10 Record number: 111");
                    System.out.println("Id: 20 Record number: 222");
                    System.out.println("Id: 25 Record number: 225");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 32 Record number: 132");
                    System.out.println("Id: 33 Record number: 133");
                    System.out.println("Id: 34 Record number: 134");
                    System.out.println("Id: 35 Record number: 335");
                    System.out.println("Id: 40 Record number: 444");
                    System.out.println("Id: 60 Record number: 666");
                    System.out.println("Id: 80 Record number: 888");
                    System.out.println("Id: 90 Record number: 990");
                    System.out.println("Id: 96 Record number: 996");
                    System.out.println("Id: 97 Record number: 997");
                    System.out.println("Id: 98 Record number: 998");
                    System.out.println("Id: 99 Record number: 999");
                    System.out.println("***");
                    System.out.println("Id: 10 Record number: 111");
                    System.out.println("Id: 20 Record number: 222");
                    System.out.println("Id: 25 Record number: 225");
                    System.out.println("Id: 30 Record number: 333");
                    System.out.println("Id: 32 Record number: 132");
                    System.out.println("Id: 33 Record number: 133");
                    System.out.println("Id: 34 Record number: 134");
                    System.out.println("Id: 35 Record number: 335");
                    System.out.println("Id: 60 Record number: 666");
                    System.out.println("Id: 80 Record number: 888");
                    System.out.println("Id: 90 Record number: 990");
                    System.out.println("Id: 96 Record number: 996");
                    System.out.println("Id: 97 Record number: 997");
                    System.out.println("Id: 98 Record number: 998");
                    System.out.println("Id: 99 Record number: 999");
                    System.out.println("***");
                    
                    System.out.println("TESTING PROGRAM OUTPUTS: ");
                    p = new TNode("96", 996, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("40", 444, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("20", 222, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("80", 888, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("10", 111, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("30", 333, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("60", 666, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("90", 990, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("25", 225, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("35", 335, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("33", 133, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("32", 132, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("34", 134, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("98", 998, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("97", 997, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("99", 999, null, null, null);
                    tree.insertNode(p);
                    tree.printTree();
                    System.out.println("***");
                    p = tree.findNode("40");
                    tree.deleteNode(p);
                    tree.printTree(); 
                    System.out.println("***");
                    
                    break;
                    
                case 80 :
                    int testIdListSize = -1;
                    int testTreeSize = -1;
                    
                    do {
                        System.out.print("Number of random ids to generate: ");
                        testIdListSize = in.nextInt();
                    
                        System.out.print("Number of nodes to add (< number of random ids):  ");
                        testTreeSize = in.nextInt();
                        
                        if (testTreeSize >= testIdListSize) {
                            System.out.println("***Invalid: Number of nodes needs to be smaller than number of random ids");
                        }
                        
                        if (testIdListSize > 1000000)
                            System.out.println("***Number of random ids too large");
                        
                        if (testTreeSize > 200000)
                            System.out.println("***Number of random ids too large");

                        
                    } while (testTreeSize >= testIdListSize || testIdListSize > 1000000 || testTreeSize > 200000);
                    System.out.println();
                    
                    
                    // Task 1
                    System.out.println("========= TASK 1: Inserting nodes into tree");
                    String[] list = new String[testIdListSize];
                    fillListWithServerRandomIds(list);
                    //System.out.println("Random list of ids");
                    //printList(list);
                    
                    for (int i = 0; i < testTreeSize; i++) {
                        p = new TNode(list[i], i * 10, null, null, null); 
                        tree.insertNode(p);
                        //tree.balance(p);
                    }                    
                    tree.printTree();
                    System.out.println("Height of tree after Task 1: " + tree.height());
                    
                    int numberOfNodes = tree.nodeCount();
                    System.out.println("Tree should have  " + testTreeSize + " nodes");
                    System.out.println("Tree actually has " + numberOfNodes + " nodes");
                                        
                    if (testTreeSize == numberOfNodes)
                        System.out.println("TASK 1 Passed");
                    else 
                        System.out.println("TASK 1 Failed");
                    System.out.println();
                    
                    // Task 2
                    System.out.println("========= TASK 2: Deleting and inserting nodes");
                    for (int i = 0; i < (testIdListSize - testTreeSize); i++) {
                        p = tree.findNode(list[i]);
                        tree.deleteNode(p);
                        //tree.balance(p);
                        p = new TNode(list[i + testTreeSize], i  * 10, null, null, null);
                        tree.insertNode(p);
                        //tree.balance(p);
                    }
                    tree.printTree();
                    System.out.println("Height of tree after Task 2: " + tree.height());
                    
                    numberOfNodes = tree.nodeCount();
                    System.out.println("After " + (testIdListSize - testTreeSize) + " deletions and insertions tree should have " + testTreeSize + " nodes");
                    System.out.println("Tree actually has " + tree.nodeCount() + " nodes");
                    
                    if (testTreeSize == numberOfNodes)
                        System.out.println("TASK 2 Passed");
                    else 
                        System.out.println("TASK 2 Failed");                   
                    System.out.println();
                    
                    // Task 3
                    System.out.println("========= TASK 3: Checking for repeats; all nodes should lead to root");
                    String[] idList = new String[tree.nodeCount()];
                    int[] idx = new int[1];
                    idx[0] = 0;
                    copyToList(tree, idList, idx);
                    
                    printList(idList);
                    System.out.println("Height of tree after Task 3: " + tree.height());
                    boolean repeatFound = reportRepeatIds(idList);
                    boolean rootAlwaysReached = travelToRoot(tree, idList);
                    
                    if (!repeatFound) {
                        if (rootAlwaysReached) {
                            System.out.println("No repeat ids found: Ok");
                            System.out.println("All nodes lead to the root: Ok");
                            System.out.println("TASK 3 Passed");
                        }
                        else {
                            System.out.println("TASK 3 Failed: Root not reached for all nodes");
                        }
                    }
                    else {
                        System.out.println("TASK 3 Failed: Repeat ids have been found");
                    }
                    System.out.println();
                    break;
/*                    
                case 81 :
                    System.out.print("Number of nodes to generate: ");
                    testTreeSize = in.nextInt();
                    
                    list = new String[testTreeSize];
                    long start = System.currentTimeMillis();
                    fillListWithServerRandomIds(list);
                    long end = System.currentTimeMillis();
                    System.out.println("Random id's generation time: " + ((end - start) / 1000.0));
                    
                    start = System.currentTimeMillis();
                    for (int i = 0; i < testTreeSize; i++) {
                        p = new TNode(list[i], Integer.parseInt(list[i]) * 10, null, null, null); 
                        tree.insertNode(p);
                        tree.balance(p);
                    }
                    end = System.currentTimeMillis();
                    tree.printTree();
                    System.out.println("Insertion time: " + ((end - start) / 1000.0));
                    System.out.println("Height of tree after first insertion of elements: " + tree.height());
                    
                    int id = -1;
                    do {
                        System.out.print("Node id: (-1 to quit) : ");
                        id = in.nextInt();
                        if (id != -1) {
                            String idStr = lPad("" + id, 6, '0');

                            int i = 0;
                            System.out.print("Sequential search performed 500,000 times...");
                            start = System.currentTimeMillis();
                            for (int times = 0; times < 500000; times++) {
                                for (i = 0; i < list.length && !idStr.equals(list[i]); i++)
                                    ;
                            }
                            end = System.currentTimeMillis();
                            if (i < list.length)
                                System.out.println(idStr + " found");
                            else
                                System.out.println(idStr + " not found");
                            System.out.println("Search time: " + ((end - start) / 1000.0));


                            System.out.print("Tree search performed 500,000 times...");
                            start = System.currentTimeMillis();
                            for (int times = 0; times < 500000; times++) {
                                p = tree.findNode(idStr);
                            }
                            end = System.currentTimeMillis();
                            if (p != null)
                                System.out.println(idStr + " found");
                            else
                                System.out.println(idStr + " not found");
                            System.out.println("Search time: " + ((end - start) / 1000.0));
                        }
                    } while (id != -1);
                    break;
                    
                case 90 :
                    // cases to test tree height
                    System.out.println("Tree empty; Height: " + tree.height());
                    
                    p = new TNode("50", 500, null, null, null);
                    tree.insertNode(p);
                    System.out.println("Tree has root; Height: " + tree.height());
                    
                    p = new TNode("30", 300, null, null, null);
                    tree.insertNode(p);
                    System.out.println("Tree has root, root.left; Height: " + tree.height());
                    
                    p = new TNode("10", 100, null, null, null);
                    tree.insertNode(p);
                    System.out.println("Tree has root, root.left, root.left.left; Height: " + tree.height());
                    
                    p = new TNode("70", 700, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("60", 600, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("65", 650, null, null, null);
                    tree.insertNode(p);
                    p = new TNode("80", 800, null, null, null);
                    tree.insertNode(p);
                    System.out.println("Tree has: root, root.left, root.left.left, root.right, root.right.left, root.right.right, root.right.left.right; Height: " + tree.height());
                    break;
*/
                default : 
                    break;
                    
                                       
            }
        } while (option != 99);
   }

    public static String lPad(String text, int desiredLength, char paddingItem) {
 String padding = "";
 for (int i = 0; i < desiredLength - text.length(); i++)
     padding = padding + paddingItem;
 return padding + text;
    }
        
   // this method takes an int and converts it into four bytes and returns as a String
   private static String intToBytesStr(int n) {
       return "" + (char)((n & 0xFF000000) >> 24) + 
                   (char)((n & 0x00FF0000) >> 16) + 
                   (char)((n & 0x0000FF00) >> 8)  + 
                   (char) (n & 0x000000FF);
   }
   
   // this method takes a long and converts it into eight bytes and returns as a String
   private static String longToBytesStr(long number) {
       int fourMSB = (int) (number / 0x100000000L);   // four most significant bytes
       int fourLSB = (int) (number - fourMSB * 0x100000000L);   // four least significant bytes
        
       return intToBytesStr(fourMSB) + intToBytesStr(fourLSB);
   }
   
   private static String generateRandomCode(int len) {
       String code = "";
       for (int i = 0; i < len; i++) {
           code = code + (int) (Math.random() * 10);
       }
       return code;
   }
   
    public static void delay (int ms) {
 try {
     Thread.sleep (ms);
 }
 catch (InterruptedException ex) {
 }
    }
   
   // guaranteed unique id. a code is generated and then the
   // time is appended; but many instructions could be executed in the
   // same millisecond. A way to fix this is by putting a 
   // delay at the beginning of this method to force the time to be one
   // millisecond later
   private static void fillListWithServerRandomIds(String[] list) {
       delay(20);
       //long now = System.currentTimeMillis();
       long now = 0x4142434445464748L; // use this for testing; start time where eight bytes are ABCDEFGH
       for (int i = 0; i < list.length; i++) { 
           list[i] = generateRandomCode(2) + longToBytesStr(now + i);  // id s/b that of server (39)
       }
              
       // shuffle the numbers: use this loop only if the loop above generates sequential codes
       /*for (int i = 0; i < list.length; i++) {            int k = (int) (Math.random() * list.length);
           String tmp = list[i];
           list[i] = list[k];
           list[k] = tmp;
       }*/
   }
   
   private static void printList(String[] list) {
       String lpad = "";
       for (int i = 0; i < list.length; i++) {
           System.out.println(lpad + i + " " + list[i]);
       }
   }
      
   private static void copyToList(Tree tree, String[] idList, int[] i) {
       if (tree.getRoot() != null) {
           Tree subtree = null;
           
           subtree = new Tree(tree.getRoot().getLeft());
           copyToList(subtree, idList, i);
           
           idList[i[0]] = tree.getRoot().getId();
           i[0]++;
           
           subtree = new Tree(tree.getRoot().getRight());
           copyToList(subtree, idList, i);          
       }
   }
   
   // list must be sorted
   private static boolean reportRepeatIds(String[] list) {
       boolean repeatFound = false;
       int i = 0;
       for (i = 0; i < list.length - 1 && !repeatFound; i++) {
           repeatFound = list[i].equals(list[i + 1]);
       }
       if (repeatFound)
           System.out.println("   Error: Repeats found at array locations " + (i - 1) + " and " + i);
       return repeatFound;
   }
   
   private static boolean travelToRoot(Tree tree, String[] idList) {
       boolean rootAlwaysReached = true;
       TNode p = null;
       for (int i = 0; i < idList.length && rootAlwaysReached; i++) {
           p = tree.findNode(idList[i]);
           
           rootAlwaysReached = false;
           while (p != tree.getRoot()) {
               p = p.getParent();
           }
           rootAlwaysReached = true;           
       }
       return rootAlwaysReached;
   }
}