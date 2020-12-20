package book_note.day02;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description>
 *
 * @author wangxi
 */
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String s = "abc";
        list.add(s);
        String ss = s;
        s = s + 'g';
        System.out.println(ss);
        System.out.println(list);

        new Test().permutation("abc");

        System.out.println((int)'a');
    }


    public String[] permutation(String s) {
        return null;
    }
}

