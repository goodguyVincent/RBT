
public class RedBlackNode {
	private int color;
	private String value;
	private RedBlackNode left, right;
	public RedBlackNode(String v) {
		value = v;
		color = 0;
		left = null;
		right = null;
	}
	public void switchColor() {
		color++;
		color%=2;
	}
	public void setLeft(RedBlackNode x) {
		left = x;
	}
	public void setRight(RedBlackNode x) {
		right = x;
	}
	public RedBlackNode getLeft() {
		return left;
	}
	public RedBlackNode getRight() {
		return right;
	}
	public int getColor() {
		return color;
	}
	public String getValue() {
		return value;
	}
	public String toString() {
		String l = "null", r = "null", c = "Red";
		if(left!=null)
			l = left.getValue();
		if(right!=null)
			r = right.getValue();
		if(color==1)
			c = "Black";
		return "Value:"+value+", Left:"+l+", Right:"+r+", Color:"+c;
	}
}
