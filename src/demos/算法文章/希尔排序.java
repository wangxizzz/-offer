package demos.算法文章;

/**
 * @Author: wangxi
 * @Description : 参考网址：
 *                          1.https://www.cnblogs.com/chengxiao/p/6104371.html
 *                          2.https://mp.weixin.qq.com/s?__biz=MzU2MTI4MjI0MQ==&mid=2247483735&idx=1&sn=ce1ee1707dbc63f12130c30e6f81f24c&chksm=fc7a6cf9cb0de5efdf8d336e75ea2434049adb3f10a7c503db8fbc82abe2abc63c38872b3da7&scene=21#wechat_redirect
 * @Date: 2018/7/24 0024 22:05
 */
public class 希尔排序 {

    /**
     * 时间复杂度O(nlogn),不稳定排序，直接插入排序是一种稳定的排序
     * 希尔排序 针对有序序列在插入时采用移动法。
     * @param arr
     */
    public static void sort1(int []arr){
        //增量gap，并逐步缩小增量
        for(int gap=arr.length/2;gap>0;gap/=2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i=gap;i<arr.length;i++){
                int j = i;
                int temp = arr[j];
                if(arr[j]<arr[j-gap]){
                    while(j-gap>=0 && temp<arr[j-gap]){
                        //移动法
                        arr[j] = arr[j-gap];
                        j-=gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
