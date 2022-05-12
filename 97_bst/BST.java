import java.util.LinkedList;
// JIMIN :: Ryan Lau, Melody Lew, Paul Serbanescu (ft. Sophia Eiden)
// APCS pd6
// HW97 -- Prune Your Tree
// 2022-05-11w
// time spent: 2.0  hrs

/**
 * class BST
 * v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 *
 * This BST implementation only holds ints (its nodes have int cargo)
 */

public class BST
{

    //instance variables / attributes of a BST:
    TreeNode _root;

    /**
     * default constructor
     */
    BST()
    {
        _root = null;
    }


    /**
     * void insert( int )
     * Adds a new data element to tree.
     */
    public void insert( int newVal )
    {
        TreeNode newNode = new TreeNode( newVal );
        if (_root == null) {
            _root = newNode;
            return;
        }
        insert(_root, newNode);
        /*** YOUR IMPLEMENTATION HERE ***/
    }
    //recursive helper for insert(int)
    public void insert( TreeNode stRoot, TreeNode newNode )
    {

        if (stRoot.getValue() > newNode.getValue()) {
            if (stRoot.getLeft() == null) {
                stRoot.setLeft(newNode);
            } else {
                insert(stRoot.getLeft(), newNode);
            }
        } else {
            if (stRoot.getRight() == null) {
                stRoot.setRight(newNode);
            } else {
                insert(stRoot.getRight(), newNode);
            }
        }
    }//end insert()



    // is jeff the GOAT?
    public String toString(){
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(_root);
        return toString(q,1,this.height());
    }


    String toString(LinkedList<TreeNode> printQueue,int layerNum,int height){
        if (height==0){return "";}
        int printLen = printQueue.size();
        int initialSpace = (int) Math.pow(2,height-layerNum)-1;
        String thisLayer = "";
        for (int sp = 0;sp<initialSpace;sp++)
            thisLayer+=" ";
        for (int i = 0; i<printLen;i++){
            TreeNode item = printQueue.removeFirst();
            if (item ==null){
                thisLayer+=" ";
                printQueue.addLast(null);
                printQueue.addLast(null);
            } else {
                thisLayer+=item.getValue();
                printQueue.addLast(item.getLeft());
                printQueue.addLast(item.getRight());
            }
            for (int sp = 0;sp<2*initialSpace+1;sp++)
                thisLayer+=" ";
        }
        if (layerNum==height){return thisLayer;}
        else {
            return thisLayer+"\n"+toString(printQueue,layerNum+1,height);
        }
    }




    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out
    // the nodes visited, in order

    //process root, recurse left, recurse right
    public void preOrderTrav()
    {
        preOrderTrav( _root );
    }
    public void preOrderTrav( TreeNode currNode )
    {
        System.out.print(currNode.getValue());

        if (currNode.getLeft() != null) {
            preOrderTrav(currNode.getLeft());
        }

        if (currNode.getRight() != null) {
            preOrderTrav(currNode.getRight());
        }
        /*** YOUR IMPLEMENTATION HERE ***/
    }

    //recurse left, process root, recurse right
    public void inOrderTrav()
    {
        inOrderTrav(_root);
        /*** YOUR IMPLEMENTATION HERE ***/
    }
    public void inOrderTrav( TreeNode currNode )
    {
        /*** YOUR IMPLEMENTATION HERE ***/
        if (currNode.getLeft() != null)
            inOrderTrav(currNode.getLeft());
        System.out.print(currNode.getValue());
        if (currNode.getRight() != null)
            inOrderTrav(currNode.getRight());
    }

    //recurse left, recurse right, process root
    public void postOrderTrav()
    {
        postOrderTrav(_root);
        /*** YOUR IMPLEMENTATION HERE ***/
    }
    public void postOrderTrav( TreeNode currNode )
    {
        /*** YOUR IMPLEMENTATION HERE ***/
        if (currNode.getLeft() != null)
            postOrderTrav(currNode.getLeft());
        if (currNode.getRight() != null)
            postOrderTrav(currNode.getRight());
        System.out.print(currNode.getValue());
    }

    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    public TreeNode search( int target )
    {
        return searchHelper(_root, target);
        /*** YOUR IMPLEMENTATION HERE ***/
    }

    public TreeNode searchHelper(TreeNode stTree, int target)
    {
        if (stTree == null) {
            return null;
        }

        if (stTree.getValue() == target) {
            return stTree;
        }

        if (stTree.getValue() > target) {
            return searchHelper(stTree.getLeft(), target);
        }


        return searchHelper(stTree.getRight(), target);
    }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height() {
        return heightHelper(_root);
    }

    //helper
    public int heightHelper(TreeNode stTree) {
        if (stTree == null) return 0;
        // uncommenting breaks toString (LOL!)
        // if (isLeaf(stTree)) return 0;
        return Math.max(heightHelper(stTree.getLeft()), heightHelper(stTree.getRight())) + 1;
    }


    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves() {
        return numLeavesHelper(_root);
    }

    public int numLeavesHelper(TreeNode stTree) {

        if (stTree == null) return 0;

        if (stTree.getLeft() == null && stTree.getRight() == null) {
            return 1;
        }

        return numLeavesHelper(stTree.getLeft()) + numLeavesHelper(stTree.getRight());
    }

    public boolean isLeaf(TreeNode node) {
      return (node.getLeft() == null && node.getRight() == null);
    }

    // void remove - removes node with value target, maintains BST
    public void remove(int target) {
      removeHelper(_root, target);
    }

    // NOTE: REMOVES ONLY LEAVES
    public void removeHelper(TreeNode node, int target) {
      // if (node == null) return;

      // if left node is target and a leaf
      if (node.getLeft() != null) {
        if (node.getLeft().getValue() == target && isLeaf(node.getLeft())) {
          // remove it
          // System.out.println("REMOICNG LEFT NODE");
          node.setLeft(null);
          // return;
        }
      }

      if (node.getRight() != null) {
        // if right node is a leaf
        if (node.getRight().getValue() == target && isLeaf(node.getRight())) {
          // System.out.println("REMOVING RIGT NODe");
          node.setRight(null);
          // return;
        }
      }

      /*

          3
         / \
        1   5
       / \ / \
      0  2 4  6


      ALGO:
      when removing a node in the left subtree, find the largest child to put in its place
      when removing a node in the right subtree, find the smallest child to put in its place
      */

      // two children

      // if (node.getLeft() != null) {
      //   if (node.getLeft().getValue() == target) {
      //     // traverse down right subtree and find largest node (lrgst node is the rightmost node)
      //     TreeNode largestNode = node.getLeft();
      //     while (largestNode.getRight() != null) {
      //       largestNode = largestNode.getRight();
      //     }
      //     largestNode.setLeft(node.getLeft());
      //     return;
      //   }
      // }

      // if (node.getRight() != null) {
      //   if (node.getRight().getValue() == target) {
      //     // System.out.println("SDFSFSDFSDFsdf");
      //     TreeNode smallestNode = node.getRight();
      //     while (smallestNode.getLeft() != null) {
      //       smallestNode = smallestNode.getLeft();
      //     }
      //     smallestNode.setRight(node.getRight());
      //     return;
      //   }
      // }

      if (node.getLeft() != null) removeHelper(node.getLeft(), target);
      if (node.getRight() != null) removeHelper(node.getRight(), target);

    }

    //main method for testing
    public static void main( String[] args ) {
        BST arbol = new BST();

        System.out.println( "tree init'd: " + arbol );

        //inserting in this order will build a perfect tree
        arbol.insert( 3 );
        arbol.insert( 1 );
        arbol.insert( 0 );
        arbol.insert( 2 );
        arbol.insert( 5 );
        arbol.insert( 4 );
        arbol.insert( 6 );

        //     3
        //    / \
        //   1   5
        //  / \ / \
        // 0  2 4  6


        //insering in this order will build a linked list to left
        /*
           arbol.insert( 6 );
           arbol.insert( 5 );
           arbol.insert( 3 );
           arbol.insert( 4 );
           arbol.insert( 2 );
           arbol.insert( 1 );
           arbol.insert( 0 );
           */

        System.out.println( "tree after insertions:\n" + arbol );
        System.out.println();

        System.out.println();
        for( int i=-1; i<8; i++ ) {
          System.out.println(" searching for "+i+": " + arbol.search(i) );    
        }
        
        System.out.println();
        System.out.println( arbol );
        
        arbol.remove(6);
        System.out.println();
        System.out.println( arbol );
        
        arbol.remove(5);
        System.out.println();
        System.out.println( arbol );
        
        /*
        arbol.remove(4);
        System.out.println();
        System.out.println( arbol );

        arbol.remove(3);
        System.out.println();
        System.out.println( arbol );

        arbol.remove(2);
        System.out.println();
        System.out.println( arbol );

        arbol.remove(1);
        System.out.println();
        System.out.println( arbol );

        arbol.remove(0);
        System.out.println();
        System.out.println( arbol );
           */
    }


}//end class
