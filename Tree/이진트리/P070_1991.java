package Tree.이진트리;

import java.util.Scanner;

public class P070_1991 {
  static int[][] binaryTree;
  public static void main(String[] args) {
    //init
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    scan.nextLine();
    binaryTree = new int[26][2];
    //input
    for(int i=0; i<n; i++){
      String[] temp = scan.nextLine().split(" ");
      int now = temp[0].charAt(0) - 'A';
      char left = temp[1].charAt(0);
      char right = temp[2].charAt(0);
      if(left == '.')
        binaryTree[now][0] = -1;
      else
        binaryTree[now][0] = left - 'A';
      if(right == '.')
        binaryTree[now][1] = -1;
      else
        binaryTree[now][1] = right - 'A';
    }
    //preorder
    preOrder(0);
    System.out.println();
    //inorder
    inOrder(0);
    System.out.println();
    //postorder
    postOrder(0);
  }
  static void preOrder(int node){
    if(node == -1) return;
    System.out.print((char)(node+'A')); //자신
    preOrder(binaryTree[node][0]);      //왼쪽
    preOrder(binaryTree[node][1]);      //오른쪽
  }
  static void inOrder(int node){
    if(node == -1) return;
    inOrder(binaryTree[node][0]);      //왼쪽
    System.out.print((char)(node+'A')); //자신
    inOrder(binaryTree[node][1]);      //오른쪽
  }
  static void postOrder(int node){
    if(node == -1) return;
    postOrder(binaryTree[node][0]);      //왼쪽
    postOrder(binaryTree[node][1]);      //오른쪽
    System.out.print((char)(node+'A'));  //자신
  }
}
