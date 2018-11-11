package review.day02.单例模式;

/**
 * @Author: wangxi
 * @Description : 直接同步方法，线程安全
 * @Date: 2018/8/28 0028 13:34
 */
public class Single2 {
    // 注意：singleton1一定是private,static类型。不能让外界访问到，并且应用在static方法中
    private static Single2 single2 = null;
    private Single2(){}
    // 在方法上进行同步，是线程安全的
    public static synchronized Single2 getSingle2(){
        if (single2 == null) {
            single2 = new Single2();
        }
        return single2;
    }
}
