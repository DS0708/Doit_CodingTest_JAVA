package Tree.세그먼트트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P072_10868 {
  static int[] segTree;
  public static void main(String[] args) throws Exception{
    //init
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int treeHeight=0;
    int len = n;
    while(len!=0){
      len /= 2;
      treeHeight++;
    }
    int treeSize = (int)Math.pow(2,treeHeight+1);
    segTree = new int[treeSize];
    int leftStartNode = treeSize/2 - 1;
    //input
    for(int i=1; i<=treeSize/2; i++){
      int index = i + leftStartNode;
      if(i <= n)
        segTree[index] = Integer.parseInt(br.readLine());
      else
        segTree[index] = Integer.MAX_VALUE;
    }
    //setTree
    setTree(treeSize-1);
    //Logic
    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      getMin(a+leftStartNode, b+leftStartNode);
    }
  }
  static void setTree(int index){
    while(index != 1){
      segTree[index/2] = Math.min(segTree[index],segTree[index-1]);
      index -= 2;
    }
  }
  static void getMin(int start, int end){
    int minVal = Integer.MAX_VALUE;
    while(start <= end){
      if(start%2 == 1){
        minVal = Math.min(minVal, segTree[start]);
      }
      if(end%2 == 0){
        minVal = Math.min(minVal, segTree[end]);
      }
      start = (start+1)/2;
      end = (end-1)/2;
    }
    System.out.println(minVal);
  }
}
