import java.util.ArrayList;
import java.util.Stack;

/**
 * Builds a MorseCodeTree used to convert Morse code into English.
 * 
 * @author Liam Ghershony
 */

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	
	
	public MorseCodeTree() {
		buildTree();
	}
	
	// root
	private TreeNode<String> root;

	
	
	/**
     * Returns root of Tree.
     * 
     * @return The root node of the tree.
     */
	
	@Override
	public TreeNode<String> getRoot() {
		return this.root;
	}

	
    /**
     * Sets root of the Tree.
     * 
     * @param newNode The set root node of tree.
     */
	
	@Override
	public void setRoot(TreeNode<String> newNode) {

		this.root = newNode;
	}

	
	
    /**
     * Inserts a letter into the Morse Code Tree based on dots and dashes.
     * 
     * @param code --- The Morse code for the letter being inserted.
     * @param result --- The letter to insert.
     */
	
	@Override
	public void insert(String code, String result) {
		TreeNode<String> current = this.root;
		for(int i=0; i<code.length(); i++) {
			char iterateChar = code.charAt(i);
			if (iterateChar == '.') {
				if(current.left == null) {
					current.left = new TreeNode<>(null);
				}
				current = current.left;
			}else if (iterateChar == '-') {
				if(current.right == null) {
					current.right = new TreeNode<>(null);
			}
			current = current.right;
		}
	}
		current.data = result;
	}

	
	
	
	
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		// TODO Auto-generated method stub
		
	}

    /**
     * Fetches the letter corresponding to the given code.
     * 
     * @param code --- The Morse code to be converted into a letter.
     * @return The English letter for that Morse code.
     */
	
	@Override
	public String fetch(String code) {
		return fetchNode(this.root, code);
	}
	
	
	  /**
     * Fetches an English letter from one node in the tree given some Morse code.
     * 
     * @param root --- The root node 
     * @param code --- The Morse code that corresponds to the desired letter.
     * @return The English letter for that Morse code.
     */
	
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if(code.isEmpty()) {
			return root.data;
		}
		char recursiveChar = code.charAt(0);
		if (recursiveChar == '.') {
			return fetchNode(root.left, code.substring(1));
		}
		if (recursiveChar == '-') {
			return fetchNode(root.right, code.substring(1));
	}
		return null;
		
	}

	
	
	  /**
     * Unsupported operation
     * 
     * @param data ---  Data of node to be deleted.
     * @throws UnsupportedOperationException.
     */
	
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
	    
		throw new UnsupportedOperationException("Delete operation is not supported");
	}

	  /**
     * Unsupported operation
     * 
     * @throws UnsupportedOperationException.
     */
	
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
	    throw new UnsupportedOperationException("Update operation is not supported");

	}

	  /**
     * Builds the Tree with pairings of Morse Code and their corresponding letters.
     */
	
	@Override
	public void buildTree() {

		this.root = new TreeNode<String>("");
		
		 insert(".", "e");  
		 insert("-", "t");  
		 insert("..", "i"); 
         insert(".-", "a"); 
   	     insert("-.", "n"); 
		 insert("--", "m"); 
		 insert("...", "s"); 
		 insert("..-", "u"); 
		 insert(".-.", "r"); 
		 insert(".--", "w"); 
		 insert("-..", "d"); 
		 insert("-.-", "k"); 
		 insert("--.", "g"); 
	     insert("---", "o"); 
		 insert("....", "h"); 
		 insert("...-", "v"); 
		 insert("..-.", "f"); 
		 insert(".-..", "l"); 
		 insert(".--.", "p"); 
		 insert(".---", "j"); 
		 insert("-...", "b"); 
		 insert("-..-", "x"); 
		 insert("-.-.", "c"); 
		 insert("-.--", "y"); 
		 insert("--..", "z"); 
		 insert("--.-", "q");
	}

    /**
     * Converts the Morse Code Tree into an ArrayList by using in-order traversal.
     * 
     * @return An ArrayList containing the elements from the Morse Code Tree.
     */
	
	@Override
	public ArrayList<String> toArrayList() {
	    ArrayList<String> list = new ArrayList<>();
	    LNRoutputTraversal(this.root, list );
	    System.out.println(list.toString());
	    return list;
	}

	  /**
     * Performs in-order traversal of the Tree and adds nodes to the Arraylist.
     * 
     * @param root -- node to start traversal from.
     * @param list -- The ArrayList with Morse Code Tree elements.
     */
	
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		Stack<TreeNode<String>> stack = new Stack<>();
	    TreeNode<String> current = root;

	    while (current != null || !stack.isEmpty()) {
	        while (current != null) {
	            stack.push(current);
	            current = current.left;
	        }

	        current = stack.pop();
	        
	        if (current.data != null) {
	            list.add(current.data);
	        }
	        
	        current = current.right;
	    }
	}

}
