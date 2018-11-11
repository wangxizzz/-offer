package review.day02;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/8/26 0026 9:45
 */
public class 十进制变为16进制 {

    public static void convert(int n){
        char[] map = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        StringBuilder sb = new StringBuilder();
        while (n > 16) {
            int a = n % 16;
            char temp = map[a];
            n = n / 16;
            sb.insert(0, temp);
        }
        char c = map[n];
        sb.insert(0, c);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        convert(100);
    }

}
