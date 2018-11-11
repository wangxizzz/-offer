package demos.算法文章;
/**
 * 利用回溯法解TSP问题
 * @author 王喜
 *
 */
public class TSP {

	private static int N = 4;

    private int cl; //当前路径的长度
    private int fl; //当前只当的最大路径长度

    //权重值
    private int weight[][] = {
            {0, 30, 6, 5},
            {30, 0, 4, 10},
            {6, 4, 0, 20},
            {5, 10, 20, 0}
//            {0, 13, 8, 9},
//            {13, 0, 3, 15},
//            {8, 3, 0, 20},
//            {9, 15, 20, 0}
    };
    //当前路径
    private int x[] = new int[4];
    //最优路径
    private int bestX[] = new int[4];

    public int[] getBestX() {
        return bestX;
    }

    public int getMinLen(){
        return fl;
    }
    /**
     * 判断第k个数是否不同与前k-1个数
     * @param k
     * @return bool
     */
    private boolean nextValue(int k){
        int i = 0;
        while(i < k){
            if(x[k] == x[i]){
                return false;
            }
            i += 1;
        }
        return true;
    }

    /**
     * 第k条路径选择
     * @param k
     */
    private void backUp(int k){
    	//到最后一个顶点
        if(k==N-1){
            for (int j=1;j<=N;j++){
                x[k] = Math.floorMod(x[k]+1, N);
                if(nextValue(k) && cl + weight[x[k-1]][x[k]] + weight[x[k]][0] < fl) {
                	//如果最短路径,更新最优解
                    fl = cl + weight[x[k - 1]][x[k]] + weight[x[k]][0];
                    for (int i = 0; i < N; i++) {
                        bestX[i] = x[i];
                    }
                }
            }
        }else{
            for(int j=1; j<=N; j++){
            	//返回不大于a的最大整数
                x[k] = Math.floorMod(x[k]+1, N);
                if(nextValue(k) && cl+weight[x[k-1]][x[k]] <= fl){
                    //此路可行
                    cl += weight[x[k-1]][x[k]];
                    backUp(k+1);
                    //此路不可以，回溯
                    cl -= weight[x[k-1]][x[k]];
                }
            }

        }
    }
    public void solve(){
        int k = 1; //第0个顶点是固定的,从第一个顶点A开始选择
        cl = 0;
        //初始化最优解
        fl = Integer.MAX_VALUE;
        backUp(k);
}
	
	
	public static void main(String[] args) {
		TSP tsp=new TSP();
		tsp.solve();
		System.out.println("最短路径长度是："+tsp.getMinLen());
		int bestx[]=tsp.getBestX();
		System.out.println("最短路径是：");
		for(int i=0;i<bestx.length;i++){
			System.out.print(bestx[i]+"  ");
		}
	}

}
