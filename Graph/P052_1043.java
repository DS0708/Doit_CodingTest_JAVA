package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class P052_1043 {
  static int[] parent;
  static ArrayList<Integer>[] parties;
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int people = scanner.nextInt();
    int party_num = scanner.nextInt();
    parent = new int[people+1];
    parties = new ArrayList[party_num];

    int known_people = scanner.nextInt();
    if(known_people ==0){
      System.out.println(party_num);
      return;
    }

    //parent 초기화
    for (int i=1; i<=people; i++) parent[i] = i;
    //parties 초기화
    for (int i=0; i<party_num; i++) parties[i] = new ArrayList<>();
    //진실을 아는 사람끼리 유니온, 비교할 대표자 한명 정하기
    int known_rep = scanner.nextInt();
    for (int i=1; i<known_people; i++){
      union(known_rep,scanner.nextInt());
    }
    //parties 정보 저장
    for(int i=0; i<party_num; i++){
      int n = scanner.nextInt();
      int rep = scanner.nextInt();
      parties[i].add(rep);
      for (int j=1; j<n; j++){
        int participant = scanner.nextInt();
        parties[i].add(participant);
        union(rep,participant);
      }
    }
    //결과값 구하기
    int count=0;
    for(int i=0; i<party_num; i++){
      boolean check = true;
      for(int j : parties[i]){
        if (find(j)==find(known_rep)){
          check = false;
          break;
        }
      }
      if (check) count ++;
    }
    System.out.println(count);
  }

  static void union(int a, int b){
    a = find(a);
    b = find(b);
    if (a != b) parent[b] = a;
  }
  static int find(int num){
    if (parent[num]==num) return num;
    else return parent[num] = find(parent[num]);
  }
}
