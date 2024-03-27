package Graph.그래프의표현;

import java.io.*;
import java.util.*;

public class P049_2251 {
  static int ABC[];
  static ArrayList<Integer> answer;
  static TreeSet<Node> visited;
  static Queue<Node> queue;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    ABC = new int[3];
    for (int i=0; i<3; i++){
      ABC[i] = Integer.parseInt(st.nextToken());
    }

    answer = new ArrayList<>();
    visited = new TreeSet<>();

    BFS();

    Collections.sort(answer);

    for(int i : answer) System.out.print(i+ " ");
  }

  static void BFS(){
    queue = new ArrayDeque<>();
    Node start = new Node(0,0,ABC[2]);
    visited.add(start);
    queue.add(start);
    answer.add(ABC[2]);

    while(!queue.isEmpty()){
      Node current = queue.poll();
      for (int i=0; i<3; i++){
        if (current.containers[i] !=0){
          from(current,i);
        }
      }
    }
  }

  static void from(Node current, int from) {
    for (int to = 0; to < 3; to++) {
      if (to == from) continue; // 같은 컨테이너로는 옮길 수 없음

      int[] newContainers = Arrays.copyOf(current.containers, current.containers.length);
      int moveAmount = Math.min(newContainers[from], ABC[to] - newContainers[to]); // 실제로 옮길 수 있는 물의 양

      // 물을 옮김
      newContainers[from] -= moveAmount;
      newContainers[to] += moveAmount;

      Node newNode = new Node(newContainers[0], newContainers[1], newContainers[2]);

      if (!visited.contains(newNode)) {
        visited.add(newNode);
        queue.add(newNode);
        if (newNode.containers[0] == 0) { // A가 비어있을 때만 C의 값을 추가
          answer.add(newNode.containers[2]);
        }
      }
    }
  }

}

class Node implements Comparable<Node>{
  int[] containers = new int[3]; // A, B, C를 배열로 처리
  public Node(int A,int B,int C){
    this.containers[0] = A;
    this.containers[1] = B;
    this.containers[2] = C;
  }

  @Override
  public int compareTo(Node o) {  //1, 0 ,-1 값이 모두 존재해야 정상적으로 TreeSet이 동작한다.
    if (this.containers[0] != o.containers[0])
      return Integer.compare(this.containers[0], o.containers[0]);
    else if (this.containers[1] != o.containers[1])
      return Integer.compare(this.containers[1], o.containers[1]);
    else
      return Integer.compare(this.containers[2], o.containers[2]);
  }
}

