package test.test01;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Point{
    private final int x;
    private final int y;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    public String makeString(){
        char[] cArray = new char[2];
        cArray[0] = (char) ('0' + x);
        cArray[1] = (char) ('0' + y);
        return new String(cArray);
    }

    public Point add(int aX,int aY){
        return new Point(x+aX,y+aY);
    }

    public Point add(Point p){
        return new Point(x + p.getX(),y+p.getY());
    }
}
class Node{
    private Point nodePoint;
    private List<Node> children;
    private Node parent;
    public Node(int x, int y){
        this.nodePoint = new Point(x,y);
    }
    public Point getNodePoint() {
        return nodePoint;
    }
    public void setNodePoint(Point nodePoint) {
        this.nodePoint = new Point(nodePoint.getX(),nodePoint.getY());
    }
    public List<Node> getChildren() {
        return children;
    }
    public void setChildren(List<Node> children) {
        this.children = children;
    }
    public Node getParent() {
        return parent;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void addChild(Node child){
        child.setParent(this);
        if(null == children){
            children = new ArrayList<Node>();
        }
        children.add(child);
    }

}
public class HorseStep {

    private static  Point[] POINTS = new Point[]{new Point(2,1),new Point(-2,-1),new Point(2,-1),new Point(-2,1),new Point(1,2),new Point(1,-2),new Point(-1,2),new Point(-1,-2)};

    public int step(int startX,int startY,int endX,int endY,int n){
        Map<String,Integer> flagMap = new HashMap<String,Integer>();
        ArrayDeque<Node> nodeStack = new ArrayDeque<Node>();
        Node parent = new Node(startX,startY);
//        System.out.println("at :" + startX + "," + startY);
        flagMap.put(parent.getNodePoint().makeString(),0);
        nodeStack.push(parent);
        boolean found = false;
        while(!found && !nodeStack.isEmpty()){
            Node curNode = nodeStack.pop();
            Point curP = curNode.getNodePoint();
            int depth = flagMap.get(curP.makeString());
            for(int i = 0; i < POINTS.length;i++){
                Point p = curP.add(POINTS[i]);
                if(p.getX() > n || p.getY() > n || p.getX() < 0 || p.getY() < 0){
                    continue;
                }
                //System.out.println((depth + 1) + " step, (" + curP.getX() + "," + curP.getY()+  ") -> (" + p.getX() + "," + p.getY() + ")");
                Node newNode = new Node(p.getX(),p.getY());
                if(null == flagMap.get(p.makeString())) {
                    flagMap.put(p.makeString(), depth + 1);
                    curNode.addChild(newNode);
                    nodeStack.add(newNode);
                }
                if(p.getX() == endX && p.getY() == endY){
                    found = true;
                    printTrace(newNode);
                    return flagMap.get(p.makeString());
                }
            }
        }
        return -1;
    }

    private void printTrace(Node newNode) {
        Stack<Node> trace = new Stack<Node>();
        Node cur = newNode;
        while(cur != null){
            trace.push(cur);
            cur = cur.getParent();
        }
        StringBuffer buffer = new StringBuffer();
        while(!trace.isEmpty()){
            Node n = trace.pop();
            buffer.append("(" );
            buffer.append(n.getNodePoint().getX() );
            buffer.append("," );
            buffer.append(n.getNodePoint().getY() );
            buffer.append(")" );
            buffer.append("->" );
        }
        String s = buffer.toString();
        //System.out.println(s.substring(0,s.length() - 2));
    }

    public static void main(String[] args){
        HorseStep hs = new HorseStep();
        System.out.println(hs.step(0, 0, 1,1, 8));//output:4,(0,0)->(2,1)->(4,2)->(2,3)->(1,1)


    }

}

