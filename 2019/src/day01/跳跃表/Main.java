package day01.跳跃表;

/**
 * <Description>
 *
 * @author wangxi
 */
public class Main {
    public static void main(String[] args) {
        SkipList<String> list=new SkipList<String>();
        System.out.println(list);
        list.put(2, "yan");
        list.put(1, "co");
        list.put(3, "feng");
        list.put(1, "cao");//测试同一个key值
        list.put(4, "曹");
        list.put(6, "丰");
        list.put(5, "艳");
        System.out.println(list);
        System.out.println(list.size());
    }
}

