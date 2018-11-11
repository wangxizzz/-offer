package 单例模式;

/**
 * @Author:王喜
 * @Description : 采用synchronized修饰getInstance()方法,线程安全
 * @Date: 2018/5/19 0019 12:06
 */
public class Singleton1_1 {
    private static Singleton1_1 singleton1_1 = null;
    private Singleton1_1(){}
    public static synchronized Singleton1_1 getInstance() {
        if (singleton1_1 == null) {
            singleton1_1 = new Singleton1_1();
        }
        return singleton1_1;
    }
}
