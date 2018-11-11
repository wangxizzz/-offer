package 单例模式;

/**
 * @Author:王喜
 * @Description : Holder模式 ThreadSafe
 *                  参考地址：http://www.importnew.com/27056.html
 * @Date: 2018/5/19 0019 12:18
 */
public class Singleton3 {
    static class SingletonHolder {
        private static Singleton3 singleton3 = new Singleton3();
        private SingletonHolder(){}
    }
    private Singleton3(){};
    public static Singleton3 getInstance() {
        return SingletonHolder.singleton3;
    }
}
