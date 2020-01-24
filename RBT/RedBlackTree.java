
public class RedBlackTree {
	private RedBlackNode root;
	public RedBlackTree() {
		root = null;
	}
	public void add(RedBlackNode x) {
		if(root==null) {
			x.switchColor();
			root = x;
			return;
		}
		root = add(root, x);
		if(root.getColor()==0)
			root.switchColor();
	}
	public RedBlackNode add(RedBlackNode x, RedBlackNode target) {
		if(x.getLeft()!=null && x.getRight()!=null && x.getLeft().getColor()==0 && x.getRight().getColor()==0) {
			x.getLeft().switchColor();
			x.getRight().switchColor();
			x.switchColor();
			if(root.getColor()==0)
				root.switchColor();
		}
		int dir = target.getValue().compareTo(x.getValue());
		if(dir>0) {
			if(x.getRight()==null)
				x.setRight(target);
			else
				x.setRight(add(x.getRight(), target));
		}
		else if(dir<0) {
			if(x.getLeft()==null)
				x.setLeft(target);
			else
				x.setLeft(add(x.getLeft(), target));
		}
		RedBlackNode return_node = x;
		if(return_node.getLeft()!=null && return_node.getLeft().getLeft()!=null && return_node.getLeft().getColor()==0 && return_node.getLeft().getLeft().getColor()==0) {
			RedBlackNode parent = return_node.getLeft();
			return_node.setLeft(parent.getRight());
			parent.setRight(return_node);
			parent.switchColor();
			parent.getRight().switchColor();
			return_node = parent;
		}
		else if(return_node.getLeft()!=null && return_node.getLeft().getRight()!=null && return_node.getLeft().getColor()==0 && return_node.getLeft().getRight().getColor()==0) {
			RedBlackNode parent = return_node.getLeft();
			RedBlackNode child = parent.getRight();
			parent.setRight(child.getLeft());
			child.setLeft(parent);
			return_node.setLeft(child);
			
			parent = return_node.getLeft();
			return_node.setLeft(parent.getRight());
			parent.setRight(return_node);
			parent.switchColor();
			parent.getRight().switchColor();
			return_node = parent;
		}
		else if(return_node.getRight()!=null && return_node.getRight().getRight()!=null && return_node.getRight().getColor()==0 && return_node.getRight().getRight().getColor()==0) {
			RedBlackNode parent = return_node.getRight();
			return_node.setRight(parent.getLeft());
			parent.setLeft(return_node);
			parent.switchColor();
			parent.getLeft().switchColor();
			return_node = parent;
		}
		else if(return_node.getRight()!=null && return_node.getRight().getLeft()!=null && return_node.getRight().getColor()==0 && return_node.getRight().getLeft().getColor()==0) {
			RedBlackNode parent = return_node.getRight();
			RedBlackNode child = parent.getLeft();
			parent.setLeft(child.getRight());
			child.setRight(parent);
			return_node.setRight(child);
			
			parent = return_node.getRight();
			return_node.setRight(parent.getLeft());
			parent.setLeft(return_node);
			parent.switchColor();
			parent.getLeft().switchColor();
			return_node = parent;
		}
		return return_node;
	}
	public String toString() {
		return preOrder(root);
	}
	private String preOrder(RedBlackNode x) {
		if(x==null)
			return "";
		return x.toString()+"\n" + preOrder(x.getLeft()) + preOrder(x.getRight());
	}
}
