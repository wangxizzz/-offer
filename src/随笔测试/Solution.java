package 随笔测试;

import java.util.*;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/6 0006 15:34
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public int InversePairs(int [] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }

        return InversePairs(array, temp, 0, array.length - 1);
    }
    private int InversePairs(int[] array, int[] temp, int start, int end){
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int leftCount = InversePairs(array, temp, start, mid) % 1000000007;
        int rightCount = InversePairs(array, temp, mid + 1, end) % 1000000007;
        int count = 0;
        int i = mid;
        int j = end;
        int k = end;
        while (i >= start && j > mid) {
            if (array[i] > array[j]) {
                count += j - mid;
                count = count % 1000000007;
                temp[k--] = array[i--];
            }else{
                temp[k--] = array[j--];
            }
        }
        while (i >= start) {
            temp[k--] = array[i--];
        }
        while (j > mid) {
            temp[k--] = array[j--];
        }
        for (int s = start; s <= end; s++) {
            array[s] = temp[s];
        }

        return (leftCount + rightCount + count) % 1000000007;
    }

    boolean isBalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        getHeight(root);
        return isBalanced;
    }
    private int getHeight(TreeNode root){
        if (root == null) {
            return 0;
        }
        // 采用后序遍历，从底往上
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return (left > right) ? (left + 1) : (right + 1);
    }
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length <= 0){
            return 0;
        }
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (curSum <= 0) {
                curSum = array[i];
            }else{
                curSum += array[i];
            }
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length <= 0){
            return 0;
        }
        int temp = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != temp) {
                count--;
            }else{
                count++;
            }
            if (count == 0) {
                temp = array[i];
                count = 1;
            }
        }
        int result = 0;
        // 判断temp是否真的存在数组中
        for (int i = 0; i < array.length; i++) {
            if (array[i] == temp) {
                result++;
            }
        }
        if (result <= array.length / 2) {
            return 0;
        }
        return temp;
    }
    public ListNode deleteDuplication(ListNode head)
    {
        if (head == null){
            return null;
        }
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode preNode = first;
        ListNode curNode = head;
        while (curNode != null && curNode.next != null) {
            if (curNode.val == curNode.next.val) {
                int val = curNode.val;
                while (curNode != null && curNode.val == val) {
                    curNode = curNode.next;
                }
                preNode.next = curNode;
            }else {
                preNode = curNode;
                curNode= curNode.next;
            }
        }
        return first.next;
    }
    boolean isSymmetrical(TreeNode root)
    {
        if (root == null) {
            return true;
        }

        return isSymmetrical(root.left, root.right);
    }
    private boolean isSymmetrical(TreeNode left, TreeNode right){
        if (left == null && right == null) {   // 只有一个节点时
            return true;
        }
        if (left == null || right == null) {   // 存在两个都为空的情况
            return  false;
        }
        if (left.val != right.val) {
            return false;
        }

        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }
    String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        return serialize(root, sb);
    }
    private String serialize(TreeNode root, StringBuilder sb){
        if (root == null) {
            return "#";
        }
        int val = root.val;
        sb.append(val + " "); // 采用先序遍历
        sb.append(serialize(root.left, sb));
        sb.append(serialize(root.right, sb));

        return sb.toString();
    }
    int index = -1;
    TreeNode Deserialize(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String[] num = str.split(" ");
        return deserialize(num);
    }
    private TreeNode deserialize(String[] num){
        index++;
        TreeNode root = null;
        if (!num[index].equals("#")) {
            root = new TreeNode(Integer.parseInt(num[index]));
            root.left = deserialize(num);
            root.right = deserialize(num);
        }
        return root;
    }
}

