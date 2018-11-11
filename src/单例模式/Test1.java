package 单例模式;

/**
 * @Author: wangxi
 * @Description :
 * @Date: 2018/9/19 0019 20:26
 */
public class Test1 {

    private static Test1 test1 = new Test1();
    private Test1(){}
    public static Test1 get() {
        return test1;
    }
}
