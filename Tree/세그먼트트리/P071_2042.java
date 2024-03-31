package Tree.세그먼트트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P071_2042 {
  static long[] segTree;
  public static void main(String[] args) throws Exception{
    //init
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    //트리 높이, 사이즈 구하기
    int treeHeight = 0;
    int len = n;
    while(len !=0){
      len /= 2;
      treeHeight++;
    }
    int treeSize = (int)Math.pow(2,treeHeight+1);
    int leftNodeStart = treeSize/2 -1;
    segTree = new long[treeSize];
    //초기 트리 만들기
    for(int i=1; i<=n; i++){
      int index = i+leftNodeStart;
      segTree[index] = Long.parseLong(br.readLine());
    }
    setTree(treeSize-1);
    //결과 처리
    for(int i=0; i<m+k; i++){
      st = new StringTokenizer(br.readLine());
      long a = Long.parseLong(st.nextToken());
      long b = Long.parseLong(st.nextToken());
      long c = Long.parseLong(st.nextToken());
      if(a==1){
        changeVal((int)b+leftNodeStart,c);
      }else if(a==2){
        getSum((int)b+leftNodeStart,(int)c+leftNodeStart);
      }
    }

  }

  static void setTree(int index){
    while(index > 1){
      segTree[index/2] += segTree[index];
      index --;
    }
  }

  static void changeVal(int index, long val){
    long diff = val - segTree[index];
    while(index != 0){
      segTree[index] += diff;
      index /= 2;
    }
  }

  static void getSum(int start, int end){
    long partSum = 0;
    while(start <= end){
      if( start % 2 == 1){
        partSum +=segTree[start];
      }
      if(end % 2 ==0){
        partSum +=segTree[end];
      }
      start = (start+1)/2;
      end = (end-1)/2;
    }
    System.out.println(partSum);
  }
}
