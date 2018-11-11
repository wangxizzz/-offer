package 单例模式;

/**
 * @Author:王喜
 * @Description : synchronized(注意不是在方法上) + volatile ,ThreadSafe
 * @Date: 2018/5/19 0019 12:09
 */
public class Singleton1_2 {
    private static volatile Singleton1_2 singleton1_2 = null;
    private Singleton1_2(){}
    public static Singleton1_2 getInstance() {
        if (singleton1_2 == null) {
            //对象锁
            synchronized (Singleton1_2.class) {
                if (singleton1_2 == null) {
                    singleton1_2 = new Singleton1_2();
                }
            }
        }
        return singleton1_2;
    }
}
