package 单例模式;

/**
 * @Author:王喜
 * @Description : 饿汉模式 ThreadSafe
 * @Date: 2018/5/19 0019 12:17
 */
public class Singleton2 {
    /**
     * 1.饿汉的好处是天生的线程安全（得益于类加载机制），写起来超级简单，
     *      使用时没有延迟；坏处是有可能造成资源浪费（如果类加载后就一直不使用单例的话）。
     *
     * 2.值得注意的时，单线程环境下，饿汉与饱汉在性能上没什么差别；但多线程环境下，
     *      由于饱汉需要加锁，饿汉的性能反而更优。
     */
    private static Singleton2 singleton2 = new Singleton2();
    private Singleton2(){}
    public static Singleton2 getInstance() {
        return singleton2;
    }
}
