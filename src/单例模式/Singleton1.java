package 单例模式;

/**
 * @Author:王喜
 * @Description : 基础的饱汉模式，UnThreadSafe
 * @Date: 2018/5/19 0019 12:04
 */
public class Singleton1 {
    // 因为方法需要为static,方便用类名来调用，所以变量必须为static类型。
    private static Singleton1 singleton1 = null;
    private Singleton1(){}
    public static Singleton1 getInstance() {
        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }

        return singleton1;
    }
}
