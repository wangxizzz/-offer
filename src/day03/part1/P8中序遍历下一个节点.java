package day03.part1;

/**
 * @Author:王喜
 * @Description : 中序遍历下一个节点
 * @Date: 2018/5/24 0024 10:38
 */
public class P8中序遍历下一个节点 {
    /**
     *
     * @param pNode 给出节点PNode，找出它的下个节点，可以举例子
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null) {
            return null;
        }
        // 以右子树为标准
        if (pNode.right != null) {
            TreeLinkNode curNode = pNode.right;
            while (curNode.left != null){
                curNode = curNode.left;
            }
            return curNode;
        }else{
            TreeLinkNode curNode = pNode;
            while (curNode.next != null) {
                if (curNode.next.left == curNode) {
                    return curNode.next;
                }
                curNode = curNode.next;
            }
        }
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
