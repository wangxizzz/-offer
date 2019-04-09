package book_note.day01;

public class 最大公约数 {

    public static int getMaxNum(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return getMaxNum(q, r);
    }

    public static void main(String[] args) {
        System.out.println(getMaxNum(1,2));
    }
}
