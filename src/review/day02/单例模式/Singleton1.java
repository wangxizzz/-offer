package review.day02.单例模式;

/**
 * @Author: wangxi
 * @Description : 双重检测，线程安全
 * @Date: 2018/8/28 0028 13:26
 */
public class Singleton1 {
    // 注意：singleton1一定是private,static类型。不能让外界访问到，并且应用在static方法中
    private volatile static Singleton1 singleton1 = null; // 这个保证禁止指令重排序,内存可见性

    private Singleton1(){}
    public static Singleton1 getSingleTon() {
        if (singleton1 == null) {
            // 锁住的是类锁。（因为是静态方法）
            // synchronized对象锁，类锁时需要变成对象
            synchronized (Singleton1.class) {  // 这个保证在同一时间只有一个线程可以持有锁
                // 对象的创建是需要一定的时间的
                if (singleton1 == null) {
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;
    }
}
