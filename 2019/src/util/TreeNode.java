package util;


/**  
 * @ClassName: TreeNode  
 * @Description: 
 * @author 王喜 
 * @date 2018年3月20日 下午10:49:31  
*/
public class TreeNode {
	  public String val;
	  public TreeNode left;
	  public TreeNode right;
	  public TreeNode(String x) { val = x; }

	public TreeNode(String val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}



	public static TreeNode createSimpleTree() {
        TreeNode F = new TreeNode("F", null, null);
        TreeNode E = new TreeNode("E", null, null);
        TreeNode D = new TreeNode("D", null, E);
        TreeNode B = new TreeNode("B", null, D);
        TreeNode C = new TreeNode("C", null, F);
        TreeNode root = new TreeNode("A", B, C);
        return root;
    }

	//二叉树的创建并返回根节点
	public static TreeNode createTreeNode() {
		TreeNode a1 = new TreeNode("A1", null, null);
		TreeNode a = new TreeNode("A",a1,null);
		TreeNode b = new TreeNode("B",a,null);
		TreeNode c = new TreeNode("C",null,null);
		TreeNode d = new TreeNode("D",b,c);
		TreeNode e = new TreeNode("E",null,null);
		TreeNode f = new TreeNode("F",e,null);
		TreeNode g = new TreeNode("G",null,f);
		TreeNode h = new TreeNode("H",d,g);

		return h;
	}

	//先序遍历
	public static void preOrder(TreeNode treeNode) {
		//边界条件
		if (treeNode == null) {
			return;
		}
		System.out.print(treeNode.val + "  ");
		preOrder(treeNode.left);
		preOrder(treeNode.right);
	}
	//中序遍历
	public static void midOrder(TreeNode treeNode) {
		//边界条件
		if (treeNode == null) {
			return;
		}
		midOrder(treeNode.left);
		System.out.print(treeNode.val + "  ");
		midOrder(treeNode.right);
	}
}
