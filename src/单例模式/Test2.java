package 单例模式;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/9/19 0019 20:28
 */
public class Test2 {
    private static volatile Test2 test2 = null;
    private Test2(){}
    public static Test2 get() {
        if (test2 == null) {
            synchronized (Test2.class) {
                if (test2 == null) {
                    test2 = new Test2();
                }
            }
        }
        return test2;
    }
}
