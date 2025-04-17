class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	   /*
	   pre-order traversal
	   Prints the value of every node preorder
	   @param Node root for a BST
	   */
	  public void preOrderTraversal(Node root){
		if (root != null) {
			System.out.println(root.value); //prints value
			preOrderTraversal(root.left); //go left
			preOrderTraversal(root.right); //go right
		}
	   
   	}

	   
	   
	   /*
	   in-order traversal
	   Prints every node in order
	   @param Node root for a BST
	   */
	  public void inOrderTraversal(Node root){
		if (root != null) {
		  inOrderTraversal(root.left); //go left
		  System.out.println(root.value); //prints value
		  inOrderTraversal(root.right); //go right
		}
 	}
	   
	   
	   
	   /*
	   post-order traversal
	   Prints every node in post order
	   @param Node root of a BST
	   */
	  public void postOrderTraversal(Node root){
		if (root != null) {
		   postOrderTraversal(root.left); //go left
		   postOrderTraversal(root.right); // go right
		   System.out.println(root.value); //print value
		}
		  
	  }
	   
	   
	   /*
	   *find
	   *a method to find the node in the tree
	   *with a specific value
	   *@param Node root for BST
	   *@param int key to search for
	   *@return boolean true if found or false if not
	   */
	  public boolean find(Node root, int key){
		//base case, root is null:
	   if (root == null) {
		   return false;
		}

	   //case for if key is found
	   if (key == root.value) {
		   return true;
	   } else if (key < root.value) {
		   return find(root.left, key);
	   } else {
		   return find(root.right, key);
	   }
	 
  	}
	   
	   
	   
	   /*
	   *getMin
	   *A method to get the min value in BST
	   *@param Node root of BST
	   *@return int of min value
	   */
	  public int getMin(Node root){
		Node pos = root;

		//traverse the BST to the leftmost node:
		while (pos.left != null) {
			pos = pos.left;
		}
		
		return pos.value;
   	}
	  
	  
	  
	   /*
	   getMax
	   a method to find the node in the tree
	   with a largest key
	   @param Node root of BST
	   @return int of max value in BST
	   */
	  public int getMax(Node root){
		Node pos = root;

		//traverse the BST to the rightmost node:
		while (pos.right != null) {
		   pos = pos.right;
		}

		return pos.value;
	  }
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemo{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();
	           
	      
	   }  
	}
