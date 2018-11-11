package review.day02.单例模式;

/**
 * @Author: wangxi
 * @Description : 发生死锁的例子
 * @Date: 2018/8/28 0028 14:08
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        DeadLockDemo A = new DeadLockDemo();
        DeadLockDemo B = new DeadLockDemo();

        new Thread( () -> {
            synchronized (A) {    // A是一个对象，因此不需要加.class，与类锁的写法不一致
                synchronized (B) {
                    System.out.println("aaaa");  // 注意输出一些代码
                }
            }
        }).start();

        new Thread( () -> {
            synchronized (B) {
                synchronized (A) {
                    System.out.println("bbbb");
                }
            }
        }).start();
    }
}
