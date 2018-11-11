package demos.算法文章;

import java.util.Scanner;

/**
 * 利用动态规划求最大字段和问题
 * @author 王喜
 *
 */
public class MaxSum {

	public static void main(String[] args) {
		int i;  
        int n;  
        int []a;  
        a=new int [10];  
        Scanner in = new Scanner(System.in);  
        //当前和，最大和
        int ThisSum,MaxSum;  
        //初始化
        ThisSum=MaxSum=0;  
        n=in.nextInt();  
        for(i=0;i<n;i++)  
        {  
            a[i]=in.nextInt();  
        } 
        for(i=0;i<n;i++)  
        {  
            ThisSum+=a[i];  
            if(ThisSum>MaxSum){
            	//更新最大和
                MaxSum=ThisSum; 
            }
            else if(ThisSum<0)  
                ThisSum=0;  
        }  
        System.out.println("最大字段和是：");
        System.out.println(MaxSum);
	}

}
