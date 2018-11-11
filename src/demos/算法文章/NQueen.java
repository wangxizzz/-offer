package demos.算法文章;

import java.util.Scanner;

/**
 * n皇后问题（采用回溯算法）
 * @author 王喜
 *
 */
public class NQueen {

	//定义皇后的个数
	private static int N;
	//定义解得个数
	private static int count = 0;
	public static void main(String[] args) {
		System.out.println("输入皇后的个数N:");
		Scanner scanner=new Scanner(System.in);
		N = scanner.nextInt();
		//初始化棋盘，全部置为0
		int chess[][] = new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				chess[i][j]=0;
			}
		}
		
		
		//每行尝试放入皇后
		putQueenAtRow(chess,0);
		
		 System.out.println("解决 " +N+ " 皇后问题 "+"解得个数是："+count);
	}
	
	
	private static void putQueenAtRow(int[][] chess, int row) {
		/**
         * 递归终止判断：如果row==N，则说明已经成功摆放了N个皇后
         * 输出结果，终止递归
         */
		if(row==N){
			count++;
			 System.out.println("第 "+ count +" 种解：");
			//输出解
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					System.out.print(chess[i][j]);
				}
				System.out.println();
			}
			return ;
		}
		
		//定义临时变量
//		int chessTemp[][] = chess;
		
		//向每一行添加一个皇后，并判断是否合适
		//遍历一行中的所有列
		for(int i=0;i<N;i++){
			//摆放这一行之前，先清除这一行的记录,防止污染棋盘
			for(int j=0;j<N;j++){
				chess[row][j]=0;
			}
			chess[row][i]=1;
			
			if(isSafety(chess, row,i)){
				//若是安全的，则继续在下一行放皇后
				putQueenAtRow(chess, row+1);
			}
			//不安全，则把皇后放入这一行的其他列
		}
		
	}
	
    private static boolean isSafety(int[][] chess,int row,int col) {
        //判断中上、左上、右上是否安全
        int step=1;
        while(row-step>=0){
            if(chess[row-step][col]==1)                //中上
                return false;
            if(col-step>=0 && chess[row-step][col-step]==1)        //左上
                return false;
            if(col+step<N && chess[row-step][col+step]==1)        //右上
                return false;
            
            step++;
        }
        return true;
    }

}
