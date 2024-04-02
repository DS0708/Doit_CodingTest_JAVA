package Tree.세그먼트트리;

import java.util.*;
import java.io.*;

public class P073_11505 {
  static long[] segTree;
  static long mod = 1000000007;
  public static void main(String[] args) throws Exception{
    //init
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int treeHeight = 0;
    int len = n;
    while(len!=0){
      treeHeight++;
      len /=2;
    }
    int treeSize = (int)Math.pow(2,treeHeight+1);
    segTree = new long[treeSize];
    int leftStart = treeSize/2 - 1;
    //input
    for(int i=1; i <= treeSize/2; i++){
      int index = i + leftStart;
      if(i<=n){
        segTree[index] = Long.parseLong(br.readLine());
      }else{
        segTree[index] = 1;
      }
    }
    //setTree
    setTree(treeSize-1);
    //output
    for(int i=0; i<m+k; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      if(a==1){
        changeVal(b + leftStart,c);
      }else if(a==2){
        getMul(b+leftStart,c+leftStart);
      }
    }
  }
  static void setTree(int index){
    while(index > 1){
      segTree[index/2] = segTree[index] * segTree[index-1] % mod;
      index -= 2;
    }
  }
  static void changeVal(int index, int val){
    segTree[index] = val;
    while(index > 0){
      index /= 2;
      segTree[index] = segTree[index*2]%mod * segTree[index*2+1]%mod;
    }
  }
  static void getMul(int start, int end){
    long partMul = 1;
    while(start <= end){
      if(start % 2 == 1){
        partMul = partMul* segTree[start] % mod;
      }
      if(end % 2 == 0){
        partMul = partMul * segTree[end] % mod;
      }
      start = (start+1) / 2;
      end = (end-1) / 2;
    }
    System.out.println(partMul);
  }
}
