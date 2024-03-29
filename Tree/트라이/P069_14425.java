package Tree.트라이;

import java.io.*;
import java.util.StringTokenizer;

public class P069_14425 {
  public static void main(String[] args) throws Exception{
    //init
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int result = 0;
    TrieNode root = new TrieNode();
    //트라이 자료구조 생성
    while(n>0){
      String str = br.readLine();
      TrieNode now = root;
      for(int i=0; i<str.length(); i++){
        char c = str.charAt(i);
        //해당 문자가 트라이에 존재하지 않다면 생성
        if(now.next[c-'a'] == null){
          now.next[c-'a'] = new TrieNode();
        }
        //다음 트라이로 이동
        now = now.next[c-'a'];
        //마지막 문자라면 isEnd = true
        if(i==str.length()-1)
          now.isEnd = true;
      }
      n--;
    }
    //트라이 자료구조 탐색
    while(m>0){
      String str = br.readLine();
      TrieNode now = root;
      for(int i=0; i<str.length(); i++){
        char c = str.charAt(i);
        //null 이라면 집합 S에 포함하지 않으므로 break;
        if(now.next[c-'a']==null)
          break;
        //다음 노드로 이동, root부터 시작하기 때문에 이제야 해당 문자로 이동한다고 보면 됨
        now = now.next[c-'a'];
        //str의 마지막 문자이고 isEnd가 true이면 count한다.
        if(i == str.length()-1 && now.isEnd)
          result++;
      }
      m--;
    }
    //결과출력
    System.out.println(result);
  }
}

class TrieNode{
  TrieNode[] next = new TrieNode[26];
  boolean isEnd;
}
