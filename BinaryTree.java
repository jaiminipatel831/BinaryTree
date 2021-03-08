 
import java.util.Random;

public class BinaryTree {
	
	class Node 
	{
		int age;
                String firstName;
                String lastName;
		Node left, right;
                public Node(){
                    left=right=null;
                }
               public Node(int age, String firstName, String lastName){
                   this.age = age;
                   this.firstName = firstName;
                   this.lastName = lastName;
               }
	}

	
	Node root;

		BinaryTree() 
	{ 
		root = null; 
	}

	
	void insert(int key,String firstName,String lastName) 
	{ 
		root = insertRec(root, key,firstName,lastName);
                root.age= key;
                root.firstName =firstName;
                root.lastName = lastName;
	}

	Node insertRec(Node root, int key,String firstName,String lastName)
	{

		if (root == null) 
		{
			root = new Node(key,firstName,lastName);
			return root;
		}

		
		if (key < root.age)
			root.left = insertRec(root.left, key,firstName,lastName);
		else if (key > root.age)
			root.right = insertRec(root.right, key,firstName,lastName);

	
		return root;
	}

	
	void inorder() 
	{ 
		inorderRec(root); 
	}
        
        void getLeftMost(){
            Node p =root;
            while(p.left!=null){
                p=p.left;
            }
            System.out.println("Left Most Node Details: ");
            System.out.println("Age : " + String.valueOf(p.age));
            System.out.println("Firstname : " + String.valueOf(p.firstName));
            System.out.println("Lastname : " + String.valueOf(p.lastName));
        }
        void getRightMost(){
            Node p =root;
            while(p.right!=null){
                p=p.right;
            }
            System.out.println("Right Most Node Details: ");
            System.out.println("Age : " + String.valueOf(p.age));
            System.out.println("Firstname : " + String.valueOf(p.firstName));
            System.out.println("Lastname : " + String.valueOf(p.lastName));
        }
        
         void getRoot(){
            Node p =root;
            
            System.out.println("Root Node Details: ");
            System.out.println("Age : " + String.valueOf(p.age));
            System.out.println("Firstname : " + String.valueOf(p.firstName));
            System.out.println("Lastname : " + String.valueOf(p.lastName));
        }

	void inorderRec(Node root)
	{
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.age);
			inorderRec(root.right);
		}
	}
       

	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
                String[] firstNames = new String[]{"John","Tom","Latham","Jerry","Andrew","William"};
                String[] lastNames = new String[]{"Williamson","Harryson","Anderson","Broad","Page","Bin"};
                Random r = new Random();
                for(int i=0;i<100;i++){
                    int age = r.nextInt(81)+5; 
                    String firstName = firstNames[r.nextInt(6)];
                    String lastName = lastNames[r.nextInt(6)];
                 //   System.out.println(String.valueOf(age)+ " "+ String.valueOf(i));
                    tree.insert(age,firstName,lastName);
                }
	
                tree.getLeftMost();
                tree.getRoot();
                tree.getRightMost();
               
	}
}
