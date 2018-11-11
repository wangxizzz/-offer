package review.day02.单例模式;

/**
 * @Author: wangxi
 * @Description : 线程安全、懒加载
 * @Date: 2018/8/28 0028 13:51
 */
public class Single3 {
    private static class SingleHolder{
        private static Single3 single3 = new Single3();
        private SingleHolder(){}
    }
    private Single3(){}
    public static Single3 getSingle3(){
        // 通过包装类进行访问，Single3是没有权限访问single3。
        return SingleHolder.single3;
    }
}
