/**
 * Represents a node in a binary tree data structure for Morse Code conversion.
 * 
 * @param <T> type of data stored in the nodes.
 * @author Liam Ghershony
 */
public class TreeNode<T> {
	
	T data;
	TreeNode<T> left;
	TreeNode<T> right;
	
	 /**
     * Constructs new Tree Node with passed data of any type. Left and right children set to null.
     * 
     * @param data The data to be stored in the node.
     */
	
	public TreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Gets data from a node
	 * @return data --- data in the the node.
	 */
	  public T getData() {
	        return this.data;
	    }

}
