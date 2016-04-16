
public class PartB<Anytype> 
{
	class Node
	{
		Anytype data;
		Node left;
		Node right;
		
		public Node()
		{
			data = null;
		}
		
		public Node(Anytype value)
		{
			data = value;
		}
	}
	
	static Node merge(Node u, Node v)
	{
		Node dummy;
		dummy = u;
		u = v;
		v = dummy;
		
		if (u.data > v.data)
		{
			dummy = u;
			u = v;
		    v = dummy;
		}
		
		if (u.right == null)
		{
			  u.right = v;
		}
	    else // Merge recursively
		      u.right = merge(u.right, v);
		// Conditionally swap children of u
	    if (u.left == null || u.right.npl > u.left.npl)
	    {
	      dummy = u.right; 
	      u.right = u.left;
	      u.left = dummy; 
	    }
	    // Update npl values
	    if (u.right == null)
	      u.npl = 0;
	    else
	      u.npl = min(u.left.npl, u.right.npl) + 1;
	}
}