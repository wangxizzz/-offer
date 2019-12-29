package util;

/**
 * @Author wangxi
 * @Time 2019/12/29 21:34
 * 双向链表
 */
public class DoubleList {
    private Node head;
    private Node tail;

    public static void main(String[] args) {
        DoubleList doubleList = new DoubleList();
        int[] nums = {1,2,3};
        Node head = doubleList.getDoubleList(nums);
        doubleList.display(head);

        Node node = doubleList.new Node(2);
        Node temp = node;
        temp.val = 100;
        System.out.println(node.val);
    }

    public Node getDoubleList(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        for (int val : nums) {
            Node node = new Node(val);
            addNode2(node);
        }
        return head;
    }

    public void display(Node head) {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    /**
     * tail与node指向同一块地址空间，修改了tail里的成员变量，也就修改了node的成员值
     * 但是tail的引用发生变化，对node没有影响。
     * @param node
     */
    public void addNode2(Node node) {
        if (tail == null) {
            head = tail = node;
        } else {
            node.pre = tail;
            tail.next = node;
            tail = node;
        }
    }

    public void addNode(Node node) {
        Node t = tail;
        if (t == null) {
            head = tail = node;
        } else {
            node.pre = t;
            t.next = node;
            tail = node;
        }
    }

    public class Node {
        Node pre;
        Node next;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }
}
