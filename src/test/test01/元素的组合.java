package test.test01;

import java.util.ArrayList;

/**
 * @Author: wangxi
 * @Description : https://blog.csdn.net/zfyseu1/article/details/70444837
 * @Date: 2018/8/28 0028 19:52
 */
public class 元素的组合 {

    // 组合数，通过参数返回结果
    public static void Combination(char[] A,int n,int m,ArrayList<Character> t,ArrayList<ArrayList<Character>> res)
    {
        if(m==0)
        {
            ArrayList<Character> temp=new ArrayList<Character>(t);
            res.add(temp);
        }
        else
        {
            for(int i=A.length-n;i<=A.length-m;i++)
            {
                t.add(A[i]);
                Combination(A,A.length-i-1,m-1,t,res);
                t.remove(t.size()-1);
            }
        }
    }


    public static void main(String[] args) {
        char[] str={'A','B','C','D','E'};

        ArrayList<Character> t=new ArrayList<Character>();
        ArrayList<ArrayList<Character>> res=new ArrayList<ArrayList<Character>>();
        //求组合数
        Combination(str,5,3,t,res);
        System.out.println(res);
        //求全排列
//        System.out.println(Permutation(str,5,3));

    }
}
