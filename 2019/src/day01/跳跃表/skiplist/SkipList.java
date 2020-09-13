package day01.跳跃表.skiplist;

import java.util.Random;

/**
 * @author wangxi created on 2020/9/13 20:31
 * @version v1.0
 *
 * https://blog.csdn.net/pcwl1206/article/details/83512600
 */
// 跳表中存储的是正整数，并且存储的数据是不重复的
public class SkipList {

    private static final int MAX_LEVEL = 16;    // 结点的个数

    private int levelCount = 1;   // 索引的层级数

    private Node head = new Node();    // 头结点

    private Random random = new Random();

    // 查找操作
    public Node find(int value){
        Node p = head;
        for(int i = levelCount - 1; i >= 0; --i){
            while(p.next[i] != null && p.next[i].data < value){
                p = p.next[i];
            }
        }

        if(p.next[0] != null && p.next[0].data == value){
            return p.next[0];    // 找到，则返回原始链表中的结点
        }else{
            return null;
        }
    }

    // 插入操作
    public void insert(int value){
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;   // 通过随机函数改变索引层的结点布置
        Node update[] = new Node[level];
        for(int i = 0; i < level; ++i){
            update[i] = head;
        }

        Node p = head;
        for(int i = level - 1; i >= 0; --i){
            while(p.next[i] != null && p.next[i].data < value){
                p = p.next[i];
            }
            update[i] = p;
        }

        for(int i = 0; i < level; ++i){
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
        if(levelCount < level){
            levelCount = level;
        }
    }

    // 删除操作
    public void delete(int value){
        Node[] update = new Node[levelCount];
        Node p = head;
        for(int i = levelCount - 1; i >= 0; --i){
            while(p.next[i] != null && p.next[i].data < value){
                p = p.next[i];
            }
            update[i] = p;
        }

        if(p.next[0] != null && p.next[0].data == value){
            for(int i = levelCount - 1; i >= 0; --i){
                if(update[i].next[i] != null && update[i].next[i].data == value){
                    update[i].next[i] = update[i].next[i].next[i];
                }
            }
        }
    }

    /**
     * 丢硬币决定 K
     * 插入元素的时候，元素所占有的层数完全是随机的。
     * 相当与做一次丢硬币的实验，如果遇到正面，继续丢，遇到反面，则停止，
     * 用实验中丢硬币的次数 K 作为元素占有的层数。
     */
    private int randomLevel(){
        int level = 1;
        for(int i = 1; i < MAX_LEVEL; ++i){
            if((random.nextInt() & 1) == 1){
                level++;
            }
        }

        return level;
    }

    // Node内部类
    public class Node{
        private int data = -1;
        private Node next[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        // 重写toString方法
        @Override
        public String toString(){
            StringBuilder builder = new StringBuilder();
            builder.append("{data:");
            builder.append(data);
            builder.append("; leves: ");
            builder.append(maxLevel);
            builder.append(" }");
            return builder.toString();
        }
    }

    // 显示跳表中的结点
    public void display(){
        Node p = head;
        while(p.next[0] != null){
            System.out.println(p.next[0] + " ");
            p = p.next[0];
        }
        System.out.println();
    }

}
